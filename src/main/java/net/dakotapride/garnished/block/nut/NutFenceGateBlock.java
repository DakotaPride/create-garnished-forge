package net.dakotapride.garnished.block.nut;

import net.dakotapride.garnished.registry.GarnishedWoodTypes;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.properties.WoodType;

public class NutFenceGateBlock extends FenceGateBlock {
    public NutFenceGateBlock(Properties pProperties) {
        super(pProperties, GarnishedWoodTypes.NUT);
    }
}
