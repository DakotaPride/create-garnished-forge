package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class ChampionsOmeletteFoodItem extends ConditionalEffectItem implements IGarnishedUtilities {
	public ChampionsOmeletteFoodItem(Properties properties) {
		super(3, 100, properties.food(GarnishedFoodValues.CHAMPIONS_OMELETTE).stacksTo(16));
	}
}
