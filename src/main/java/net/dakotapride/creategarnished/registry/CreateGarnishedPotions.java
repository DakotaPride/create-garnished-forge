package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreateGarnishedPotions {
    public static DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, CreateGarnished.ID);
    public static final DeferredHolder<Potion, Potion> NUT_ALLERGY_POTION = POTIONS.register("nut_allergy", () -> new Potion("nut_allergy", new MobEffectInstance(CreateGarnishedStatusEffects.NUT_ALLERGY, 12000)));

    public static void register(IEventBus bus) {
        POTIONS.register(bus);
    }
}