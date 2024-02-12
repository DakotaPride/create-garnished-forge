package net.dakotapride.garnished.recipe;

import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingTypeRegistry;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import com.simibubi.create.foundation.utility.Color;
import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.registry.GarnishedDamageSource;
import net.dakotapride.garnished.registry.GarnishedFluids;
import net.dakotapride.garnished.registry.GarnishedRecipeTypes;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.List;
import java.util.Optional;

public class GarnishedFanProcessing {
    public static final FreezingType FREEZING = register("freezing", new FreezingType());
    public static final RedDyeBlowingType RED_DYE_BLOWING = register("red_dye_blowing", new RedDyeBlowingType());

    static {
        Object2ReferenceOpenHashMap<String, FanProcessingType> map = new Object2ReferenceOpenHashMap<>();
        map.put("FREEZING", FREEZING);
        map.put("RED_DYE_BLOWING", RED_DYE_BLOWING);
        map.trim();
    }

    private static <T extends FanProcessingType> T register(String id, T type) {
        FanProcessingTypeRegistry.register(CreateGarnished.asResource(id), type);
        return type;
    }

    public static class FreezingType implements FanProcessingType {
        private static final FreezingFanRecipe.FreezingWrapper FREEZING_WRAPPER = new FreezingFanRecipe.FreezingWrapper();

        @Override
        public boolean isValidAt(Level level, BlockPos pos) {
            FluidState fluidState = level.getFluidState(pos);
            if (fluidState.is(GarnishedTags.FAN_FREEZING_PROCESSING_FLUID_TAG)) {
                return true;
            }
            BlockState blockState = level.getBlockState(pos);
            return blockState.is(GarnishedTags.FAN_FREEZING_PROCESSING_TAG);
        }

        @Override
        public int getPriority() {
            return 600;
        }

        @Override
        public boolean canProcess(ItemStack stack, Level level) {
            FREEZING_WRAPPER.setItem(0, stack);
            Optional<FreezingFanRecipe> recipe = GarnishedRecipeTypes.FREEZING.find(FREEZING_WRAPPER, level);
            return recipe.isPresent();
        }

        @Override
        @Nullable
        public List<ItemStack> process(ItemStack stack, Level level) {
            FREEZING_WRAPPER.setItem(0, stack);
            Optional<FreezingFanRecipe> recipe = GarnishedRecipeTypes.FREEZING.find(FREEZING_WRAPPER, level);
            return recipe.map(freezingFanRecipe -> RecipeApplier.applyRecipeOn(level, stack, freezingFanRecipe)).orElse(null);
        }

        @Override
        public void spawnProcessingParticles(Level level, Vec3 pos) {
            if (level.random.nextInt(8) != 0)
                return;
            Vector3f color = new Color(0xDDE8FF).asVectorF();
            level.addParticle(new DustParticleOptions(color, 1), pos.x + (level.random.nextFloat() - .5f) * .5f,
                    pos.y + .5f, pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 8f, 0);
            level.addParticle(ParticleTypes.SNOWFLAKE, pos.x + (level.random.nextFloat() - .5f) * .5f, pos.y + .5f,
                    pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 8f, 0);
        }

        @Override
        public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
            particleAccess.setColor(Color.mixColors(0xEEEEFF, 0xDDE8FF, random.nextFloat()));
            particleAccess.setAlpha(1f);
            if (random.nextFloat() < 1 / 128f)
                particleAccess.spawnExtraParticle(ParticleTypes.SNOWFLAKE, .125f);
        }

        @Override
        public void affectEntity(Entity entity, Level level) {
            if (level.isClientSide) {
                return;
            }

            if (entity.canFreeze()) {
                entity.setTicksFrozen(120);
                entity.hurt(entity.damageSources().source(GarnishedDamageSource.FAN_FREEZING), 2.0F);
            }

            if (entity.isOnFire()) {
                entity.extinguishFire();
            }
        }
    }

    public static class RedDyeBlowingType implements FanProcessingType {
        private static final RedDyeBlowingFanRecipe.RedDyeBlowingWrapper RED_DYE_BLOWING_WRAPPER = new RedDyeBlowingFanRecipe.RedDyeBlowingWrapper();

        @Override
        public boolean isValidAt(Level level, BlockPos pos) {
            FluidState fluidState = level.getFluidState(pos);
            return fluidState.is(GarnishedFluids.RED_MASTIC_RESIN.get());
        }

        @Override
        public int getPriority() {
            return 600;
        }

        @Override
        public boolean canProcess(ItemStack stack, Level level) {
            RED_DYE_BLOWING_WRAPPER.setItem(0, stack);
            Optional<RedDyeBlowingFanRecipe> recipe = GarnishedRecipeTypes.RED_DYE_BLOWING.find(RED_DYE_BLOWING_WRAPPER, level);
            return recipe.isPresent();
        }

        @Override
        @Nullable
        public List<ItemStack> process(ItemStack stack, Level level) {
            RED_DYE_BLOWING_WRAPPER.setItem(0, stack);
            Optional<RedDyeBlowingFanRecipe> recipe = GarnishedRecipeTypes.RED_DYE_BLOWING.find(RED_DYE_BLOWING_WRAPPER, level);
            return recipe.map(freezingFanRecipe -> RecipeApplier.applyRecipeOn(level, stack, freezingFanRecipe)).orElse(null);
        }

        @Override
        public void spawnProcessingParticles(Level level, Vec3 pos) {
            if (level.random.nextInt(8) != 0)
                return;
            Vector3f color = new Color(0xDDE8FF).asVectorF();
            level.addParticle(new DustParticleOptions(color, 1), pos.x + (level.random.nextFloat() - .5f) * .5f,
                    pos.y + .5f, pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 8f, 0);
            level.addParticle(ParticleTypes.ITEM_SLIME, pos.x + (level.random.nextFloat() - .5f) * .5f, pos.y + .5f,
                    pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 8f, 0);
        }

        @Override
        public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
            particleAccess.setColor(Color.mixColors(0xEEEEFF, 0xDDE8FF, random.nextFloat()));
            particleAccess.setAlpha(1f);
            if (random.nextFloat() < 1 / 128f)
                particleAccess.spawnExtraParticle(ParticleTypes.ITEM_SLIME, .125f);
        }

        @Override
        public void affectEntity(Entity entity, Level level) {
            if (level.isClientSide) {
                return;
            }

            if (entity.isOnFire()) {
                entity.extinguishFire();
            }
        }
    }

    public static void register() {}
}
