package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.effect.NutAllergyMobEffect;
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

    private static DeferredHolder<MobEffect, MobEffect> register(String name, MobEffect effect) {
        return MOB_EFFECTS.register(name, () -> effect);
    }

    public static void register(IEventBus bus) {
        MOB_EFFECTS.register(bus);
    }
}
