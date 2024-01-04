package net.dakotapride.garnished.block.kelp;

import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.KelpPlantBlock;
import org.jetbrains.annotations.NotNull;

public class VermilionKelpPlantBlock extends KelpPlantBlock {
    public VermilionKelpPlantBlock(Properties p_54323_) {
        super(p_54323_);
    }

    @Override
    protected @NotNull GrowingPlantHeadBlock getHeadBlock() {
        return GarnishedBlocks.VERMILION_KELP.get();
    }
}
