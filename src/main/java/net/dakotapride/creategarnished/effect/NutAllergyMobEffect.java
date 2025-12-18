package net.dakotapride.creategarnished.effect;

import net.dakotapride.creategarnished.entity.squirrel.SquirrelEntity;
import net.dakotapride.creategarnished.registry.CreateGarnishedDamageSources;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class NutAllergyMobEffect extends MobEffect {
    public NutAllergyMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int i) {
        entity.hurt(CreateGarnishedDamageSources.nutAche(entity.level()), 1.0F);
        return !(entity instanceof SquirrelEntity);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int f, int g) {
        int i = 25 >> g;
        return i == 0 || f % i == 0;
    }
}
