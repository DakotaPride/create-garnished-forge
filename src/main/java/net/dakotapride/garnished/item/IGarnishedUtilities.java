package net.dakotapride.garnished.item;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.registry.GarnishedEffects;
import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.Mth;
import net.minecraft.util.StringUtil;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Random;

public interface IGarnishedUtilities {
	int tick = 20;
	int cinder_dur = tick * 90;
	int cr_cider_dur = tick * 45;
	int bit_cider_dur = tick * 40;
	int cashew_dur = tick * 50;
	int almond_dur = tick * 25;
	int tangle_dur = tick * 45;
	int cashew_mix_dur = tick * 180;
	int cognate_dur = tick * 60;
	int cane_effect_dur = tick * 10;
	int sugar_high_dur = tick * 25;

	default void addEffectTooltip(List<Component> tooltip, Holder<MobEffect> effect, int amplifier, float duration) {
		tooltip.add(Component.translatable("text.garnished.applies_effect", Component.translatable(effect.value().getDescriptionId()), amplifier, formatDuration(new MobEffectInstance(effect), duration, 1)).withStyle(effect.value().getCategory().getTooltipFormatting()));
	}

	default void addEffectTooltip(List<Component> tooltip, Holder<MobEffect> effect, float duration) {
		tooltip.add(Component.translatable("text.garnished.applies_effect.no_amplifier", Component.translatable(effect.value().getDescriptionId()), formatDuration(new MobEffectInstance(effect), duration, 1)).withStyle(effect.value().getCategory().getTooltipFormatting()));
	}

	default void addEffectTooltipConditionalPositive(List<Component> tooltip, Holder<MobEffect> effect, float duration) {
		tooltip.add(Component.translatable("text.garnished.applies_effect.no_amplifier.conditional.pos", Component.translatable(effect.value().getDescriptionId()).withStyle(ChatFormatting.BLUE), Component.translatable("text.garnished.effect.duration", formatDuration(new MobEffectInstance(effect), duration, 1)).withStyle(effect.value().getCategory().getTooltipFormatting())).withStyle(ChatFormatting.GOLD));
	}

	default void addEffectTooltipConditionalNegative(List<Component> tooltip, Holder<MobEffect> effect, float duration) {
		tooltip.add(Component.translatable("text.garnished.applies_effect.no_amplifier.conditional.neg", Component.translatable(effect.value().getDescriptionId()).withStyle(ChatFormatting.RED), Component.translatable("text.garnished.effect.duration", formatDuration(new MobEffectInstance(effect), duration, 1)).withStyle(effect.value().getCategory().getTooltipFormatting())).withStyle(ChatFormatting.GOLD));
	}

	default void addChanceForEffect(List<Component> tooltip, float chance) {
		if (Screen.hasShiftDown()) {
			tooltip.add(Component.translatable("text.garnished.applies_effect.chance", chance + "%").withStyle(ChatFormatting.GRAY));
		}
	}

	default Component formatDuration(MobEffectInstance effect, float duration, float durationFactor) {
		if (effect.isInfiniteDuration()) {
			return Component.translatable("effect.duration.infinite");
		} else {
			int i = Mth.floor(duration * durationFactor);
			return Component.literal(StringUtil.formatTickDuration(i, 20));
		}
	}

	default void triggerConditionalEffect(int value, float chance, LivingEntity entity) {
		float floatChance = new Random().nextInt(0, 100);
		Level level = entity.level();

		// Sugar High functionality
		boolean hasSugarHigh = entity.hasEffect(GarnishedEffects.SUGAR_HIGH);
		// Freezing functionality
		boolean hasFreezing = entity.hasEffect(GarnishedEffects.FREEZING) || entity.isFreezing();
		// Hunger functionality
		boolean hasHunger = entity.hasEffect(MobEffects.HUNGER);
		// Levitation functionality
		boolean hasLevitation = entity.hasEffect(MobEffects.LEVITATION);
		// Bad Omen functionality
		boolean hasOmen = entity.hasEffect(MobEffects.BAD_OMEN) || entity.hasEffect(MobEffects.RAID_OMEN) || entity.hasEffect(MobEffects.TRIAL_OMEN);
		// Fire functionality
		boolean isOnFire = entity.isOnFire() || !entity.fireImmune();

		boolean has = floatChance > 0;

		if (!level.isClientSide) {
			if (value == 0) {
				has = hasSugarHigh;
				if (has && floatChance <= chance)
					entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, tick * 12, 1));
			}

			if (value == 1) {
				has = hasFreezing;
				if (has && floatChance <= chance)
					entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, tick * 12, 1));
			}
			if (value == 2) {
				has = hasHunger;
				if (has && floatChance <= chance)
					entity.addEffect(new MobEffectInstance(GarnishedEffects.THORNS, tick * 24, 1));
			}
			if (value == 3) {
				has = hasLevitation;
				if (has && floatChance <= chance)
					entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, tick * 24, 1));
			}
			if (value == 4) {
				has = hasOmen;
				if (has && floatChance <= chance)
					entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, tick * 36, 1));
				else entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, tick * 36, 1));
			}
			if (value == 5) {
				has = isOnFire;
				if (has && floatChance <= chance)
					entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, tick * 24, 1));
			}
			if (value == 6) {
				int random = new Random().nextInt(2);

				has = random == 1;

				if (random == 1) {
					entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, cr_cider_dur, 2));
				} else {
					entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, cr_cider_dur, 2));
				}
			}
		}

        CreateGarnished.LOGGER.info("achieved float value: {}, requested value: {}, requested value : {}, shouldApply: {}", floatChance, chance, value, has);

		//entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, tick * 20, 1, false, false, false));
	}


}
