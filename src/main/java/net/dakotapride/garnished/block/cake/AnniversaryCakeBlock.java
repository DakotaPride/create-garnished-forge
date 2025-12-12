package net.dakotapride.garnished.block.cake;

import com.mojang.serialization.MapCodec;
import net.dakotapride.garnished.registry.GarnishedAdvancementUtils;
import net.dakotapride.garnished.registry.GarnishedBlockEntities;
import net.dakotapride.garnished.registry.GarnishedEffects;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

// 1-Year Anniversary of Create: Garnished - nuts!
public class AnniversaryCakeBlock extends BaseEntityBlock {
    public static final MapCodec<AnniversaryCakeBlock> CODEC = simpleCodec(AnniversaryCakeBlock::new);

    public static final IntegerProperty BITES_PROPERTY = IntegerProperty.create("anniversary_bites", 0, 5);

    public static final int MAX_BITES = 5;
    public static final IntegerProperty BITES = BITES_PROPERTY;
    public static final int FULL_CAKE_SIGNAL = getOutputSignal(0);
    protected static final float AABB_OFFSET = 1.0F;
    protected static final float AABB_SIZE_PER_BITE = 2.0F;
    protected static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[]
            {
                    Stream.of(
                            Block.box(0, 0, 0, 16, 7, 16),
                            Block.box(2, 7, 2, 14, 15, 14),
                            Block.box(4, 7, 4, 12, 21, 12)
                    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
                    Stream.of(
                            Block.box(0, 0, 0, 16, 7, 16),
                            Block.box(2, 7, 2, 14, 15, 14),
                            Block.box(8, 7, 4, 12, 21, 12)
                    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
                    Stream.of(
                            Block.box(0, 0, 0, 16, 7, 16),
                            Block.box(2, 7, 2, 14, 15, 14)
                    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
                    Stream.of(
                            Block.box(0, 0, 0, 16, 7, 16),
                            Block.box(8, 7, 2, 14, 15, 14)
                    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
                    Stream.of(
                            Block.box(0, 0, 0, 16, 7, 16)
                    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
                    Stream.of(
                            Block.box(8, 0, 0, 16, 7, 16)
                    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get()
            };

    public AnniversaryCakeBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, Integer.valueOf(0)));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_BITE[pState.getValue(BITES)];
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide) {
            if (eat(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat(level, pos, state, player);
    }

    protected static InteractionResult eat(LevelAccessor pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pPlayer.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            pPlayer.awardStat(Stats.EAT_CAKE_SLICE);
            pPlayer.getFoodData().eat(4, 0.2F);
            int i = pState.getValue(BITES);
            pLevel.gameEvent(pPlayer, GameEvent.EAT, pPos);
            pLevel.playSound(pPlayer, pPos, SoundEvents.GENERIC_EAT, SoundSource.BLOCKS, 1.0F, 1.0F);
            // GarnishedAdvancements.ANNIVERSARY_CAKE.awardTo(pPlayer);
            if (pPlayer instanceof ServerPlayer) {
                GarnishedAdvancementUtils.CONSUME_ANNIVERSARY_CAKE_SLICE.get().trigger((ServerPlayer) pPlayer);
                pPlayer.addEffect(new MobEffectInstance(GarnishedEffects.AVERSION, 60 * 5, 1));
                pPlayer.displayClientMessage(Component.translatable("text.garnished.april_foods.aversion_reason.7"), true);
            }
            if (i < 5) {
                pLevel.setBlock(pPos, pState.setValue(BITES, Integer.valueOf(i + 1)), 3);
            } else {
                pLevel.removeBlock(pPos, false);
                pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);
            }

            return InteractionResult.SUCCESS;
        }
    }

    /**
     * Update the provided state given the provided neighbor direction and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific direction passed in.
     */
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        return pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BITES);
    }

    /**
     * @deprecated call via {@link
     * net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase#getAnalogOutputSignal} whenever possible.
     * Implementing/overriding is fine.
     */
    public int getAnalogOutputSignal(BlockState pBlockState, @NotNull Level pLevel, @NotNull BlockPos pPos) {
        return getOutputSignal(pBlockState.getValue(BITES));
    }

    public static int getOutputSignal(int pEaten) {
        return (7 - pEaten) * 2;
    }

    /**
     * @deprecated call via {@link
     * net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase#hasAnalogOutputSignal} whenever possible.
     * Implementing/overriding is fine.
     */
    public boolean hasAnalogOutputSignal(@NotNull BlockState pState) {
        return true;
    }

    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return GarnishedBlockEntities.CAKE.get().create(pos, state);
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
}