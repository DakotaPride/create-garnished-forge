package net.dakotapride.creategarnished.entity.squirrel;

import net.dakotapride.creategarnished.registry.CreateGarnishedEntityTypes;
import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.dakotapride.creategarnished.registry.CreateGarnishedTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.SectionPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class SquirrelEntity extends TamableAnimal implements VariantHolder<SquirrelEntity.Type> {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState sittingAnimationState = new AnimationState();
    private int sittingAnimationTimeout = 0;
    public final AnimationState dancingAnimationState = new AnimationState();
    private int dancingAnimationTimeout = 0;

    private static final EntityDataAccessor<Integer> DATA_TYPE_ID = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> EAT_COUNTER = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DANCING = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.BOOLEAN);

    @javax.annotation.Nullable
    private BlockPos jukebox;

    public SquirrelEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
        this.setTame(false, false);
        this.setCanPickUpLoot(true);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @javax.annotation.Nullable SpawnGroupData spawnGroupData) {
        Holder<Biome> holder = level.getBiome(this.blockPosition());
        Type squirrelType = Type.byBiome(holder);
        boolean flag = false;
        if (spawnGroupData instanceof SquirrelGroupData squirrelGroupData) {
            squirrelType = squirrelGroupData.type;
            if (squirrelGroupData.getGroupSize() >= 2) {
                flag = true;
            }
        } else {
            spawnGroupData = new SquirrelGroupData(squirrelType);
        }

        this.setVariant(squirrelType);

        if (flag) {
            this.setAge(-24000);
        }

        this.populateDefaultEquipmentSlots(level.getRandom(), difficulty);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    public static boolean checkSquirrelSpawnRules(EntityType<? extends Animal> animal, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        //boolean flag = MobSpawnType.ignoresLightRequirements(spawnType) || isBrightEnoughToSpawn(level, pos);
        return level.getBlockState(pos.below()).is(BlockTags.DIRT) || level.getBlockState(pos.below()).is(BlockTags.BASE_STONE_OVERWORLD);
    }

    @Override
    protected void applyTamingSideEffects() {
        if (this.isTame()) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(12.0);
            this.setHealth(12.0F);
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(6.0);
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!this.level().isClientSide || this.isBaby() && this.isFood(itemstack)) {
            if (this.isTame()) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    FoodProperties foodproperties = itemstack.getFoodProperties(this);
                    float f = foodproperties != null ? (float)foodproperties.nutrition() : 1.0F;
                    this.heal(2.0F * f);
                    itemstack.consume(1, player);
                    this.gameEvent(GameEvent.EAT); // Neo: add EAT game event
                    return InteractionResult.sidedSuccess(this.level().isClientSide());
                } else {
                    InteractionResult interactionresult = super.mobInteract(player, hand);
                    if (!interactionresult.consumesAction() && this.isOwnedBy(player)) {
                        this.setOrderedToSit(!this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        this.setTarget(null);
                        return InteractionResult.SUCCESS_NO_ITEM_USED;
                    } else {
                        return interactionresult;
                    }
                }
            } else if (isFood(itemstack)) {
                itemstack.consume(1, player);
                this.tryToTame(player);
                return InteractionResult.SUCCESS;
            } else {
                return super.mobInteract(player, hand);
            }
        } else {
            boolean flag = this.isOwnedBy(player) || this.isTame() || isFood(itemstack) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        }
    }

    private void tryToTame(Player player) {
        if (this.random.nextInt(3) == 0  && !EventHooks.onAnimalTame(this, player)) {
            this.tame(player);
            this.navigation.stop();
            this.setTarget(null);
            this.setOrderedToSit(true);
            this.level().broadcastEntityEvent(this, (byte)7);
        } else {
            this.level().broadcastEntityEvent(this, (byte)6);
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_TYPE_ID, 0);
        builder.define(EAT_COUNTER, 0);
        builder.define(DANCING, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Type", this.getVariant().getSerializedName());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setVariant(Type.byName(compound.getString("Type")));
    }

    @Override
    protected void registerGoals() {
        // 0 highest
        // this.goalSelector.addGoal(0, <goal>)
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.has(DataComponents.FOOD), false));

        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));

        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F));

        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.goalSelector.addGoal(11, new SearchForItemsGoal());

        this.goalSelector.addGoal(7, new MoveToFarmlandGoal(this, 1.0F, 240));
        this.goalSelector.addGoal(7, new MoveToTreePlantableBlockGoal(this, 1.0F, 240));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 6.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Override
    public void aiStep() {
        if (this.jukebox == null || !this.jukebox.closerToCenterThan(this.position(), 16) || !this.level().getBlockState(this.jukebox).is(Blocks.JUKEBOX)) {
            setDancing(false);
            this.jukebox = null;
        }

        super.aiStep();
    }

    @Override
    public void setRecordPlayingNearby(BlockPos pos, boolean isDancing) {
        this.jukebox = pos;
        setDancing(isDancing);
    }

    public boolean isDancing() {
        return this.entityData.get(DANCING);
    }

    public void setDancing(boolean dancing) {
        this.entityData.set(DANCING, dancing);
    }

    public boolean isEating() {
        return this.entityData.get(EAT_COUNTER) > 0;
    }

    public void eat(boolean eating) {
        this.entityData.set(EAT_COUNTER, eating ? 1 : 0);
    }

    private int getEatCounter() {
        return this.entityData.get(EAT_COUNTER);
    }

    private void setEatCounter(int eatCounter) {
        this.entityData.set(EAT_COUNTER, eatCounter);
    }

    private boolean isValidToConsumePersonally(ItemStack stack) {
        if (this.isTame()) {
            return isFood(stack) && !stack.is(CreateGarnishedTags.NUT_SAPLINGS) && !stack.is(CreateGarnishedItems.PEANUT);
        } else return isFood(stack);
    }

    private void handleEating() {
        if (!this.isEating() && !this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()
                && this.isValidToConsumePersonally(this.getItemBySlot(EquipmentSlot.MAINHAND)) && this.random.nextInt(40) == 1) {
            this.eat(true);
        } else if (this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) {
            this.eat(false);
        }

        if (this.isEating()) {
            this.addEatingParticles();
            if (!this.level().isClientSide && this.getEatCounter() > 40 && this.random.nextInt(20) == 1) {
                if (this.getEatCounter() > 50 && this.isValidToConsumePersonally(this.getItemBySlot(EquipmentSlot.MAINHAND))) {
                    if (!this.level().isClientSide) {
                        this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                        this.gameEvent(GameEvent.EAT);
                    }
                }

                this.eat(false);
                return;
            }

            this.setEatCounter(this.getEatCounter() + 1);
        }
    }

    private void addEatingParticles() {
        if (this.getEatCounter() % 5 == 0) {
            this.playSound(SoundEvents.GENERIC_EAT, 0.5F + 0.5F * (float)this.random.nextInt(2), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);

            for (int i = 0; i < 6; i++) {
                Vec3 vec3 = new Vec3(((double)this.random.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, ((double)this.random.nextFloat() - 0.5) * 0.1);
                vec3 = vec3.xRot(-this.getXRot() * (float) (Math.PI / 180.0));
                vec3 = vec3.yRot(-this.getYRot() * (float) (Math.PI / 180.0));
                double d0 = (double)(-this.random.nextFloat()) * 0.6 - 0.3;
                Vec3 vec31 = new Vec3(((double)this.random.nextFloat() - 0.5) * 0.8, d0, 1.0 + ((double)this.random.nextFloat() - 0.5) * 0.4);
                vec31 = vec31.yRot(-this.yBodyRot * (float) (Math.PI / 180.0));
                vec31 = vec31.add(this.getX(), this.getEyeY() + 1.0, this.getZ());
                this.level()
                        .addParticle(
                                new ItemParticleOption(ParticleTypes.ITEM, this.getItemBySlot(EquipmentSlot.MAINHAND)),
                                vec31.x,
                                vec31.y,
                                vec31.z,
                                vec3.x,
                                vec3.y + 0.05,
                                vec3.z
                        );
            }
        }
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        FoodProperties foodProperties = itemStack.getFoodProperties(this);
        if (foodProperties != null && !foodProperties.effects().isEmpty()) {
            for (int i = 0; i < foodProperties.effects().size(); i++) {
                this.addEffect(foodProperties.effects().get(i).effect());
            }
        }
        return itemStack.has(DataComponents.FOOD) || itemStack.is(Blocks.CAKE.asItem());
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.PANDA_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.PANDA_DEATH;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob otherParent) {
        SquirrelEntity squirrel = CreateGarnishedEntityTypes.SQUIRREL.get().create(serverLevel);
        if (squirrel != null) {
            if (serverLevel.getBiome(otherParent.blockPosition()).is(BiomeTags.SPAWNS_SNOW_FOXES)) {
                if (this.random.nextInt() * 5 == 1) squirrel.setVariant(Type.WHITE_SPOTTED);
            } else squirrel.setVariant(this.random.nextBoolean() ? this.getVariant() : ((SquirrelEntity)otherParent).getVariant());

            if (this.isTame()) {
                squirrel.setOwnerUUID(this.getOwnerUUID());
                squirrel.setTame(true, true);
            }
        }

        return squirrel;
    }

    @Override
    public boolean canMate(Animal otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (!this.isTame()) {
            return false;
        } else if (this.isDancing()) {
            return false;
        } else if (!(otherAnimal instanceof SquirrelEntity squirrel)) {
            return false;
        } else if (!squirrel.isTame()) {
            return false;
        } else if (squirrel.isDancing()) {
            return false;
        } else {
            return !squirrel.isInSittingPose() && this.isInLove() && squirrel.isInLove();
        }
    }

    private void setupAnimationStates() {
        if (idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (!this.isDancing() && this.isInSittingPose() && sittingAnimationTimeout <= 0) {
            sittingAnimationTimeout = 20; // Length in ticks of your animation
            sittingAnimationState.start(this.tickCount);
        } else {
            --this.sittingAnimationTimeout;
        }

        if (!this.isInSittingPose() && this.isDancing() && dancingAnimationTimeout <= 0) {
            dancingAnimationTimeout = (int) (1.7917F * 20);
            dancingAnimationState.start(this.tickCount);
        } else {
            --this.dancingAnimationTimeout;
        }

        if (!this.isInSittingPose()) {
            sittingAnimationState.stop();
        }

        if (!this.isDancing()) {
            dancingAnimationState.stop();
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }

        this.handleEating();
    }


    @Override
    public boolean canTakeItem(ItemStack itemstack) {
        EquipmentSlot equipmentslot = this.getEquipmentSlotForItem(itemstack);
        return this.getItemBySlot(equipmentslot).isEmpty() && equipmentslot == EquipmentSlot.MAINHAND && this.isFood(itemstack) && super.canTakeItem(itemstack);
    }

    @Override
    public boolean canHoldItem(ItemStack stack) {
        ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
        return itemstack.isEmpty() && this.isFood(stack);
    }

    private void spitOutItem(ItemStack stack) {
        if (!stack.isEmpty() && !this.level().isClientSide) {
            ItemEntity itementity = new ItemEntity(
                    this.level(), this.getX() + this.getLookAngle().x, this.getY() + 1.0, this.getZ() + this.getLookAngle().z, stack
            );
            itementity.setPickUpDelay(40);
            itementity.setThrower(this);
            this.playSound(SoundEvents.FOX_SPIT, 1.0F, 1.0F);
            this.level().addFreshEntity(itementity);
        }
    }

    private void dropItemStack(ItemStack stack) {
        ItemEntity itementity = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), stack);
        this.level().addFreshEntity(itementity);
    }

    /**
     * Tests if this entity should pick up a weapon or an armor piece. Entity drops current weapon or armor if the new one is better.
     */
    @Override
    protected void pickUpItem(ItemEntity itemEntity) {
        ItemStack itemstack = itemEntity.getItem();
        if (this.canHoldItem(itemstack)) {
            int i = itemstack.getCount();
            if (i > 1) {
                this.dropItemStack(itemstack.split(i - 1));
            }

            this.spitOutItem(this.getItemBySlot(EquipmentSlot.MAINHAND));
            this.onItemPickup(itemEntity);
            this.setItemSlot(EquipmentSlot.MAINHAND, itemstack.split(1));
            this.setGuaranteedDrop(EquipmentSlot.MAINHAND);
            this.take(itemEntity, itemstack.getCount());
            itemEntity.discard();
        }
    }

    static final Predicate<ItemEntity> ALLOWED_ITEMS = itemEntity -> !itemEntity.hasPickUpDelay() && itemEntity.isAlive();

    @Override
    public void setVariant(Type type) {
        this.entityData.set(DATA_TYPE_ID, type.getId());
    }

    @Override
    public Type getVariant() {
        return Type.byId(this.entityData.get(DATA_TYPE_ID));
    }

    class SearchForItemsGoal extends Goal {
        public SearchForItemsGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if (!SquirrelEntity.this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) {
                return false;
            } else if (SquirrelEntity.this.getLastHurtByMob() == null) {
                if (SquirrelEntity.this.isDancing()) {
                    return false;
                } else if (SquirrelEntity.this.getRandom().nextInt(reducedTickDelay(10)) != 0) {
                    return false;
                } else {
                    List<ItemEntity> list = SquirrelEntity.this.level().getEntitiesOfClass(ItemEntity.class,
                            SquirrelEntity.this.getBoundingBox().inflate(8.0F, 8.0F, 8.0F), SquirrelEntity.ALLOWED_ITEMS);
                    return !list.isEmpty() && SquirrelEntity.this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty();
                }
            } else {
                return false;
            }
        }

        @Override
        public void tick() {
            List<ItemEntity> list = SquirrelEntity.this.level().getEntitiesOfClass(ItemEntity.class,
                    SquirrelEntity.this.getBoundingBox().inflate(8.0F, 8.0F, 8.0F), SquirrelEntity.ALLOWED_ITEMS);
            ItemStack itemstack = SquirrelEntity.this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (itemstack.isEmpty() && !list.isEmpty()) {
                SquirrelEntity.this.getNavigation().moveTo(list.get(0), 1.2F);
            }

        }

        @Override
        public void start() {
            List<ItemEntity> list = SquirrelEntity.this.level().getEntitiesOfClass(ItemEntity.class,
                    SquirrelEntity.this.getBoundingBox().inflate(8.0F, 8.0F, 8.0F), SquirrelEntity.ALLOWED_ITEMS);
            if (!list.isEmpty()) {
                SquirrelEntity.this.getNavigation().moveTo(list.get(0), 1.2F);
            }

        }
    }

    class MoveToFarmlandGoal extends MoveToBlockGoal {
        private final Block moveToBlock = Blocks.FARMLAND;
        private final SquirrelEntity entity;
        private int ticksSinceReachedGoal;

        public MoveToFarmlandGoal(SquirrelEntity entity, double speedModifier, int searchRange) {
            super(entity, speedModifier, 24, searchRange);
            //this.blockToRemove = blockToRemove;
            this.entity = entity;
        }

        @Override
        public boolean canUse() {
            if (SquirrelEntity.this.isTame())
                if (this.nextStartTick > 0) {
                    --this.nextStartTick;
                    return false;
                } else if (SquirrelEntity.this.isDancing()) {
                    return false;
                } else if (this.findNearestBlock()) {
                    this.nextStartTick = reducedTickDelay(20);
                    return SquirrelEntity.this.getItemBySlot(EquipmentSlot.MAINHAND).is(CreateGarnishedItems.PEANUT);
                } else {
                    this.nextStartTick = this.nextStartTick(this.mob);
                    return false;
                }
            return false;
        }

        @Override
        public void stop() {
            super.stop();
            //this.entity.fallDistance = 1.0F;
        }

        @Override
        public void start() {
            super.start();
            this.ticksSinceReachedGoal = 0;
        }

        @Override
        public void tick() {
            super.tick();
            Level level = this.entity.level();
            BlockPos blockpos = this.entity.blockPosition();
            BlockPos blockpos1 = this.getPosWithBlock(blockpos, level);
            if (this.isReachedTarget() && blockpos1 != null) {
                if (level.getBlockState(blockpos1.above()).isAir() && this.ticksSinceReachedGoal == 0 && SquirrelEntity.this.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof BlockItem  blockItem) {
                    BlockState blockstate1 = blockItem.getBlock().defaultBlockState();
                    level.setBlockAndUpdate(blockpos1.above(), blockstate1);
                    level.gameEvent(GameEvent.BLOCK_PLACE, blockpos1.above(), GameEvent.Context.of(SquirrelEntity.this, blockstate1));

                    level.playSound(
                            null,
                            blockpos1.above().getX(),
                            blockpos1.above().getY(),
                            blockpos1.above().getZ(),
                            SoundEvents.CROP_PLANTED,
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                    );
                    SquirrelEntity.this.getItemBySlot(EquipmentSlot.MAINHAND).shrink(1);
//                    if (itemstack.isEmpty()) {
//                        simplecontainer.setItem(i, ItemStack.EMPTY);
//                    }
                }

                ++this.ticksSinceReachedGoal;
            }

        }

        private BlockPos getPosWithBlock(BlockPos pos, BlockGetter level) {
            if (level.getBlockState(pos).is(this.moveToBlock)) {
                return pos;
            } else {
                BlockPos[] ablockpos = new BlockPos[]{pos.below(), pos.west(), pos.east(), pos.north(), pos.south(), pos.below().below()};

                for(BlockPos blockpos : ablockpos) {
                    if (level.getBlockState(blockpos).is(this.moveToBlock)) {
                        return blockpos;
                    }
                }

                return null;
            }
        }

        @Override
        protected boolean isValidTarget(LevelReader level, BlockPos pos) {
            ChunkAccess chunkaccess = level.getChunk(SectionPos.blockToSectionCoord(pos.getX()), SectionPos.blockToSectionCoord(pos.getZ()), ChunkStatus.FULL, false);
            return chunkaccess != null && chunkaccess.getBlockState(pos).canEntityDestroy(level, pos, this.entity) && chunkaccess.getBlockState(pos).is(this.moveToBlock) && chunkaccess.getBlockState(pos.above()).isAir() && chunkaccess.getBlockState(pos.above(2)).isAir();
        }
    }

    class MoveToTreePlantableBlockGoal extends MoveToBlockGoal {
        private final TagKey<Block> moveToBlock = BlockTags.DIRT;
        private final SquirrelEntity entity;
        private int ticksSinceReachedGoal;

        public MoveToTreePlantableBlockGoal(SquirrelEntity entity, double speedModifier, int searchRange) {
            super(entity, speedModifier, 24, searchRange);
            //this.blockToRemove = blockToRemove;
            this.entity = entity;
        }

        @Override
        public boolean canUse() {
            if (SquirrelEntity.this.isTame())
                if (this.nextStartTick > 0) {
                    --this.nextStartTick;
                    return false;
                } else if (SquirrelEntity.this.isDancing()) {
                    return false;
                } else if (this.findNearestBlock()) {
                    this.nextStartTick = reducedTickDelay(20);
                    return SquirrelEntity.this.getItemBySlot(EquipmentSlot.MAINHAND).is(CreateGarnishedTags.NUT_SAPLINGS);
                } else {
                    this.nextStartTick = this.nextStartTick(this.mob);
                    return false;
                }
            return false;
        }

        @Override
        public void stop() {
            super.stop();
            //this.entity.fallDistance = 1.0F;
        }

        @Override
        public void start() {
            super.start();
            this.ticksSinceReachedGoal = 0;
        }

        @Override
        public void tick() {
            super.tick();
            Level level = this.entity.level();
            BlockPos blockpos = this.entity.blockPosition();
            BlockPos blockpos1 = this.getPosWithBlock(blockpos, level);
            if (this.isReachedTarget() && blockpos1 != null) {
                if (level.getBlockState(blockpos1.above()).isAir() && this.ticksSinceReachedGoal == 0 && SquirrelEntity.this.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof BlockItem  blockItem) {
                    BlockState blockstate1 = blockItem.getBlock().defaultBlockState();
                    level.setBlockAndUpdate(blockpos1.above(), blockstate1);
                    level.gameEvent(GameEvent.BLOCK_PLACE, blockpos1.above(), GameEvent.Context.of(SquirrelEntity.this, blockstate1));

                    level.playSound(
                            null,
                            blockpos1.above().getX(),
                            blockpos1.above().getY(),
                            blockpos1.above().getZ(),
                            SoundEvents.CROP_PLANTED,
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                    );
                    SquirrelEntity.this.getItemBySlot(EquipmentSlot.MAINHAND).shrink(1);
//                    if (itemstack.isEmpty()) {
//                        simplecontainer.setItem(i, ItemStack.EMPTY);
//                    }
                }

                ++this.ticksSinceReachedGoal;
            }

        }

        private BlockPos getPosWithBlock(BlockPos pos, BlockGetter level) {
            if (level.getBlockState(pos).is(this.moveToBlock)) {
                return pos;
            } else {
                BlockPos[] ablockpos = new BlockPos[]{pos.below(), pos.west(), pos.east(), pos.north(), pos.south(), pos.below().below()};

                for(BlockPos blockpos : ablockpos) {
                    if (level.getBlockState(blockpos).is(this.moveToBlock)) {
                        return blockpos;
                    }
                }

                return null;
            }
        }

        @Override
        protected boolean isValidTarget(LevelReader level, BlockPos pos) {
            ChunkAccess chunkaccess = level.getChunk(SectionPos.blockToSectionCoord(pos.getX()), SectionPos.blockToSectionCoord(pos.getZ()), ChunkStatus.FULL, false);
            return chunkaccess != null && chunkaccess.getBlockState(pos).canEntityDestroy(level, pos, this.entity) && chunkaccess.getBlockState(pos).is(this.moveToBlock) && chunkaccess.getBlockState(pos.above()).isAir() && chunkaccess.getBlockState(pos.above(2)).isAir();
        }
    }

    public static class SquirrelGroupData extends AgeableMob.AgeableMobGroupData {
        public final Type type;

        public SquirrelGroupData(Type type) {
            super(false);
            this.type = type;
        }
    }

    public static enum Type implements StringRepresentable {
        BLACK(0, "black"), // Tassel-eared Squirrel, Taiga variant
        GRAY(1, "gray"), // Eastern Gray Squirrel, Generic (Forest) variant
        ORANGE_GRAY(2, "orange_gray"), // Fox Squirrel, Generic (Plains) variant
        WHITE_SPOTTED(3, "white_spotted"), // Arctic Ground Squirrel, Generic (Snowy) variant
        PEPPERMINT(4, "peppermint"),

        // Easter Eggs
        // MIZU
        // SKEAER
        // DOPPEL
        // VERCTE


        ;

        public static final StringRepresentable.EnumCodec<Type> CODEC = StringRepresentable.fromEnum(Type::values);
        private static final IntFunction<Type> BY_ID = ByIdMap.continuous(Type::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
        private final int id;
        private final String name;

        private Type(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public static Type byName(String name) {
            return CODEC.byName(name, GRAY);
        }

        public static Type byId(int index) {
            return BY_ID.apply(index);
        }

        public static Type byBiome(Holder<Biome> biome) {
            return    biome.is(BiomeTags.SPAWNS_SNOW_FOXES) ? WHITE_SPOTTED // Override order
                    : biome.is(BiomeTags.IS_TAIGA) ? BLACK
                    : biome.is(BiomeTags.IS_FOREST) ? GRAY
                    : biome.is(BiomeTags.HAS_VILLAGE_PLAINS) ? ORANGE_GRAY
                    : GRAY; // set default type spawn
        }
    }
}
