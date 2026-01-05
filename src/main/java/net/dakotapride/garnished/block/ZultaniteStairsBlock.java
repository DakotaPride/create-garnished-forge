package net.dakotapride.garnished.block;

import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.dakotapride.garnished.registry.ZultaniteStoneTypes;
import net.minecraft.world.level.block.StairBlock;

public class ZultaniteStairsBlock extends StairBlock {
	public ZultaniteStairsBlock(Properties properties) {
		super(() -> ZultaniteStoneTypes.DEFAULT.getBlock().get().defaultBlockState(), properties);
	}
}
