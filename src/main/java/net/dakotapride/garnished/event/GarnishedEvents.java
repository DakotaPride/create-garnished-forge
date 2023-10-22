package net.dakotapride.garnished.event;

import com.simibubi.create.foundation.fluid.FluidHelper;
import com.simibubi.create.foundation.utility.Iterate;
import net.dakotapride.garnished.registry.GarnishedFeatures;
import net.dakotapride.garnished.registry.GarnishedFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class GarnishedEvents {

    @SubscribeEvent
    public static void whenFluidsMeet(BlockEvent.FluidPlaceBlockEvent event) {
        BlockState blockState = event.getOriginalState();
        FluidState fluidState = blockState.getFluidState();
        BlockPos pos = event.getPos();
        LevelAccessor world = event.getWorld();

        if (fluidState.isSource() && FluidHelper.isLava(fluidState.getType()))
            return;

        for (Direction direction : Iterate.directions) {
            FluidState metFluidState =
                    fluidState.isSource() ? fluidState : world.getFluidState(pos.relative(direction));
            if (!metFluidState.is(FluidTags.WATER))
                continue;
            BlockState lavaInteraction = GarnishedFluids.getLavaInteraction(metFluidState);
            if (lavaInteraction == null)
                continue;
            event.setNewState(lavaInteraction);
            break;
        }
    }

    @SubscribeEvent
    public static void featurePlacement(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        ResourceLocation name = event.getName();

        if (name != null) {
            if (name.equals(Biomes.PLAINS.location())) {
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GarnishedFeatures.NUT_TREE_PLACED.getHolder().orElseThrow());
            }

            if (name.equals(Biomes.SOUL_SAND_VALLEY.location())) {
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GarnishedFeatures.SEPIA_FUNGUS_PLACED.getHolder().orElseThrow());
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GarnishedFeatures.SOUL_ROOTS_PLACED.getHolder().orElseThrow());
            }

            if (name.equals(Biomes.END_BARRENS.location()) || name.equals(Biomes.END_HIGHLANDS.location()) || name.equals(Biomes.END_MIDLANDS.location())) {
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GarnishedFeatures.BARREN_ROOTS_PLACED.getHolder().orElseThrow());
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GarnishedFeatures.CHORUS_PLANT_PLACED.getHolder().orElseThrow());
            }
        }
    }
}
