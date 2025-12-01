package net.dakotapride.creategarnished.block;

import net.dakotapride.creategarnished.registry.CreateGarnishedTreeGrower;
import net.minecraft.world.level.block.SaplingBlock;

public class ChestnutSaplingBlock extends SaplingBlock {
    public ChestnutSaplingBlock(Properties pProperties) {
        super(CreateGarnishedTreeGrower.CHESTNUT, pProperties);
    }
}
