package net.dakotapride.garnished.block.sepia;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.dakotapride.garnished.block.NetherFlowerBlock;
import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// Farmer's/My Nether's Delight compatibility block - cannot access base MushroomColonyBlock without errors popping up and forcing the game to not load

public class SoulFungusColonyBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<SoulFungusColonyBlock> CODEC = simpleCodec(SoulFungusColonyBlock::new);
    public static final int PLACING_LIGHT_LEVEL = 13;
    public static final IntegerProperty COLONY_AGE = BlockStateProperties.AGE_3;
    protected static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(4.0F, 0.0F, 4.0F, 12.0F, 8.0F, 12.0F), Block.box(3.0F, 0.0F, 3.0F, 13.0F, 10.0F, 13.0F), Block.box(2.0F, 0.0F, 2.0F, 14.0F, 12.0F, 14.0F), Block.box(1.0F, 0.0F, 1.0F, 15.0F, 14.0F, 15.0F)};
    public SoulFungusColonyBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(COLONY_AGE, 0));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    public IntegerProperty getAgeProperty() {
        return COLONY_AGE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.isSolidRender(level, pos) || state.is(BlockTags.SOUL_FIRE_BASE_BLOCKS);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos floorPos = pos.below();
        BlockState floorState = level.getBlockState(floorPos);
        if (floorState.is(BlockTags.MUSHROOM_GROW_BLOCK) || floorState.is(BlockTags.SOUL_FIRE_BASE_BLOCKS)) {
            return true;
        } else {
            return level.getRawBrightness(pos, 0) < 13 && floorState.canSustainPlant(level, floorPos, Direction.UP, state).isDefault();
        }
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int age = state.getValue(COLONY_AGE);
        if (age > 0 && heldStack.is(Tags.Items.TOOLS_SHEAR)) {
            popResource(level, pos, this.getCloneItemStack(level, pos, state));
            level.playSound(null, pos, SoundEvents.MOOSHROOM_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.setBlock(pos, state.setValue(COLONY_AGE, age - 1), 2);
            if (!level.isClientSide) {
                heldStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            }

            return ItemInteractionResult.SUCCESS;
        } else {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
    }

    public int getMaxAge() {
        return 3;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int age = state.getValue(COLONY_AGE);
        BlockState groundState = level.getBlockState(pos.below());
        if (age < this.getMaxAge() && groundState.is(GarnishedTags.MUSHROOM_COLONY_GROWABLE_ON) && CommonHooks.canCropGrow(level, pos, state, random.nextInt(4) == 0)) {
            level.setBlock(pos, state.setValue(COLONY_AGE, age + 1), 2);
            CommonHooks.fireCropGrowPost(level, pos, state);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (!(ModList.get().isLoaded("mynethersdelight"))) {
            tooltipComponents.add(Component.translatable("text.garnished.integration.mynethersdelight.missing").withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return GarnishedBlocks.SEPIA_FUNGUS_COLONY.asStack();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COLONY_AGE);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return state.getValue(this.getAgeProperty()) < this.getMaxAge();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    protected int getBonemealAgeIncrease(Level level) {
        return Mth.nextInt(level.random, 1, 2);
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int age = Math.min(this.getMaxAge(), state.getValue(COLONY_AGE) + this.getBonemealAgeIncrease(level));
        level.setBlock(pos, state.setValue(COLONY_AGE, age), 2);
    }

}
