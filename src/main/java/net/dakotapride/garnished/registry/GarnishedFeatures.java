package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
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
                            new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 50),
                            new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).forceDirt().build()));

    public static final RegistryObject<PlacedFeature> NUT_TREE_PLACED = PLACED_FEATURES.register("nut_tree_placed",
            () -> new PlacedFeature(NUT_TREE_CONFIGURED.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(8),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static void setRegister(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
        PLACED_FEATURES.register(eventBus);
    }
}
