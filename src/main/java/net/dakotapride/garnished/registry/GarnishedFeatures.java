package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class GarnishedFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, CreateGarnished.ID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, CreateGarnished.ID);


    public static final RegistryObject<ConfiguredFeature<?, ?>> NUT_TREE_CONFIGURED = CONFIGURED_FEATURES.register("nut_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new BendingTrunkPlacer(4, 2, 0, 3, UniformInt.of(1, 2)),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 5)
                                    .add(GarnishedBlocks.NUT_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));

    public static final RegistryObject<PlacedFeature> NUT_TREE_CHECKED = PLACED_FEATURES.register("nut_tree_checked",
            () -> new PlacedFeature(NUT_TREE_CONFIGURED.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(GarnishedBlocks.CASHEW_SAPLING.get()))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> TREE_SPAWN_CONDITIONS = CONFIGURED_FEATURES.register("spawn_conditions",
            () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(NUT_TREE_CHECKED.getHolder().get(), 0.5F)), NUT_TREE_CHECKED.getHolder().get())));

    public static final RegistryObject<PlacedFeature> NUT_TREE_PLACED = PLACED_FEATURES.register("nut_tree_placed",
            () -> new PlacedFeature(TREE_SPAWN_CONDITIONS.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BUHG_TREE_CONFIGURED = CONFIGURED_FEATURES.register("peanut_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new StraightTrunkPlacer(1, 1, 0),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.BUHG_LEAVES.get().defaultBlockState(), 1)),
                            new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 30),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> WALNUT_TREE_CONFIGURED = CONFIGURED_FEATURES.register("walnut_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new BendingTrunkPlacer(6, 3, 4, 4, ConstantInt.of(3)),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.WALNUT_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ALMOND_TREE_CONFIGURED = CONFIGURED_FEATURES.register("almond_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new ForkingTrunkPlacer(3, 1, 2),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.ALMOND_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> CASHEW_TREE_CONFIGURED = CONFIGURED_FEATURES.register("cashew_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new BendingTrunkPlacer(2, 1, 2, 2, ConstantInt.of(2)),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.CASHEW_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> HAZELNUT_TREE_CONFIGURED = CONFIGURED_FEATURES.register("hazelnut_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new ForkingTrunkPlacer(3, 2, 3),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.HAZELNUT_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MACADAMIA_TREE_CONFIGURED = CONFIGURED_FEATURES.register("macadamia_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new BendingTrunkPlacer(4, 2, 4, 4, ConstantInt.of(2)),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.MACADAMIA_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PECAN_TREE_CONFIGURED = CONFIGURED_FEATURES.register("pecan_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new ForkingTrunkPlacer(4, 2, 3),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.PECAN_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PISTACHIO_TREE_CONFIGURED = CONFIGURED_FEATURES.register("pistachio_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new BendingTrunkPlacer(3, 2, 3, 3, ConstantInt.of(2)),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.PISTACHIO_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));

    public static void setRegister(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
        PLACED_FEATURES.register(eventBus);
    }
}
