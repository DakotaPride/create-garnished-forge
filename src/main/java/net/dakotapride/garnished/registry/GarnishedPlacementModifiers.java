package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.placement.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.ApiStatus.Internal;

public class GarnishedPlacementModifiers {
	private static final DeferredRegister<PlacementModifierType<?>> REGISTER = DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, CreateGarnished.ID);

	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<GlobalGarnishedConfigPlacementFilter>> CONFIG_FILTER =
			REGISTER.register("config_filter", () -> () -> GlobalGarnishedConfigPlacementFilter.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<NutTreeConfigPlacementFilter>> NUT_TREE_CONFIG_FILTER =
			REGISTER.register("nut_tree_config_filter", () -> () -> NutTreeConfigPlacementFilter.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<RitualisticStoneConfigPlacementFilter>> RITUALISTIC_STONE_CONFIG_FILTER =
			REGISTER.register("ritualistic_stone_config_filter", () -> () -> RitualisticStoneConfigPlacementFilter.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<KelpVariantsConfigPlacementFilter>> KELP_VARIANTS_CONFIG_FILTER =
			REGISTER.register("kelp_variants_config_filter", () -> () -> KelpVariantsConfigPlacementFilter.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<VoltaicSeaGrassConfigPlacementFilter>> VOLTAIC_SEA_GRASS_CONFIG_FILTER =
			REGISTER.register("voltaic_sea_grass_config_filter", () -> () -> VoltaicSeaGrassConfigPlacementFilter.CODEC);

	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<SepiaFungusPlantConfigPlacementFilter>> SEPIA_FUNGUS_PLANT_CONFIG_FILTER =
			REGISTER.register("sepia_fungus_plant_config_filter", () -> () -> SepiaFungusPlantConfigPlacementFilter.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<SepiaFungusTreeConfigPlacementFilter>> SEPIA_FUNGUS_TREE_CONFIG_FILTER =
			REGISTER.register("sepia_fungus_tree_config_filter", () -> () -> SepiaFungusTreeConfigPlacementFilter.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<SoulRootsConfigPlacementFilter>> SOUL_ROOTS_CONFIG_FILTER =
			REGISTER.register("soul_roots_config_filter", () -> () -> SoulRootsConfigPlacementFilter.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<IncadescentLilyConfigPlacementFilter>> INCANDESCENT_LILY_CONFIG_FILTER =
			REGISTER.register("incandescent_lily_config_filter", () -> () -> IncadescentLilyConfigPlacementFilter.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<PansophicalDaisyConfigPlacementFilter>> PANSOPHICAL_DAISY_CONFIG_FILTER =
			REGISTER.register("pansophical_daisy_config_filter", () -> () -> PansophicalDaisyConfigPlacementFilter.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<SorrowfulLichenConfigPlacementFilter>> SORROWFUL_LICHEN_CONFIG_FILTER =
			REGISTER.register("sorrowful_lichen_config_filter", () -> () -> SorrowfulLichenConfigPlacementFilter.CODEC);

	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<AureateShrubConfigPlacementFilter>> AUREATE_SHRUB_CONFIG_FILTER =
			REGISTER.register("aureate_shrub_config_filter", () -> () -> AureateShrubConfigPlacementFilter.CODEC);
	public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<MiscEndVegetationConfigPlacementFilter>> MISC_END_VEGETATION_CONFIG_FILTER =
			REGISTER.register("misc_end_vegetation_config_filter", () -> () -> MiscEndVegetationConfigPlacementFilter.CODEC);

	@Internal
	public static void register(IEventBus modEventBus) {
		REGISTER.register(modEventBus);
	}
}
