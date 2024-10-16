package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class PricklyPearFoodItem extends ConditionalEffectItem implements IGarnishedUtilities {
	public PricklyPearFoodItem(Properties properties) {
		super(2, 0.15F, properties.food(GarnishedFoodValues.PRICKLY_PEAR));
	}
}
