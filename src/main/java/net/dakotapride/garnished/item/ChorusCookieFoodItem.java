package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoods;
import net.minecraft.world.item.Item;

public class ChorusCookieFoodItem extends Item implements IGarnishedItem {
	public ChorusCookieFoodItem(Properties properties) {
		super(properties.food(GarnishedFoods.CHORUS_COOKIE));
	}
}
