package net.dakotapride.garnished.block;

import net.dakotapride.garnished.item.IGarnishedUtilities;
import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.dakotapride.garnished.registry.GarnishedPaletteStoneTypes;
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
            if (entity instanceof LivingEntity living) {
                living.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 0));
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
            RandomSource random = RandomSource.create();

            if (entity instanceof LivingEntity living) {
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 1));
            }

        }
    }

    public static class Wyvern {

        public static void getParticles(BlockState state, Level level, BlockPos pos, RandomSource random) {
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
            if (entity instanceof LivingEntity living && !level.isClientSide) {

                applyEffectIfNotPresent(living, MobEffects.LUCK);
                applyEffectIfNotPresent(living, MobEffects.MOVEMENT_SPEED);
                applyEffectIfNotPresent(living, MobEffects.JUMP);
                applyEffectIfNotPresent(living, MobEffects.DAMAGE_RESISTANCE);
                applyEffectIfNotPresent(living, MobEffects.REGENERATION);
                applyEffectIfNotPresent(living, MobEffects.GLOWING);
                applyEffectIfNotPresent(living, MobEffects.DAMAGE_BOOST);
                applyEffectIfNotPresent(living, MobEffects.DIG_SPEED);
                applyEffectIfNotPresent(living, MobEffects.FIRE_RESISTANCE);
                applyEffectIfNotPresent(living, MobEffects.NIGHT_VISION);
                applyEffectIfNotPresent(living, MobEffects.INVISIBILITY);
            }
        }

        private static void applyEffectIfNotPresent(LivingEntity living, Holder<MobEffect> effect) {
            if (!living.hasEffect(effect)) {
                living.addEffect(new MobEffectInstance(effect, tick * 15, 0));
            }
        }
    }
}
