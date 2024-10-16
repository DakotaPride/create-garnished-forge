package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class PiquantPretzelFoodItem extends ConditionalEffectItem implements IGarnishedUtilities {
	public PiquantPretzelFoodItem(Properties properties) {
		super(5, 1.0F, properties.food(GarnishedFoodValues.PIQUANT_PRETZEL).stacksTo(16));
	}
}
