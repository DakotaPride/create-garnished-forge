package net.dakotapride.garnished.block;

import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nullable;

public class SepiaStemBlock extends RotatedPillarBlock {
	public SepiaStemBlock(Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
		if(context.getItemInHand().getItem() instanceof AxeItem) {
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
