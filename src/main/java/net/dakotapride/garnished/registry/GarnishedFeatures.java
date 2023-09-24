package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
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
                            new StraightTrunkPlacer(4, 2, 0),
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
                            new StraightTrunkPlacer(4, 2, 0),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.BUHG_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> WALNUT_TREE_CONFIGURED = CONFIGURED_FEATURES.register("walnut_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new StraightTrunkPlacer(4, 2, 0),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.WALNUT_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ALMOND_TREE_CONFIGURED = CONFIGURED_FEATURES.register("almond_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new StraightTrunkPlacer(4, 2, 0),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.ALMOND_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> CASHEW_TREE_CONFIGURED = CONFIGURED_FEATURES.register("cashew_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new StraightTrunkPlacer(4, 2, 0),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.CASHEW_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> HAZELNUT_TREE_CONFIGURED = CONFIGURED_FEATURES.register("hazelnut_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new StraightTrunkPlacer(4, 2, 0),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.HAZELNUT_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MACADAMIA_TREE_CONFIGURED = CONFIGURED_FEATURES.register("macadamia_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new StraightTrunkPlacer(4, 2, 0),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.MACADAMIA_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PECAN_TREE_CONFIGURED = CONFIGURED_FEATURES.register("pecan_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new StraightTrunkPlacer(4, 2, 0),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.PECAN_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PISTACHIO_TREE_CONFIGURED = CONFIGURED_FEATURES.register("pistachio_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
                            new StraightTrunkPlacer(4, 2, 0),
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3)
                                    .add(GarnishedBlocks.PISTACHIO_LEAVES.get().defaultBlockState(), 1)),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_SEPIA_FUNGUS_CONFIGURED =
            CONFIGURED_FEATURES.register("patch_sepia_fungus_configured", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH,
                    FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(GarnishedBlocks.SEPIA_FUNGUS.get())))));
    public static final RegistryObject<ConfiguredFeature<HugeFungusConfiguration, ?>> SEPIA_FUNGUS_TREE_CONFIGURED =
            CONFIGURED_FEATURES.register("sepia_fungus_tree_configured", () -> new ConfiguredFeature<>(Feature.HUGE_FUNGUS, new HugeFungusConfiguration(Blocks.SOUL_SOIL.defaultBlockState(),
                    GarnishedBlocks.SEPIA_STEM.getDefaultState(), GarnishedBlocks.SEPIA_WART_BLOCK.getDefaultState(),
                    Blocks.SHROOMLIGHT.defaultBlockState(), false)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_SOUL_ROOTS_CONFIGURED =
            CONFIGURED_FEATURES.register("patch_soul_roots_configured", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH,
                    FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(GarnishedBlocks.SOUL_ROOTS.get())))));

    public static Holder<PlacedFeature> PATCH_SEPIA_FUNGUS_PLACED;
    public static Holder<PlacedFeature> PATCH_SOUL_ROOTS_PLACED;


    public static void setRegister(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);

        PATCH_SEPIA_FUNGUS_PLACED = PlacementUtils.register(CreateGarnished.ID + ":patch_sepia_fungus_placed",
                PATCH_SEPIA_FUNGUS_CONFIGURED.getHolder().get(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
        PATCH_SOUL_ROOTS_PLACED = PlacementUtils.register(CreateGarnished.ID + ":patch_soul_roots_placed",
                PATCH_SOUL_ROOTS_CONFIGURED.getHolder().get(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());

        PLACED_FEATURES.register(eventBus);
    }
}
