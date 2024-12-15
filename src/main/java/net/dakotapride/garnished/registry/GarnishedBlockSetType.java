package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class GarnishedBlockSetType {
    public static final BlockSetType NUT = BlockSetType.register(new BlockSetType(CreateGarnished.ID + ":nut"));
    public static final BlockSetType SEPIA = BlockSetType.register(new BlockSetType(CreateGarnished.ID + ":sepia"));
}
