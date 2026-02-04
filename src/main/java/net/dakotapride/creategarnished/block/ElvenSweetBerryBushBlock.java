package net.dakotapride.creategarnished.block;

import com.mojang.serialization.MapCodec;
import net.dakotapride.creategarnished.registry.CreateGarnishedConfigs;
import net.dakotapride.creategarnished.registry.CreateGarnishedDamageSources;
import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.dakotapride.creategarnished.registry.CreateGarnishedParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElvenSweetBerryBushBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<ElvenSweetBerryBushBlock> CODEC = simpleCodec(ElvenSweetBerryBushBlock::new);
    public static IntegerProperty AGE = BlockStateProperties.AGE_3;;
    private static final VoxelShape SAPLING_SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 8.0, 13.0);;
    private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    public ElvenSweetBerryBushBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((this.stateDefinition.any()).setValue(AGE, 0));
    }

    @Override
    public @Nullable PathType getAdjacentBlockPathType(BlockState state, BlockGetter level, BlockPos pos, @Nullable Mob mob, PathType originalType) {
        return PathType.DANGER_OTHER;
    }

    @Override
    protected @NotNull MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(CreateGarnishedItems.ELVEN_SWEET_BERRIES.get());
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pState.getValue(AGE) == 0) {
            return SAPLING_SHAPE;
        } else {
            return pState.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(pState, pLevel, pPos, pContext);
        }
    }

    public boolean isRandomlyTicking(BlockState pState) {
        return pState.getValue(AGE) < 3;
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        int i = pState.getValue(AGE);
        if (i < 3 && pLevel.getRawBrightness(pPos.above(), 0) >= 9 && CommonHooks.canCropGrow(pLevel, pPos, pState, pRandom.nextInt(5) == 0)) {
            BlockState blockstate = pState.setValue(AGE, i + 1);
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(blockstate));
            CommonHooks.fireCropGrowPost(pLevel, pPos, pState);
        }

    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        VoxelShape voxelshape = this.getShape(state, level, pos, CollisionContext.empty());
        Vec3 vec3 = voxelshape.bounds().getCenter();
        int age = state.getValue(AGE);
        double d0 = (double)pos.getX() + vec3.x;
        double d1 = (double)pos.getZ() + vec3.z;

        if (CreateGarnishedConfigs.client().elvenSweetBerryBushParticles.get())
            for(int i = 0; i < age; ++i) {
                if (random.nextBoolean()) {
                    level.addParticle(CreateGarnishedParticles.ELVEN_MYSTICAL_PARTICLE.get(), d0 + random.nextDouble() / (double)5.0F, (double)pos.getY() + (((double)0.5F) - random.nextDouble()), d1 + random.nextDouble() / (double)5.0F, 0.0F, 0.0F, 0.0F);
                }
            }
    }

    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity instanceof LivingEntity && pEntity.getType() != EntityType.FOX && pEntity.getType() != EntityType.BEE) {
            pEntity.makeStuckInBlock(pState, new Vec3(0.800000011920929, 0.75, 0.800000011920929));
            if (!pLevel.isClientSide && pState.getValue(AGE) > 0 && (pEntity.xOld != pEntity.getX() || pEntity.zOld != pEntity.getZ())) {
                double d0 = Math.abs(pEntity.getX() - pEntity.xOld);
                double d1 = Math.abs(pEntity.getZ() - pEntity.zOld);
                if (d0 >= 0.003000000026077032 || d1 >= 0.003000000026077032) {
                    pEntity.hurt(CreateGarnishedDamageSources.elvenSweetBerryBush(pLevel), CreateGarnishedConfigs.server().entity.elvenSweetBerryBushPrickDamageAmount.get().floatValue());
                }
            }
        }

    }

    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        return !flag && stack.is(Items.BONE_MEAL) ? ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION : super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (i > 1) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(CreateGarnishedItems.ELVEN_SWEET_BERRIES.get(), j + (flag ? 1 : 0)));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockstate = state.setValue(AGE, 1);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.useWithoutItem(state, level, pos, player, hitResult);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return blockState.getValue(AGE) < 3;
    }

    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        int i = Math.min(3, pState.getValue(AGE) + 1);
        pLevel.setBlock(pPos, pState.setValue(AGE, i), 2);
    }
}
