package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.effect.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GarnishedEffects {
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CreateGarnished.ID);
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, CreateGarnished.ID);
	public static final DeferredRegister<Potion> VANILLA_POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, "minecraft");

	public static final RegistryObject<MobEffect> AVERSION = EFFECTS.register("aversion", () -> new AversionMobEffect()
			.addAttributeModifier(Attributes.MOVEMENT_SPEED, "8280b3f7-933d-426e-8398-a171d2339dc6",
					-0.25, AttributeModifier.Operation.MULTIPLY_TOTAL)
			.addAttributeModifier(Attributes.ATTACK_DAMAGE, "9f2c068e-013e-4413-8df6-6a08f19cdcc2",
					-0.15, AttributeModifier.Operation.MULTIPLY_TOTAL));

	public static RegistryObject<MobEffect> SPIRITED_RESISTANCE = EFFECTS.register("spirited_resistance", SpiritedResistanceMobEffect::new);

	public static RegistryObject<MobEffect> COGNATE = EFFECTS.register("cognate", CognateMobEffect::new);
	public static RegistryObject<MobEffect> FLAGRANT = EFFECTS.register("flagrant", FlagrantMobEffect::new);

	public static RegistryObject<MobEffect> SUGAR_HIGH = EFFECTS.register("sugar_high", () -> new SugarHighMobEffect()
			.addAttributeModifier(Attributes.MOVEMENT_SPEED, "660fa62e-0096-4f99-9b9a-9311d1936b89",
					0.075, AttributeModifier.Operation.MULTIPLY_TOTAL));

	public static RegistryObject<MobEffect> SANCTITY = EFFECTS.register("sanctity", () -> new SanctityMobEffect()
			.addAttributeModifier(Attributes.ARMOR, "3a7cbac5-6234-49c8-93d0-fdacad4af501",
					4.0, AttributeModifier.Operation.ADDITION));

	public static RegistryObject<MobEffect> THORNS = EFFECTS.register("thorns", ThornsMobEffect::new);

	public static final RegistryObject<Potion> AVERSION_POTION = POTIONS.register("aversion",
			() -> new Potion(new MobEffectInstance(AVERSION.get(), 2400)));
	public static RegistryObject<Potion> LONG_AVERSION_POTION = POTIONS.register("long_aversion",
			() -> new Potion("aversion", new MobEffectInstance(AVERSION.get(), 3600)));

	public static final RegistryObject<Potion> FLAGRANT_POTION = POTIONS.register("flagrant",
			() -> new Potion(new MobEffectInstance(FLAGRANT.get(), 2400)));

	public static final RegistryObject<Potion> BLINDNESS_POTION = VANILLA_POTIONS.register("blindness",
			() -> new Potion(new MobEffectInstance(MobEffects.BLINDNESS, 2400)));

	public static final RegistryObject<Potion> SANCTITY_POTION = POTIONS.register("sanctity",
			() -> new Potion(new MobEffectInstance(SANCTITY.get(), 2800)));

	public static void setRegister(IEventBus bus) {
		EFFECTS.register(bus);
		POTIONS.register(bus);
		VANILLA_POTIONS.register(bus);
	}

}
