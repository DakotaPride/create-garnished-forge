package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.effect.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GarnishedEffects {
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, CreateGarnished.ID);
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, CreateGarnished.ID);
	public static final DeferredRegister<Potion> VANILLA_POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, "minecraft");

	public static final DeferredHolder<MobEffect, MobEffect> AVERSION = EFFECTS.register("aversion", () -> new AversionMobEffect()
			.addAttributeModifier(Attributes.MOVEMENT_SPEED, CreateGarnished.asResource("garnished.aversion.movement_speed"),
					-0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
			.addAttributeModifier(Attributes.ATTACK_DAMAGE, CreateGarnished.asResource("garnished.aversion.attack_damage"),
					-0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

	public static DeferredHolder<MobEffect, MobEffect> SPIRITED_RESISTANCE = EFFECTS.register("spirited_resistance", SpiritedResistanceMobEffect::new);

	public static DeferredHolder<MobEffect, MobEffect> COGNATE = EFFECTS.register("cognate", CognateMobEffect::new);
	public static DeferredHolder<MobEffect, MobEffect> FLAGRANT = EFFECTS.register("flagrant", FlagrantMobEffect::new);

	public static DeferredHolder<MobEffect, MobEffect> SUGAR_HIGH = EFFECTS.register("sugar_high", () -> new SugarHighMobEffect()
			.addAttributeModifier(Attributes.MOVEMENT_SPEED, CreateGarnished.asResource("garnished.sugar_high.movement_speed"),
					0.075, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

	public static DeferredHolder<MobEffect, MobEffect> SANCTITY = EFFECTS.register("sanctity", () -> new SanctityMobEffect()
			.addAttributeModifier(Attributes.ARMOR, CreateGarnished.asResource("garnished.sanctity.armour"),
					4.0, AttributeModifier.Operation.ADD_VALUE));

	public static DeferredHolder<MobEffect, MobEffect> THORNS = EFFECTS.register("thorns", ThornsMobEffect::new);
	public static DeferredHolder<MobEffect, MobEffect> MUMMIFICATION = EFFECTS.register("mummification", () -> new MummificationMobEffect()
			.addAttributeModifier(Attributes.MOVEMENT_SPEED, CreateGarnished.asResource("garnished."),
					-0.015, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

	public static DeferredHolder<MobEffect, MobEffect> FREEZING = EFFECTS.register("freezing", FreezingMobEffect::new);

	public static DeferredHolder<MobEffect, MobEffect> TRUTH_SEEKER = EFFECTS.register("truth_seeker", TruthSeekerMobEffect::new);

	public static DeferredHolder<MobEffect, MobEffect> AUGMENTED = EFFECTS.register("augmented", () -> new AugmentedMobEffect()
			.addAttributeModifier(Attributes.MOVEMENT_SPEED, CreateGarnished.asResource("garnished.augmented.movement_speed"),
					0.045, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
			.addAttributeModifier(Attributes.ATTACK_DAMAGE, CreateGarnished.asResource("garnished.augmented.attack_damage"),
					-0.20, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

	public static final DeferredHolder<Potion, Potion> AVERSION_POTION = POTIONS.register("aversion",
			() -> new Potion(new MobEffectInstance(AVERSION, 2400)));
	public static DeferredHolder<Potion, Potion> LONG_AVERSION_POTION = POTIONS.register("long_aversion",
			() -> new Potion("aversion", new MobEffectInstance(AVERSION, 3600)));

	public static final DeferredHolder<Potion, Potion> FLAGRANT_POTION = POTIONS.register("flagrant",
			() -> new Potion("flagrant", new MobEffectInstance(FLAGRANT, 2400)));

	public static DeferredHolder<Potion, Potion> BLINDNESS_POTION = VANILLA_POTIONS.register("blindness",
			() -> new Potion(new MobEffectInstance(MobEffects.BLINDNESS, 2400)));

	public static final DeferredHolder<Potion, Potion> SANCTITY_POTION = POTIONS.register("sanctity",
			() -> new Potion("sanctity", new MobEffectInstance(SANCTITY, 2800)));

	public static final DeferredHolder<Potion, Potion> MUMMIFICATION_POTION = POTIONS.register("mummification",
			() -> new Potion(new MobEffectInstance(MUMMIFICATION, 1200)));

	public static final DeferredHolder<Potion, Potion> FREEZING_POTION = POTIONS.register("freezing",
			() -> new Potion(new MobEffectInstance(FREEZING, 400)));
	public static final DeferredHolder<Potion, Potion> LONG_FREEZING_POTION = POTIONS.register("long_freezing",
			() -> new Potion(new MobEffectInstance(FREEZING, 800, 1)));

	public static void setRegister(IEventBus bus) {
		EFFECTS.register(bus);
		POTIONS.register(bus);
		VANILLA_POTIONS.register(bus);
	}

}
