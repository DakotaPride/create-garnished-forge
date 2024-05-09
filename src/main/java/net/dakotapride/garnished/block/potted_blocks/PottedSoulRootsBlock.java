package net.dakotapride.garnished.block.potted_blocks;

import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;

public class PottedSoulRootsBlock extends FlowerPotBlock {
    public PottedSoulRootsBlock(Properties properties) {
        super(() -> (FlowerPotBlock) net.minecraftforge.registries.ForgeRegistries.BLOCKS.getDelegateOrThrow(Blocks.FLOWER_POT).get(),
                GarnishedBlocks.SOUL_ROOTS, properties);
    }
}
