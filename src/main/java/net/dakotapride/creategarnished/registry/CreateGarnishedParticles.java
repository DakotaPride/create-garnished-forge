package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreateGarnishedParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, CreateGarnished.ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ELVEN_MYSTICAL_PARTICLE =
            PARTICLE_TYPES.register("elven_mystical_particle", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> HATCHET_PARTICLE =
            PARTICLE_TYPES.register("hatchet", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VOLT =
            PARTICLE_TYPES.register("volt", () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
