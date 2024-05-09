package net.dakotapride.garnished.block.potted_blocks;

import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;

public class PottedBarrenRootsBlock extends FlowerPotBlock {
    public PottedBarrenRootsBlock(Properties properties) {
        super(() -> (FlowerPotBlock) net.minecraftforge.registries.ForgeRegistries.BLOCKS.getDelegateOrThrow(Blocks.FLOWER_POT).get(),
                GarnishedBlocks.BARREN_ROOTS, properties);
    }
}
