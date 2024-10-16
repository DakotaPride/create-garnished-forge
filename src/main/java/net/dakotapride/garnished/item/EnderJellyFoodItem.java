package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class EnderJellyFoodItem extends ConditionalEffectItem implements IGarnishedUtilities {
	public EnderJellyFoodItem(Properties properties) {
		super(0, 1.0F, properties.food(GarnishedFoodValues.ENDER_JELLY));
	}
}
