package net.dakotapride.garnished.block.potted_blocks;

import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;

public class PottedAureateShrubBlock extends FlowerPotBlock {
    public PottedAureateShrubBlock(Properties properties) {
        super(() -> (FlowerPotBlock) Blocks.FLOWER_POT, GarnishedBlocks.AUREATE_SHRUB, properties);
    }
}
