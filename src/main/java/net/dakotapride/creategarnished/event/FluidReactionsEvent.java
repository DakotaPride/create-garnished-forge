package net.dakotapride.creategarnished.event;

import com.simibubi.create.api.event.PipeCollisionEvent;
import com.simibubi.create.foundation.fluid.FluidHelper;
import net.dakotapride.creategarnished.registry.CreateGarnishedFluids;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class FluidReactionsEvent {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void handlePipeFlowCollisionFallback(PipeCollisionEvent.Flow event) {
        Fluid f1 = event.getFirstFluid();
        Fluid f2 = event.getSecondFluid();

        if (f1 == Fluids.WATER && f2 == Fluids.LAVA || f2 == Fluids.WATER && f1 == Fluids.LAVA) {
            event.setState(Blocks.COBBLESTONE.defaultBlockState());
        } else if (f1 == Fluids.WATER && FluidHelper.hasBlockState(f2)) {
            BlockState lavaInteraction = CreateGarnishedFluids.getFluidInteraction(FluidHelper.convertToFlowing(f2).defaultFluidState());
            if (lavaInteraction != null) {
                event.setState(lavaInteraction);
            }
        } else if (f2 == Fluids.WATER && FluidHelper.hasBlockState(f1)) {
            BlockState lavaInteraction = CreateGarnishedFluids.getFluidInteraction(FluidHelper.convertToFlowing(f1).defaultFluidState());
            if (lavaInteraction != null) {
                event.setState(lavaInteraction);
            }
        }
    }

}
