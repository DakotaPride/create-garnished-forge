package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.world.level.block.state.properties.WoodType;

public class GarnishedWoodTypes {
    public static final WoodType SEPIA = WoodType.register(new WoodType(CreateGarnished.ID + ":sepia", GarnishedSetTypes.SEPIA));
    public static final WoodType NUT = WoodType.register(new WoodType(CreateGarnished.ID + ":nut", GarnishedSetTypes.NUT));
}
