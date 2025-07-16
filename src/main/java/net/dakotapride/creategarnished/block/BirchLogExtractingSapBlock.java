package net.dakotapride.creategarnished.block;

import com.simibubi.create.AllBlockEntityTypes;
import net.dakotapride.creategarnished.registry.CreateGarnishedConfigs;
import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;

public class BirchLogExtractingSapBlock extends RotatedPillarBlock {
    public static final BooleanProperty HAS_SAP = BooleanProperty.create("has_sap");

    public BirchLogExtractingSapBlock(Properties properties) {
        super(properties);
        //registerDefaultState(defaultBlockState().setValue(HAS_SAP, false));
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getSapProperty(), false));
    }

    public BooleanProperty getSapProperty() {
        return HAS_SAP;
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(getSapProperty());
    }

    @Override
    protected void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, RandomSource random) {
        int r = random.nextInt(2);
        if (r != 0 && hasRequiredLogs(state, level, pos)) {
            //state.setValue(HAS_SAP, true);
            level.setBlockAndUpdate(pos, state.setValue(HAS_SAP, true));
            super.randomTick(state, level, pos, random);
        }

        //CreateGarnished.LOGGER.info("The random integer is {}", r);

        //super.randomTick(state, level, pos, random);
    }

    public static boolean hasRequiredLogs(BlockState state, LevelReader level, BlockPos pos) {
        if (CreateGarnishedConfigs.server().block.requireLogsForSapGeneration.get())
            return level.getBlockState(pos.above()).is(BlockTags.BIRCH_LOGS) && level.getBlockState(pos.below()).is(BlockTags.BIRCH_LOGS);

        return !CreateGarnishedConfigs.server().block.requireLogsForSapGeneration.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HAS_SAP);
        super.createBlockStateDefinition(builder);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {

        if (stack.is(Items.GLASS_BOTTLE) && state.getValue(HAS_SAP)) {

            stack.shrink(1);
            player.addItem(new ItemStack(CreateGarnishedItems.BIRCH_SAP_BOTTLE.get(), 1));

            //level.setBlock(pos, Blocks.STRIPPED_BIRCH_LOG.defaultBlockState(), 11);
            //level.setBlockAndUpdate(pos, state.setValue(HAS_SAP, false));

            if (CreateGarnishedConfigs.server().block.allowForRenewableBirchSap.get()) {
                level.setBlockAndUpdate(pos, state.setValue(HAS_SAP, false));
            } else {
                level.setBlock(pos, Blocks.BIRCH_LOG.defaultBlockState(), 11);
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
}
