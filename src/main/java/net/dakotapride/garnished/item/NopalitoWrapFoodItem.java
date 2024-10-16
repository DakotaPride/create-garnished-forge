package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class NopalitoWrapFoodItem extends ConditionalEffectItem implements IGarnishedUtilities {
	public NopalitoWrapFoodItem(Properties properties) {
		super(1, 0.65F, properties.food(GarnishedFoodValues.NOPALITO_WRAP).stacksTo(16));
	}
}
