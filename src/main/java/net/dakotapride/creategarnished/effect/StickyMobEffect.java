package net.dakotapride.creategarnished.effect;

import net.dakotapride.creategarnished.registry.CreateGarnishedParticles;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import org.jetbrains.annotations.NotNull;

public class StickyMobEffect extends MobEffect {
    public StickyMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public @NotNull ParticleOptions createParticleOptions(@NotNull MobEffectInstance effect) {
        return CreateGarnishedParticles.CARAMEL.get();
    }
}
