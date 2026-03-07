package net.dakotapride.garnished.placement;

import com.mojang.serialization.MapCodec;
import net.dakotapride.garnished.GarnishedConfigs;
import net.dakotapride.garnished.registry.GarnishedPlacementModifiers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class SoulRootsConfigPlacementFilter extends PlacementFilter {
	public static final SoulRootsConfigPlacementFilter INSTANCE = new SoulRootsConfigPlacementFilter();
	public static final MapCodec<SoulRootsConfigPlacementFilter> CODEC = MapCodec.unit(() -> INSTANCE);

	@Override
	protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
		return !GarnishedConfigs.common().worldgen.disableSoulRoots.get();
	}

	@Override
	public PlacementModifierType<?> type() {
		return GarnishedPlacementModifiers.SOUL_ROOTS_CONFIG_FILTER.get();
	}
}
