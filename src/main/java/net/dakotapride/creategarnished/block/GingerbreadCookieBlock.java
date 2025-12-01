package net.dakotapride.creategarnished.block;

import com.mojang.serialization.MapCodec;
import net.dakotapride.creategarnished.item.GingerbreadCookieItem;
import net.dakotapride.creategarnished.registry.CreateGarnishedBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
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

    @Override
    public MapCodec<GingerbreadCookieBlock> codec() {
        return CODEC;
    }

    public GingerbreadCookieBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return Shapes.empty();
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        ItemStack stack = context.getItemInHand();
        BlockState blockState = this.defaultBlockState();
        if (stack.getItem() instanceof GingerbreadCookieItem cookieItem) {
            return blockState.setValue(GINGERBREAD_COOKIE_VARIANTS, cookieItem.getVariant()).setValue(FACING, context.getHorizontalDirection().getOpposite());
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
        builder.add(GINGERBREAD_COOKIE_VARIANTS, FACING);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(4.0, 0.0, 4.0, 12.0, 2.0, 12.0);
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
