package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class CashewSorbetScoopFoodItem extends ConditionalEffectItem implements IGarnishedUtilities {
	public CashewSorbetScoopFoodItem(Properties properties) {
		super(0, 0.65F, properties.food(GarnishedFoodValues.CASHEW_SORBET_SCOOP));
	}
}
