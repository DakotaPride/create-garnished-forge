package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class CinderRollFoodItem extends ConditionalEffectItem implements IGarnishedUtilities {
	public CinderRollFoodItem(Properties properties) {
		super(5, 100, properties.food(GarnishedFoodValues.CINDER_ROLL).stacksTo(16));
	}
}
