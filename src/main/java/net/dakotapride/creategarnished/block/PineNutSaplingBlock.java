package net.dakotapride.creategarnished.block;

import net.dakotapride.creategarnished.registry.CreateGarnishedTreeGrower;
import net.minecraft.world.level.block.SaplingBlock;

public class PineNutSaplingBlock extends SaplingBlock {
    public PineNutSaplingBlock(Properties pProperties) {
        super(new CreateGarnishedTreeGrower.PineNut(), pProperties);
    }
}
