package net.dakotapride.creategarnished.effect;

import net.dakotapride.creategarnished.registry.CreateGarnishedDamageTypes;
import net.dakotapride.creategarnished.registry.CreateGarnishedParticles;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class VoltStruckMobEffect extends MobEffect {
    public VoltStruckMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public @NotNull ParticleOptions createParticleOptions(@NotNull MobEffectInstance effect) {
        return CreateGarnishedParticles.VOLT.get();
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int i) {
        float damageCount = 1.0F;
        if (entity.isInWater()) {
            damageCount = 2.0F;
        }

        Registry<DamageType> dTypeReg = entity.damageSources().damageTypes;
        Holder.Reference<DamageType> dType = dTypeReg.getHolder(CreateGarnishedDamageTypes.SHOCK).orElse(dTypeReg.getHolderOrThrow(DamageTypes.MAGIC));
        entity.hurt(new DamageSource(dType), damageCount);

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int f, int g) {
        int i = 25 >> g;
        return i == 0 || f % i == 0;
    }
}
