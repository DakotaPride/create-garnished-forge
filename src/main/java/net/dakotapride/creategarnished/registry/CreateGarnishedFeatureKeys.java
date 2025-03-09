package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CreateGarnishedFeatureKeys {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_NUT = createKey("pine_nut_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HAZELNUT = createKey("hazelnut_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAP_FILLED_BIRCH = createKey("sap_filled_birch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALMOND = createKey("almond_tree");


    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, CreateGarnished.asResource(pName));
    }
}
