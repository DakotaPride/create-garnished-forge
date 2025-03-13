package net.dakotapride.creategarnished.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class CreateGarnishedTreeGrower {
//    public static final TreeGrower PINE_NUT = new TreeGrower("pine_nut", 0.5F,
//            Optional.of(CreateGarnishedFeatureKeys.PINE_NUT), Optional.of(CreateGarnishedFeatureKeys.PINE_NUT),
//            Optional.of(CreateGarnishedFeatureKeys.PINE_NUT), Optional.empty(), Optional.empty(), Optional.empty());
//    public static final TreeGrower HAZELNUT = new TreeGrower("hazelnut", 0.5F,
//            Optional.of(CreateGarnishedFeatureKeys.HAZELNUT), Optional.of(CreateGarnishedFeatureKeys.HAZELNUT),
//            Optional.of(CreateGarnishedFeatureKeys.HAZELNUT), Optional.empty(), Optional.empty(), Optional.empty());
//    public static final TreeGrower ALMOND = new TreeGrower("almond", 0.5F,
//            Optional.of(CreateGarnishedFeatureKeys.ALMOND), Optional.of(CreateGarnishedFeatureKeys.ALMOND),
//            Optional.of(CreateGarnishedFeatureKeys.ALMOND), Optional.empty(), Optional.empty(), Optional.empty());

    public static class PineNut extends AbstractTreeGrower {
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
            return CreateGarnishedFeatureKeys.PINE_NUT;
        }
    }
    public static class Hazelnut extends AbstractTreeGrower {
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
            return CreateGarnishedFeatureKeys.HAZELNUT;
        }
    }
    public static class Almond extends AbstractTreeGrower {
        @Nullable
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
            return CreateGarnishedFeatureKeys.ALMOND;
        }
    }

}