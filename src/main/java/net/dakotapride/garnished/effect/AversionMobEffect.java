package net.dakotapride.garnished.effect;

import net.dakotapride.garnished.registry.GarnishedDamageSource;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class AversionMobEffect extends MobEffect {
	public AversionMobEffect() {
		super(MobEffectCategory.HARMFUL, 0xC9B393);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int i) {
		Registry<DamageType> dTypeReg = entity.damageSources().damageTypes;
		Holder.Reference<DamageType> dType = dTypeReg.getHolder(GarnishedDamageSource.NUT_ACHE).orElse(dTypeReg.getHolderOrThrow(DamageTypes.MAGIC));
		entity.hurt(new DamageSource(dType), 2.0F);

		return true;
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int f, int g) {
		int i = 25 >> g;
		return i == 0 || f % i == 0;
	}
}
