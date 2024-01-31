package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.gen.feature.DulseKelpFeature;
import net.dakotapride.garnished.gen.feature.VermilionKelpFeature;
import net.dakotapride.garnished.gen.feature.VoltaicSeagrassFeature;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
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
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class GarnishedFeatures {
    private static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, CreateGarnished.ID);

    public static final ResourceKey<ConfiguredFeature<?, ?>> NUT_TREE_CONFIGURED = registerConfiguredKey("nut_tree_configured");
    public static final ResourceKey<PlacedFeature> NUT_TREE_PLACED = registerPlacedKey("nut_tree_placed");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUHG_TREE_CONFIGURED = registerConfiguredKey("peanut_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT_TREE_CONFIGURED = registerConfiguredKey("walnut_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALMOND_TREE_CONFIGURED = registerConfiguredKey("almond_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CASHEW_TREE_CONFIGURED = registerConfiguredKey("cashew_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HAZELNUT_TREE_CONFIGURED = registerConfiguredKey("hazelnut_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MACADAMIA_TREE_CONFIGURED = registerConfiguredKey("macadamia_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PECAN_TREE_CONFIGURED = registerConfiguredKey("pecan_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PISTACHIO_TREE_CONFIGURED = registerConfiguredKey("pistachio_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHESTNUT_TREE_CONFIGURED = registerConfiguredKey("chestnut_tree_configured");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SEPIA_FUNGUS_CONFIGURED = registerConfiguredKey("patch_sepia_fungus_configured");
    public static final ResourceKey<PlacedFeature> SEPIA_FUNGUS_PLACED = registerPlacedKey("patch_sepia_fungus_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEPIA_FUNGUS_TREE_CONFIGURED = registerConfiguredKey("sepia_fungus_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_ROOTS_CONFIGURED = registerConfiguredKey("patch_soul_roots_configured");
    public static final ResourceKey<PlacedFeature> SOUL_ROOTS_PLACED = registerPlacedKey("patch_soul_roots_placed");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_SAND_VEGETATION_BONEMEAL_CONFIGURED = registerConfiguredKey("soul_sand_vegetation_bonemeal");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BARREN_ROOTS_CONFIGURED = registerConfiguredKey("patch_barren_roots_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHORUS_PLANT_CONFIGURED = registerConfiguredKey("patch_chorus_plant_configured");

    public static final ResourceKey<ConfiguredFeature<?, ?>> END_STONE_VEGETATION_BONEMEAL_CONFIGURED = registerConfiguredKey("end_stone_vegetation_bonemeal");

    public static final RegistryObject<VermilionKelpFeature> VERMILION_KELP_FEATURE = REGISTER.register("vermilion_kelp", () -> new VermilionKelpFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<DulseKelpFeature> DULSE_KELP_FEATURE = REGISTER.register("dulse_kelp", () -> new DulseKelpFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<VoltaicSeagrassFeature> VOLTAIC_SEAGRASS_FEATURE = REGISTER.register("voltaic_seagrass", () -> new VoltaicSeagrassFeature(ProbabilityFeatureConfiguration.CODEC));

    public static final ResourceKey<ConfiguredFeature<?, ?>> VERMILION_KELP = registerConfiguredKey("vermilion_kelp_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DULSE_KELP = registerConfiguredKey("dulse_kelp_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VOLTAIC_SEAGRASS = registerConfiguredKey("voltaic_seagrass_configured");

    public static final ResourceKey<PlacedFeature> REMNANT_PLACED = registerPlacedKey("ores_overworld");

    public static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredKey(String name) {
        return ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(CreateGarnished.ID, name));
    }

    public static ResourceKey<PlacedFeature> registerPlacedKey(String name) {
        return ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(CreateGarnished.ID, name));
    }

    public static void setRegister(IEventBus bus) {
        REGISTER.register(bus);
    }
}
