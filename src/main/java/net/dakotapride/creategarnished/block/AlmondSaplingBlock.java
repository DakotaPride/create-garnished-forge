package net.dakotapride.creategarnished.block;

import net.dakotapride.creategarnished.registry.CreateGarnishedTreeGrower;
import net.minecraft.world.level.block.SaplingBlock;

public class AlmondSaplingBlock extends SaplingBlock {
    public AlmondSaplingBlock(Properties pProperties) {
        super(new CreateGarnishedTreeGrower.Almond(), pProperties);
    }
}
