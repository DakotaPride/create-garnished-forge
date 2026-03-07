package net.dakotapride.garnished.placement;

import com.mojang.serialization.MapCodec;
import net.dakotapride.garnished.GarnishedConfigs;
import net.dakotapride.garnished.registry.GarnishedPlacementModifiers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class SorrowfulLichenConfigPlacementFilter extends PlacementFilter {
	public static final SorrowfulLichenConfigPlacementFilter INSTANCE = new SorrowfulLichenConfigPlacementFilter();
	public static final MapCodec<SorrowfulLichenConfigPlacementFilter> CODEC = MapCodec.unit(() -> INSTANCE);

	@Override
	protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
		return !GarnishedConfigs.common().worldgen.disableSorrowfulLichen.get();
	}

	@Override
	public PlacementModifierType<?> type() {
		return GarnishedPlacementModifiers.SORROWFUL_LICHEN_CONFIG_FILTER.get();
	}
}
