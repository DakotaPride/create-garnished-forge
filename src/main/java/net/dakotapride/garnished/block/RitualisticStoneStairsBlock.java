package net.dakotapride.garnished.block;

import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.dakotapride.garnished.registry.GarnishedPaletteStoneTypes;
import net.minecraft.world.level.block.StairBlock;

public class RitualisticStoneStairsBlock extends StairBlock {
    public RitualisticStoneStairsBlock(Properties properties) {
        super(() -> GarnishedPaletteStoneTypes.RITUALISTIC_STONE.getBlock().get().defaultBlockState(), properties);
    }
}
