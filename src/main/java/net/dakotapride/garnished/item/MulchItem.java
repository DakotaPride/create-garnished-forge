package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedDamageSource;
import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MulchItem extends Item implements IGarnishedUtilities {
	public MulchItem(Properties properties) {
		super(properties.food(GarnishedFoodValues.MULCH));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		livingEntity.hurt(level.damageSources().source(GarnishedDamageSource.MULCH_MUNCHING), 2.0F);
		return super.finishUsingItem(stack, level, livingEntity);
	}
}
