package net.dakotapride.garnished.block;

import net.dakotapride.garnished.registry.GarnishedPaletteStoneTypes;
import net.minecraft.world.level.block.StairBlock;

public class CarnotiteStairsBlock extends StairBlock {
    public CarnotiteStairsBlock(Properties properties) {
        super(() -> GarnishedPaletteStoneTypes.CARNOTITE.getBlock().get().defaultBlockState(), properties);
    }
}
