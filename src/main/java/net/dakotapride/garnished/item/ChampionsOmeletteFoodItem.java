package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedEffects;
import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChampionsOmeletteFoodItem extends ConditionalEffectItem implements IGarnishedUtilities {
	public ChampionsOmeletteFoodItem(Properties properties) {
		super(3, 100, properties.food(GarnishedFoodValues.CHAMPIONS_OMELETTE).stacksTo(16));
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
		tooltip.add(Component.translatable("text.garnished.champions_omelette.cures_nut_allergy").withStyle(ChatFormatting.GOLD));
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level world, @NotNull LivingEntity livingEntity) {
		if (livingEntity.hasEffect(GarnishedEffects.AVERSION)) {
			livingEntity.removeEffect(GarnishedEffects.AVERSION);
		}
		return super.finishUsingItem(stack, world, livingEntity);
	}
}
