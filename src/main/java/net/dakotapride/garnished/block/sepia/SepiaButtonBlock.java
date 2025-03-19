package net.dakotapride.garnished.block.sepia;

import net.dakotapride.garnished.registry.GarnishedSetTypes;
import net.minecraft.world.level.block.ButtonBlock;

public class SepiaButtonBlock extends ButtonBlock {
    public SepiaButtonBlock(Properties pProperties) {
        super(GarnishedSetTypes.SEPIA, 30, pProperties);
    }
}
