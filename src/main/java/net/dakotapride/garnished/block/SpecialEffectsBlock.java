package net.dakotapride.garnished.block;

import net.dakotapride.garnished.GarnishedConfigs;
import net.dakotapride.garnished.item.IGarnishedUtilities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("unused")
public class SpecialEffectsBlock implements IGarnishedUtilities {

    public static class Abyssal {

        public static void getParticles(BlockState state, Level level, BlockPos pos, RandomSource random) {
            if (!GarnishedConfigs.client().abyssalStoneParticles.get())
                return;

            for(int i = 0; i < 4; ++i) {
                double d0 = (double) pos.getX() + random.nextDouble();
                double d1 = (double) pos.getY() + random.nextDouble();
                double d2 = (double) pos.getZ() + random.nextDouble();
                double d3 = ((double) random.nextFloat() - 0.5D) * 0.5D;
                double d4 = ((double) random.nextFloat() - 0.5D) * 0.5D;
                double d5 = ((double) random.nextFloat() - 0.5D) * 0.5D;
                int j = random.nextInt(2) * 2 - 1;
                if (!level.getBlockState(pos.west()).is(state.getBlock()) && !level.getBlockState(pos.east()).is(state.getBlock())) {
                    d0 = (double) pos.getX() + 0.5D + 0.25D * (double) j;
                    d3 = (random.nextFloat() * 2.0F * (float) j);
                } else {
                    d2 = (double) pos.getZ() + 0.5D + 0.25D * (double) j;
                    d5 = (random.nextFloat() * 2.0F * (float) j);
                }

                level.addParticle(ParticleTypes.ASH, d0, d1, d2, d3, d4, d5);
            }
        }

        public static void getEffects(Level level, BlockPos pos, BlockState state, Entity entity) {
            if (entity instanceof LivingEntity living && GarnishedConfigs.server().block.providesBlindness.get()) {
                living.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, tick * GarnishedConfigs.server().block.blindnessDuration.get(), 0));
            }

        }
    }

    public static class Unstable {

        public static void getParticles(BlockPos pos, RandomSource random, Level level, BlockState state, ParticleOptions options) {
            for(int i = 0; i < 4; ++i) {
                double d0 = (double) pos.getX() + random.nextDouble();
                double d1 = (double) pos.getY() + random.nextDouble();
                double d2 = (double) pos.getZ() + random.nextDouble();
                double d3 = ((double) random.nextFloat() - 0.5D) * 0.5D;
                double d4 = ((double) random.nextFloat() - 0.5D) * 0.5D;
                double d5 = ((double) random.nextFloat() - 0.5D) * 0.5D;
                int j = random.nextInt(2) * 2 - 1;
                if (!level.getBlockState(pos.west()).is(state.getBlock()) && !level.getBlockState(pos.east()).is(state.getBlock())) {
                    d0 = (double) pos.getX() + 0.5D + 0.25D * (double) j;
                    d3 = (random.nextFloat() * 2.0F * (float) j);
                } else {
                    d2 = (double) pos.getZ() + 0.5D + 0.25D * (double) j;
                    d5 = (random.nextFloat() * 2.0F * (float) j);
                }

                level.addParticle(options, d0, d1, d2, d3, d4, d5);
            }
        }

        public static void getEffects(Level level, BlockPos pos, BlockState state, Entity entity) {
            if (entity instanceof LivingEntity living && GarnishedConfigs.server().block.providesSpeed.get()) {
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, tick * GarnishedConfigs.server().block.speedDuration.get(), GarnishedConfigs.server().block.speedAmplifier.get()));
            }

        }
    }

    public static class Wyvern {

        public static void getParticles(BlockState state, Level level, BlockPos pos, RandomSource random) {
            if (!GarnishedConfigs.client().wyvernStoneParticles.get())
                return;

            for(int i = 0; i < 8; ++i) {
                double d0 = (double) pos.getX() + random.nextDouble();
                double d1 = (double) pos.getY() + random.nextDouble();
                double d2 = (double) pos.getZ() + random.nextDouble();
                double d3 = ((double) random.nextFloat() - 0.5D) * 0.5D;
                double d4 = ((double) random.nextFloat() - 0.5D) * 0.5D;
                double d5 = ((double) random.nextFloat() - 0.5D) * 0.5D;
                int j = random.nextInt(2) * 2 - 1;
                if (!level.getBlockState(pos.west()).is(state.getBlock()) && !level.getBlockState(pos.east()).is(state.getBlock())) {
                    d0 = (double) pos.getX() + 0.5D + 0.25D * (double) j;
                    d3 = (random.nextFloat() * 2.0F * (float) j);
                } else {
                    d2 = (double) pos.getZ() + 0.5D + 0.25D * (double) j;
                    d5 = (random.nextFloat() * 2.0F * (float) j);
                }

                level.addParticle(ParticleTypes.ENCHANT, d0, d1, d2, d3, d4, d5);
            }
        }

        public static void getEffects(Level level, BlockPos pos, BlockState state, Entity entity) {
            RandomSource random = RandomSource.create();
            int effect_list = random.nextInt(10);
            int effect_trigger = random.nextInt(6);

            if (!GarnishedConfigs.server().block.providesRandomEffects.get())
                return;

            if (entity instanceof LivingEntity living && !level.isClientSide) {

                if (effect_trigger == 1 && effect_list >= 0 && effect_list <= 10) {
                    switch (effect_list) {
                        case 0 -> applyEffectIfNotPresent(living, MobEffects.LUCK, GarnishedConfigs.server().block.effectsDuration.get(), GarnishedConfigs.server().block.effectsAmplifier.get());
                        case 1 -> applyEffectIfNotPresent(living, MobEffects.MOVEMENT_SPEED, GarnishedConfigs.server().block.effectsDuration.get(), GarnishedConfigs.server().block.effectsAmplifier.get());
                        case 2 -> applyEffectIfNotPresent(living, MobEffects.JUMP, GarnishedConfigs.server().block.effectsDuration.get(), GarnishedConfigs.server().block.effectsAmplifier.get());
                        case 3 -> applyEffectIfNotPresent(living, MobEffects.DAMAGE_RESISTANCE, GarnishedConfigs.server().block.effectsDuration.get(), GarnishedConfigs.server().block.effectsAmplifier.get());
                        case 4 -> applyEffectIfNotPresent(living, MobEffects.REGENERATION, GarnishedConfigs.server().block.effectsDuration.get(), GarnishedConfigs.server().block.effectsAmplifier.get());
                        case 5 -> applyEffectIfNotPresent(living, MobEffects.GLOWING, GarnishedConfigs.server().block.effectsDuration.get(), GarnishedConfigs.server().block.effectsAmplifier.get());
                        case 6 -> applyEffectIfNotPresent(living, MobEffects.DAMAGE_BOOST, GarnishedConfigs.server().block.effectsDuration.get(), GarnishedConfigs.server().block.effectsAmplifier.get());
                        case 7 -> applyEffectIfNotPresent(living, MobEffects.DIG_SPEED, GarnishedConfigs.server().block.effectsDuration.get(), GarnishedConfigs.server().block.effectsAmplifier.get());
                        case 8 -> applyEffectIfNotPresent(living, MobEffects.FIRE_RESISTANCE, GarnishedConfigs.server().block.effectsDuration.get(), GarnishedConfigs.server().block.effectsAmplifier.get());
                        case 9 -> applyEffectIfNotPresent(living, MobEffects.NIGHT_VISION, GarnishedConfigs.server().block.effectsDuration.get(), GarnishedConfigs.server().block.effectsAmplifier.get());
                        case 10 -> applyEffectIfNotPresent(living, MobEffects.INVISIBILITY, GarnishedConfigs.server().block.effectsDuration.get(), GarnishedConfigs.server().block.effectsAmplifier.get());
                        default -> throw new IllegalStateException("Unexpected value: " + effect_list);
                    }
                }
            }

        }

        private static void applyEffectIfNotPresent(LivingEntity living, Holder<MobEffect> effect) {
            applyEffectIfNotPresent(living, effect, tick * 15, 0);
        }

        private static void applyEffectIfNotPresent(LivingEntity living, Holder<MobEffect> effect, int durationSeconds, int amplifier) {
            if (living.hasEffect(effect))
                return;

            living.addEffect(new MobEffectInstance(effect, tick * durationSeconds, amplifier));
        }
    }
}
