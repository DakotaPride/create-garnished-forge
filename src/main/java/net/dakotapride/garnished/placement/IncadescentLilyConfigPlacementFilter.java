package net.dakotapride.garnished.placement;

import com.mojang.serialization.MapCodec;
import net.dakotapride.garnished.GarnishedConfigs;
import net.dakotapride.garnished.registry.GarnishedPlacementModifiers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class IncadescentLilyConfigPlacementFilter extends PlacementFilter {
	public static final IncadescentLilyConfigPlacementFilter INSTANCE = new IncadescentLilyConfigPlacementFilter();
	public static final MapCodec<IncadescentLilyConfigPlacementFilter> CODEC = MapCodec.unit(() -> INSTANCE);

	@Override
	protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
		return !GarnishedConfigs.common().worldgen.disableIncandescentLily.get();
	}

	@Override
	public PlacementModifierType<?> type() {
		return GarnishedPlacementModifiers.INCANDESCENT_LILY_CONFIG_FILTER.get();
	}
}
