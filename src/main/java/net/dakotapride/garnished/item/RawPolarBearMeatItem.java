package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class RawPolarBearMeatItem extends ConditionalEffectItem implements IGarnishedUtilities {
	public RawPolarBearMeatItem(Properties properties) {
		super(1, 0.05F, properties.food(GarnishedFoodValues.RAW_POLAR_BEAR_MEAT));
	}

}
