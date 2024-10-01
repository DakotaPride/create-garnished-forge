package net.dakotapride.garnished.mixin;

import net.dakotapride.garnished.item.hatchet.HatchetUtils;
import net.dakotapride.garnished.registry.GarnishedAdvancementUtils;
import net.dakotapride.garnished.registry.GarnishedEffects;
import net.dakotapride.garnished.registry.GarnishedEnchantments;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.Random;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	@Unique
	LivingEntity entity = (LivingEntity) (Object) this;

	public LivingEntityMixin(EntityType<?> entityType, Level level) {
		super(entityType, level);
	}

	@Inject(method = "tickEffects", at = @At("HEAD"))
	private void spiritedResistanceImmunity$tickEffects(CallbackInfo ci) {
		if (entity.hasEffect(GarnishedEffects.SPIRITED_RESISTANCE.get())) {
			if (entity.hasEffect(MobEffects.WITHER))
				entity.removeEffect(MobEffects.WITHER);
			if (entity.hasEffect(MobEffects.CONFUSION))
				entity.removeEffect(MobEffects.CONFUSION);
			if (entity.hasEffect(MobEffects.BLINDNESS))
				entity.removeEffect(MobEffects.BLINDNESS);
		}

		if (HatchetUtils.canApplyRavagingEffects(entity)) {
			entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1));
		}
	}

	@Inject(method = "getDamageAfterMagicAbsorb", at = @At("HEAD"))
	private void spiritedResistanceThorns$getDamageAfterMagicAbsorb(DamageSource source, float amount, CallbackInfoReturnable<Float> cir) {
		// LivingEntity attacker = (LivingEntity) source.getEntity();

		if (source.getEntity() instanceof LivingEntity attacker) {
			boolean isSkeleton = attacker instanceof Skeleton;
			boolean isWitherSkeleton = attacker instanceof WitherSkeleton;
			boolean isWither = attacker instanceof WitherBoss;
			boolean isGhast = attacker instanceof Ghast;

			if (entity.hasEffect(GarnishedEffects.SPIRITED_RESISTANCE.get())) {
				if (isSkeleton || isWitherSkeleton || isWither || isGhast) {
					attacker.hurt(source, amount * 1.336745F);
				}
			}
		}
	}

	@Inject(method = "getDamageAfterMagicAbsorb", at = @At("HEAD"))
	private void applyThornsDamage$getDamageAfterMagicAbsorb(DamageSource source, float amount, CallbackInfoReturnable<Float> cir) {

		if (source.getDirectEntity() instanceof LivingEntity attacker) {
			if (entity.hasEffect(GarnishedEffects.THORNS.get()) && entity.getEffect(GarnishedEffects.THORNS.get()) != null) {
				attacker.hurt(entity.damageSources().thorns(entity), 3.0F * Objects.requireNonNull(entity.getEffect(GarnishedEffects.THORNS.get())).getAmplifier());
			}
		}

	}

	@Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
	private void negateArrowDamage$hurt(DamageSource pSource, float pAmount, CallbackInfoReturnable<Boolean> cir) {
		if (entity.hasEffect(GarnishedEffects.TRUTH_SEEKER.get()) && pSource.getDirectEntity() instanceof AbstractArrow && entity.getEffect(GarnishedEffects.TRUTH_SEEKER.get()) != null) {
			MobEffect truthSeekerMobEffect = GarnishedEffects.TRUTH_SEEKER.get();
            //assert truthSeekerMobEffect != null;
            int effectAmplifier = Objects.requireNonNull(entity.getEffect(truthSeekerMobEffect)).getAmplifier();
			int boundInt = 20 - effectAmplifier;
			int j = entity.getRandom().nextInt(10);
			int k = j + 10;

			int negateChance;

			if (boundInt <= 0) {
				negateChance = entity.getRandom().nextInt(1);
			} else {
				negateChance = entity.getRandom().nextInt(boundInt + 1);
			}


			if (negateChance <= k) {
				cir.setReturnValue(false);

				//System.out.println("[Create: Garnished] Negate Integer Value: successful");
			} //else System.out.println("[Create: Garnished] Negate Integer Value: failed");


			//System.out.println("[Create: Garnished] Rolled Negate Integer Value: " + k + "/" + negateChance);
		}
	}

	@Inject(method = "baseTick", at = @At("HEAD"))
	private void dejojoAdvancement(CallbackInfo ci) {
		if (entity instanceof ServerPlayer player && getStringUUID().equals("7282ae0d-c2f5-4610-8be9-70af5a1322a4")) {
			GarnishedAdvancementUtils.DEJOJO.trigger(player);
		}
	}

}
