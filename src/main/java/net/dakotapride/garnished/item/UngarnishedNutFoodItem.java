package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UngarnishedNutFoodItem extends Item implements IGarnishedUtilities {
	public UngarnishedNutFoodItem(Properties properties) {
		super(properties.food(GarnishedFoodValues.UNGARNISHED_NUT));
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> tooltip, @NotNull TooltipFlag isAdvanced) {
		tooltip.add(Component.translatable(ungarnishedText()).withStyle(standard()));
	}
}
