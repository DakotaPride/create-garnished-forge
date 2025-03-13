package net.dakotapride.creategarnished.block;

import net.dakotapride.creategarnished.registry.CreateGarnishedTreeGrower;
import net.minecraft.world.level.block.SaplingBlock;

public class HazelnutSaplingBlock extends SaplingBlock {
    public HazelnutSaplingBlock(Properties pProperties) {
        super(new CreateGarnishedTreeGrower.Hazelnut(), pProperties);
    }
}
