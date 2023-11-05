package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.world.level.block.state.properties.WoodType;

public class GarnishedWoodType extends WoodType {
    public GarnishedWoodType(String pName) {
        super(pName);
    }

    public static final WoodType SEPIA = register(new GarnishedWoodType(CreateGarnished.ID + ":sepia"));
    public static final WoodType NUT = register(new GarnishedWoodType(CreateGarnished.ID + ":nut"));
}
