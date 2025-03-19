package net.dakotapride.garnished.block.potted_blocks;

import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;

public class PottedSmallChorusPlantBlock extends FlowerPotBlock {
    public PottedSmallChorusPlantBlock(Properties properties) {
        super(() -> (FlowerPotBlock) Blocks.FLOWER_POT, GarnishedBlocks.SMALL_CHORUS_PLANT, properties);
    }
}
