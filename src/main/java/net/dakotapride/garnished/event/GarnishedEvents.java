package net.dakotapride.garnished.event;

import com.simibubi.create.foundation.fluid.FluidHelper;
import com.simibubi.create.foundation.utility.Iterate;
import net.dakotapride.garnished.registry.GarnishedFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
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
}
