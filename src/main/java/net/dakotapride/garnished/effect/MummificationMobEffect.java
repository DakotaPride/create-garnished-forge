package net.dakotapride.garnished.effect;

import net.dakotapride.garnished.registry.GarnishedParticles;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import org.jetbrains.annotations.NotNull;

public class MummificationMobEffect extends MobEffect {
    public MummificationMobEffect() {
        super(MobEffectCategory.HARMFUL, 0xB2FF8E);
    }

    @Override
    public @NotNull ParticleOptions createParticleOptions(MobEffectInstance effect) {
        return GarnishedParticles.MUMMY.get();
    }

    @Override
    public void removeAttributeModifiers(AttributeMap attributeMap) {
        super.removeAttributeModifiers(attributeMap);
    }

    // 1.21 broke this method, for some reason
//    @Override
//    public void removeAttributeModifiers(LivingEntity entity, AttributeMap pAttributeMap, int amplifier) {
//        entity.hurt(entity.damageSources().magic(), (float)(6 << amplifier));
//        super.removeAttributeModifiers(entity, pAttributeMap, amplifier);
//    }
}
