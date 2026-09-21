package net.dakotapride.creategarnished.entity.bucketfish;

import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.minecraft.Util;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.function.IntFunction;

public class BucketFishEntity extends AbstractFish implements VariantHolder<BucketFishEntity.Type>, Bucketable {
    private static final EntityDataAccessor<Integer> DATA_TYPE_ID = SynchedEntityData.defineId(BucketFishEntity.class, EntityDataSerializers.INT);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public BucketFishEntity(EntityType<? extends AbstractFish> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void saveToBucketTag(ItemStack stack) {
        super.saveToBucketTag(stack);
        CustomData.update(DataComponents.BUCKET_ENTITY_DATA, stack,
                compoundTag -> compoundTag.putString("Type", this.getVariant().getName()));
    }

    @Override
    protected @NotNull SoundEvent getFlopSound() {
        return SoundEvents.SALMON_FLOP;
    }

    @Override
    public @NotNull ItemStack getBucketItemStack() {
        ItemStack stack;
        switch (this.getVariant()) {
            case RED -> stack = CreateGarnishedItems.BucketfishTypes.RED.bucketAsItem().getDefaultInstance();
            case ORANGE -> stack = CreateGarnishedItems.BucketfishTypes.ORANGE.bucketAsItem().getDefaultInstance();
            case YELLOW -> stack = CreateGarnishedItems.BucketfishTypes.YELLOW.bucketAsItem().getDefaultInstance();
            case GREEN -> stack = CreateGarnishedItems.BucketfishTypes.GREEN.bucketAsItem().getDefaultInstance();
            case LIME -> stack = CreateGarnishedItems.BucketfishTypes.LIME.bucketAsItem().getDefaultInstance();
            case BLUE -> stack = CreateGarnishedItems.BucketfishTypes.BLUE.bucketAsItem().getDefaultInstance();
            case LIGHT_BLUE -> stack = CreateGarnishedItems.BucketfishTypes.LIGHT_BLUE.bucketAsItem().getDefaultInstance();
            case CYAN -> stack = CreateGarnishedItems.BucketfishTypes.CYAN.bucketAsItem().getDefaultInstance();
            case PURPLE -> stack = CreateGarnishedItems.BucketfishTypes.PURPLE.bucketAsItem().getDefaultInstance();
            case MAGENTA -> stack = CreateGarnishedItems.BucketfishTypes.MAGENTA.bucketAsItem().getDefaultInstance();
            case PINK -> stack = CreateGarnishedItems.BucketfishTypes.PINK.bucketAsItem().getDefaultInstance();
            case BLACK -> stack = CreateGarnishedItems.BucketfishTypes.BLACK.bucketAsItem().getDefaultInstance();
            case GRAY -> stack = CreateGarnishedItems.BucketfishTypes.GRAY.bucketAsItem().getDefaultInstance();
            case LIGHT_GRAY -> stack = CreateGarnishedItems.BucketfishTypes.LIGHT_GRAY.bucketAsItem().getDefaultInstance();
            case WHITE -> stack = CreateGarnishedItems.BucketfishTypes.WHITE.bucketAsItem().getDefaultInstance();
            case BROWN -> stack = CreateGarnishedItems.BucketfishTypes.BROWN.bucketAsItem().getDefaultInstance();
            default -> stack = CreateGarnishedItems.BucketfishTypes.BASIC.bucketAsItem().getDefaultInstance();
        }

        CustomData.update(DataComponents.BUCKET_ENTITY_DATA, stack,
                compoundTag -> compoundTag.putString("Type", this.getVariant().getName()));

        return stack;
    }

    public @NotNull ItemStack getJellyItem() {
        ItemStack stack;
        switch (this.getVariant()) {
            case RED -> stack = CreateGarnishedItems.BucketfishTypes.RED.jellyAsItem().getDefaultInstance();
            case ORANGE -> stack = CreateGarnishedItems.BucketfishTypes.ORANGE.jellyAsItem().getDefaultInstance();
            case YELLOW -> stack = CreateGarnishedItems.BucketfishTypes.YELLOW.jellyAsItem().getDefaultInstance();
            case GREEN -> stack = CreateGarnishedItems.BucketfishTypes.GREEN.jellyAsItem().getDefaultInstance();
            case LIME -> stack = CreateGarnishedItems.BucketfishTypes.LIME.jellyAsItem().getDefaultInstance();
            case BLUE -> stack = CreateGarnishedItems.BucketfishTypes.BLUE.jellyAsItem().getDefaultInstance();
            case LIGHT_BLUE -> stack = CreateGarnishedItems.BucketfishTypes.LIGHT_BLUE.jellyAsItem().getDefaultInstance();
            case CYAN -> stack = CreateGarnishedItems.BucketfishTypes.CYAN.jellyAsItem().getDefaultInstance();
            case PURPLE -> stack = CreateGarnishedItems.BucketfishTypes.PURPLE.jellyAsItem().getDefaultInstance();
            case MAGENTA -> stack = CreateGarnishedItems.BucketfishTypes.MAGENTA.jellyAsItem().getDefaultInstance();
            case PINK -> stack = CreateGarnishedItems.BucketfishTypes.PINK.jellyAsItem().getDefaultInstance();
            case BLACK -> stack = CreateGarnishedItems.BucketfishTypes.BLACK.jellyAsItem().getDefaultInstance();
            case GRAY -> stack = CreateGarnishedItems.BucketfishTypes.GRAY.jellyAsItem().getDefaultInstance();
            case LIGHT_GRAY -> stack = CreateGarnishedItems.BucketfishTypes.LIGHT_GRAY.jellyAsItem().getDefaultInstance();
            case WHITE -> stack = CreateGarnishedItems.BucketfishTypes.WHITE.jellyAsItem().getDefaultInstance();
            case BROWN -> stack = CreateGarnishedItems.BucketfishTypes.BROWN.jellyAsItem().getDefaultInstance();
            default -> stack = CreateGarnishedItems.BucketfishTypes.BASIC.jellyAsItem().getDefaultInstance();
        }

        return stack;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (!source.is(DamageTypeTags.NO_KNOCKBACK)) {
            if (source.getSourcePosition() != null) {
                double d0 = source.getSourcePosition().x() - this.getX();
                double d1 = source.getSourcePosition().z() - this.getZ();

                this.knockback(0.8F, d0, d1);
            }
            return false;
        }
        return super.hurt(source, amount);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_TYPE_ID, 0);
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
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @javax.annotation.Nullable SpawnGroupData spawnGroupData) {
        if (spawnType == MobSpawnType.BUCKET) {
            return spawnGroupData;
        } else {
            RandomSource randomsource = level.getRandom();
            spawnGroupData = new BucketFishGroupData(Type.getSpawnVariant(randomsource));

            this.setVariant(((BucketFishGroupData)spawnGroupData).getVariant(randomsource));

            return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        }
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (player.getItemInHand(hand).getItem() instanceof ShearsItem && !player.getCooldowns().isOnCooldown(player.getItemInHand(hand).getItem())) {
            this.level().addFreshEntity(new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), this.getJellyItem()));
            this.playSound(SoundEvents.HONEY_BLOCK_STEP, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            player.getCooldowns().addCooldown(player.getItemInHand(hand).getItem(), 20);
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    private void setupAnimationStates() {
        if (!this.isSwimming()) {
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = 40;
                this.idleAnimationState.start(this.tickCount);
            } else {
                --this.idleAnimationTimeout;
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public void setVariant(BucketFishEntity.Type type) {
        this.entityData.set(DATA_TYPE_ID, type.getId());
    }

    @Override
    public BucketFishEntity.Type getVariant() {
        return BucketFishEntity.Type.byId(this.entityData.get(DATA_TYPE_ID));
    }

    public static class BucketFishGroupData extends AgeableMob.AgeableMobGroupData {
        public final BucketFishEntity.Type[] types;

        public BucketFishGroupData(BucketFishEntity.Type... types) {
            super(false);
            this.types = types;
        }

        public Type getVariant(RandomSource random) {
            return this.types[random.nextInt(this.types.length)];
        }
    }

    public enum Type implements StringRepresentable {
        BASIC(0, "basic"),
        RED(1, "red"),
        ORANGE(2, "orange"),
        YELLOW(3, "yellow"),
        GREEN(4, "green"),
        LIME(5, "lime"),
        BLUE(6, "blue"),
        LIGHT_BLUE(7, "light_blue"),
        CYAN(8, "cyan"),
        PURPLE(9, "purple"),
        MAGENTA(10, "magenta"),
        PINK(11, "pink"),
        BLACK(12, "black"),
        GRAY(13, "gray"),
        LIGHT_GRAY(14, "light_gray"),
        WHITE(15, "white"),
        BROWN(16, "brown"),

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
            return CODEC.byName(name, BASIC);
        }

        public static Type byId(int index) {
            return BY_ID.apply(index);
        }

        private static Type getSpawnVariant(RandomSource random) {
            Type[] type = Arrays.stream(values()).toArray(Type[]::new);
            return Util.getRandom(type, random);
        }
    }
}
