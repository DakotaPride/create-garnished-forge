package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SaladFoodItem extends Item implements IGarnishedUtilities {
	public SaladFoodItem(Properties properties) {
		super(properties.food(GarnishedFoodValues.SALAD));
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
		tooltip.add(Component.translatable("text.garnished.salted_food").withStyle(standard()));
	}
}
