package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.world.level.block.state.properties.WoodType;

public class GarnishedWoodType {
    public static final WoodType NUT = WoodType.register(new WoodType(CreateGarnished.ID + ":nut", GarnishedBlockSetType.NUT));
    public static final WoodType SEPIA = WoodType.register(new WoodType(CreateGarnished.ID + ":sepia", GarnishedBlockSetType.SEPIA));
}
