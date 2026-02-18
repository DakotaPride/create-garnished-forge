package net.dakotapride.creategarnished.block;

import com.mojang.serialization.MapCodec;
import net.dakotapride.creategarnished.item.GingerbreadCookieItem;
import net.dakotapride.creategarnished.registry.CreateGarnishedBlockStateProperties;
import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class GingerbreadCookieBlock extends Block {
    public static final MapCodec<GingerbreadCookieBlock> CODEC = simpleCodec(GingerbreadCookieBlock::new);
    public static final EnumProperty<GingerbreadCookieVariants> GINGERBREAD_COOKIE_VARIANTS = CreateGarnishedBlockStateProperties.GINGERBREAD_COOKIE_VARIANTS;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final IntegerProperty COOKIE_COUNT = CreateGarnishedBlockStateProperties.COOKIE_COUNT;

    @Override
    public MapCodec<GingerbreadCookieBlock> codec() {
        return CODEC;
    }

    public GingerbreadCookieBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(COOKIE_COUNT, 1));
    }

    @Override
    protected VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return Shapes.empty();
    }

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        Item item = useContext.getItemInHand().getItem();
        return !useContext.isSecondaryUseActive() &&
                item instanceof GingerbreadCookieItem cookieItem &&
                cookieItem.getVariant() == state.getValue(GINGERBREAD_COOKIE_VARIANTS) &&
                state.getValue(COOKIE_COUNT) < 6 || super.canBeReplaced(state, useContext);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return getState(context);
    }

    public BlockState getState(BlockPlaceContext context) {
        ItemStack stack = context.getItemInHand();
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (stack.getItem() instanceof GingerbreadCookieItem cookieItem) {
            if (blockstate.is(this) && blockstate.getValue(GINGERBREAD_COOKIE_VARIANTS) == cookieItem.getVariant()) {
                return blockstate.cycle(COOKIE_COUNT);
            } else {
                return this.defaultBlockState()
                        .setValue(GINGERBREAD_COOKIE_VARIANTS, cookieItem.getVariant())
                        .setValue(FACING, context.getHorizontalDirection().getOpposite());
            }
        }
        return super.getStateForPlacement(context);
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(GINGERBREAD_COOKIE_VARIANTS, FACING, COOKIE_COUNT);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        double yHeight = 0.0D;
        for (int i = 0; i < state.getValue(COOKIE_COUNT); i++) {
            yHeight = yHeight + 2.0D;
        }
        return Block.box(4.0, 0.0, 4.0, 12.0, yHeight, 12.0);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return Block.canSupportCenter(level, pos.below(), Direction.UP);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        if (this.asItem() instanceof GingerbreadCookieItem) {
            if (state.getValue(GINGERBREAD_COOKIE_VARIANTS) == GingerbreadCookieVariants.NONE)
                return new ItemStack(CreateGarnishedItems.GINGERBREAD_COOKIE.asItem());
            if (state.getValue(GINGERBREAD_COOKIE_VARIANTS) == GingerbreadCookieVariants.TRANSRIGHTS)
                return new ItemStack(CreateGarnishedItems.GingerbreadCookieTypes.TRANSRIGHTS.asItem());
            if (state.getValue(GINGERBREAD_COOKIE_VARIANTS) == GingerbreadCookieVariants.CREEPER)
                return new ItemStack(CreateGarnishedItems.GingerbreadCookieTypes.CREEPER.asItem());
            if (state.getValue(GINGERBREAD_COOKIE_VARIANTS) == GingerbreadCookieVariants.GOGGLES)
                return new ItemStack(CreateGarnishedItems.GingerbreadCookieTypes.GOGGLES.asItem());
            if (state.getValue(GINGERBREAD_COOKIE_VARIANTS) == GingerbreadCookieVariants.INFECTED)
                return new ItemStack(CreateGarnishedItems.GingerbreadCookieTypes.INFECTED.asItem());
            if (state.getValue(GINGERBREAD_COOKIE_VARIANTS) == GingerbreadCookieVariants.GRUB)
                return new ItemStack(CreateGarnishedItems.GingerbreadCookieTypes.GRUB.asItem());
            if (state.getValue(GINGERBREAD_COOKIE_VARIANTS) == GingerbreadCookieVariants.FLEA)
                return new ItemStack(CreateGarnishedItems.GingerbreadCookieTypes.FLEA.asItem());
        }

        return super.getCloneItemStack(state, target, level, pos, player);
    }

    public enum GingerbreadCookieVariants implements StringRepresentable {
        NONE,
        TRANSRIGHTS,
        CREEPER,
        GOGGLES,
        INFECTED,
        GRUB,
        FLEA,

        ;

        GingerbreadCookieVariants() {}

        @Override
        public @NotNull String getSerializedName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}
