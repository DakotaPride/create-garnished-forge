package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.effect.NutAllergyMobEffect;
import net.dakotapride.creategarnished.effect.SoothingMobEffect;
import net.dakotapride.creategarnished.effect.StickyMobEffect;
import net.dakotapride.creategarnished.effect.VoltStruckMobEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreateGarnishedStatusEffects {
    public static DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, CreateGarnished.ID);

    public static final DeferredHolder<MobEffect, MobEffect> NUT_ALLERGY = register("nut_allergy",
            (new NutAllergyMobEffect(MobEffectCategory.HARMFUL, 0xA5784B))
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, CreateGarnished.asResource("effect.nut_allergy"),
                            -4.0F, AttributeModifier.Operation.ADD_VALUE));
    public static final DeferredHolder<MobEffect, MobEffect> SOOTHING = register("soothing",
            (new SoothingMobEffect(MobEffectCategory.BENEFICIAL, 0xC3812F))
                    .addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, CreateGarnished.asResource("effect.soothing.knockback_resistance"),
                            1.0, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, CreateGarnished.asResource("effect.soothing.movement_speed"),
                            0.1F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    public static final DeferredHolder<MobEffect, MobEffect> VOLT_STRUCK = register("volt_struck",
            (new VoltStruckMobEffect(MobEffectCategory.NEUTRAL, 0xF07AEB)));
    public static final DeferredHolder<MobEffect, MobEffect> STICKY = register("sticky",
            (new StickyMobEffect(MobEffectCategory.NEUTRAL, 0xCC5B39))
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, CreateGarnished.asResource("effect.sticky.movement_speed"),
                            -0.25F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.GRAVITY, CreateGarnished.asResource("effect.sticky.gravity"),
                            0.25F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.JUMP_STRENGTH, CreateGarnished.asResource("effect.sticky.jump_strength"),
                            0.5F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    private static DeferredHolder<MobEffect, MobEffect> register(String name, MobEffect effect) {
        return MOB_EFFECTS.register(name, () -> effect);
    }

    public static void register(IEventBus bus) {
        MOB_EFFECTS.register(bus);
    }
}
