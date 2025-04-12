package net.dakotapride.garnished.block;

import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.dakotapride.garnished.registry.GarnishedPaletteStoneTypes;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class CarnotiteStairsBlock extends StairBlock {
    public CarnotiteStairsBlock(Properties properties) {
        super(GarnishedPaletteStoneTypes.CARNOTITE.getBlock().get().defaultBlockState(), properties);
    }
}
