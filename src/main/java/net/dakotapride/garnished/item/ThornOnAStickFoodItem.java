package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class ThornOnAStickFoodItem extends ConditionalEffectItem implements IGarnishedUtilities {
	public ThornOnAStickFoodItem(Properties properties) {
		super(2, 100, properties.food(GarnishedFoodValues.THORN_ON_A_STICK).stacksTo(16));
	}
}
