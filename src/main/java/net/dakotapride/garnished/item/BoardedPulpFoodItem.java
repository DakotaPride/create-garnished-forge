package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class BoardedPulpFoodItem extends Item implements IGarnishedUtilities {
	public BoardedPulpFoodItem(Properties properties) {
		super(properties.food(GarnishedFoodValues.BOARDED_PULP));
	}
}
