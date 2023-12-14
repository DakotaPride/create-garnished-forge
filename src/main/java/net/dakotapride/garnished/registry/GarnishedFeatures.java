package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.List;

public class GarnishedFeatures {

    // public static final ResourceKey<ConfiguredFeature<?, ?>> NUT_TREE_CONFIGURED = configuredResource("nut_tree_configured");
    // public static final ResourceKey<PlacedFeature> NUT_TREE_PLACED = placedResource("nut_tree_placed");

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, CreateGarnished.ID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, CreateGarnished.ID);


    public static final RegistryObject<ConfiguredFeature<?, ?>> NUT_TREE_CONFIGURED = CONFIGURED_FEATURES.register("nut_tree_configured",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(GarnishedBlocks.NUT_LOG.get()),
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUHG_TREE_CONFIGURED = configuredResource("peanut_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT_TREE_CONFIGURED = configuredResource("walnut_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALMOND_TREE_CONFIGURED = configuredResource("almond_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CASHEW_TREE_CONFIGURED = configuredResource("cashew_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HAZELNUT_TREE_CONFIGURED = configuredResource("hazelnut_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MACADAMIA_TREE_CONFIGURED = configuredResource("macadamia_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PECAN_TREE_CONFIGURED = configuredResource("pecan_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PISTACHIO_TREE_CONFIGURED = configuredResource("pistachio_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHESTNUT_TREE_CONFIGURED = configuredResource("chestnut_tree_configured");

    // public static final ResourceKey<ConfiguredFeature<?, ?>> SEPIA_FUNGUS_CONFIGURED = configuredResource("patch_sepia_fungus_configured");
    public static final RegistryObject<ConfiguredFeature<?, ?>> SEPIA_FUNGUS_CONFIGURED = CONFIGURED_FEATURES.register("patch_sepia_fungus_configured",
            () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(GarnishedBlocks.SEPIA_FUNGUS.get())))));
    // public static final ResourceKey<PlacedFeature> SEPIA_FUNGUS_PLACED = placedResource("patch_sepia_fungus_placed");
    public static final RegistryObject<PlacedFeature> SEPIA_FUNGUS_PLACED = PLACED_FEATURES.register("patch_sepia_fungus_placed",
            () -> new PlacedFeature(SEPIA_FUNGUS_CONFIGURED.getHolder().get(), List.of(PlacementUtils.FULL_RANGE, BiomeFilter.biome())));
    // public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_ROOTS_CONFIGURED = configuredResource("patch_soul_roots_configured");
    public static final RegistryObject<ConfiguredFeature<?, ?>> SOUL_ROOTS_CONFIGURED = CONFIGURED_FEATURES.register("patch_soul_roots_configured",
            () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(GarnishedBlocks.SOUL_ROOTS.get())))));
    // public static final ResourceKey<PlacedFeature> SOUL_ROOTS_PLACED = placedResource("patch_soul_roots_placed");
    public static final RegistryObject<PlacedFeature> SOUL_ROOTS_PLACED = PLACED_FEATURES.register("patch_soul_roots_placed",
            () -> new PlacedFeature(SOUL_ROOTS_CONFIGURED.getHolder().get(), List.of(PlacementUtils.FULL_RANGE, BiomeFilter.biome())));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEPIA_FUNGUS_TREE_CONFIGURED = configuredResource("sepia_fungus_tree_configured");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_SAND_VEGETATION_BONEMEAL_CONFIGURED = configuredResource("soul_sand_vegetation_bonemeal");

    // public static final ResourceKey<ConfiguredFeature<?, ?>> BARREN_ROOTS_CONFIGURED = configuredResource("patch_barren_roots_configured");
    public static final RegistryObject<ConfiguredFeature<?, ?>> BARREN_ROOTS_CONFIGURED = CONFIGURED_FEATURES.register("patch_barren_roots_configured",
            () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simpleRandomPatchConfiguration(16, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(GarnishedBlocks.BARREN_ROOTS.get().defaultBlockState(), 8)
                            .add(GarnishedBlocks.SMALL_CHORUS_PLANT.get().defaultBlockState(), 1)))))));
    public static final RegistryObject<PlacedFeature> BARREN_ROOTS_PLACED = PLACED_FEATURES.register("patch_barren_roots_placed",
            () -> new PlacedFeature(BARREN_ROOTS_CONFIGURED.getHolder().get(),
                    List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    // public static final ResourceKey<ConfiguredFeature<?, ?>> CHORUS_PLANT_CONFIGURED = configuredResource("patch_chorus_plant_configured");
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHORUS_PLANT_CONFIGURED = CONFIGURED_FEATURES.register("patch_chorus_plant_configured",
            () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simpleRandomPatchConfiguration(16, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(GarnishedBlocks.BARREN_ROOTS.get().defaultBlockState(), 4)
                            .add(GarnishedBlocks.SMALL_CHORUS_PLANT.get().defaultBlockState(), 3)))))));
    public static final RegistryObject<PlacedFeature> CHORUS_PLANT_PLACED = PLACED_FEATURES.register("patch_chorus_plant_placed",
            () -> new PlacedFeature(CHORUS_PLANT_CONFIGURED.getHolder().get(),
                    List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final ResourceKey<ConfiguredFeature<?, ?>> END_STONE_VEGETATION_BONEMEAL_CONFIGURED = configuredResource("end_stone_vegetation_bonemeal");


    public static ResourceKey<ConfiguredFeature<?, ?>> configuredResource(String name) {
        return ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(CreateGarnished.ID, name));
    }

    public static ResourceKey<PlacedFeature> placedResource(String name) {
        return ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(CreateGarnished.ID, name));
    }

    public static void setRegister(IEventBus bus) {
        CONFIGURED_FEATURES.register(bus);
        PLACED_FEATURES.register(bus);
    }
}
