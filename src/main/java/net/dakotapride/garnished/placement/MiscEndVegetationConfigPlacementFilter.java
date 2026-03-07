package net.dakotapride.garnished.placement;

import com.mojang.serialization.MapCodec;
import net.dakotapride.garnished.GarnishedConfigs;
import net.dakotapride.garnished.registry.GarnishedPlacementModifiers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class MiscEndVegetationConfigPlacementFilter extends PlacementFilter {
	public static final MiscEndVegetationConfigPlacementFilter INSTANCE = new MiscEndVegetationConfigPlacementFilter();
	public static final MapCodec<MiscEndVegetationConfigPlacementFilter> CODEC = MapCodec.unit(() -> INSTANCE);

	@Override
	protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
		return !GarnishedConfigs.common().worldgen.disableMiscEndVegetation.get();
	}

	@Override
	public PlacementModifierType<?> type() {
		return GarnishedPlacementModifiers.MISC_END_VEGETATION_CONFIG_FILTER.get();
	}
}
