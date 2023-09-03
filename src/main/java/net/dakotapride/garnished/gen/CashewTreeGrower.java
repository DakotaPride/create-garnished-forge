package net.dakotapride.garnished.gen;

import net.dakotapride.garnished.registry.GarnishedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import org.jetbrains.annotations.Nullable;

public class CashewTreeGrower extends AbstractTreeGrower {

	@Nullable
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean largeHive) {
		return GarnishedFeatures.CASHEW_TREE_CONFIGURED;
	}
}
