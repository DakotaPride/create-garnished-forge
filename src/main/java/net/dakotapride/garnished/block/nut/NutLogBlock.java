package net.dakotapride.garnished.block.nut;

import net.dakotapride.garnished.item.hatchet.HatchetUtils;
import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class NutLogBlock extends RotatedPillarBlock {
	public NutLogBlock(Properties properties) {
		super(properties);
	}

	@Override
	public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return true;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 5;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 5;
	}

	@Override
	public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
		if(HatchetUtils.canBeUsedToStripLogs(context.getItemInHand().getItem().getDefaultInstance())) {
			if(state.is(GarnishedBlocks.SEPIA_STEM.get())) {
				return GarnishedBlocks.STRIPPED_SEPIA_STEM.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
			}

			if(state.is(GarnishedBlocks.SEPIA_HYPHAE.get())) {
				return GarnishedBlocks.STRIPPED_SEPIA_HYPHAE.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
			}
		}

		return super.getToolModifiedState(state, context, toolAction, simulate);
	}
}