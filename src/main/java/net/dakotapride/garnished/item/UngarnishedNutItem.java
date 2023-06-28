package net.dakotapride.garnished.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class UngarnishedNutItem extends UngarnishedFoodItem {
	public UngarnishedNutItem(Properties properties) {
		super(properties.food(new FoodProperties.Builder().saturationMod(0.2F).nutrition(3)
				.effect(new MobEffectInstance(MobEffects.CONFUSION, 240), 1.0F).build()));
	}
}
