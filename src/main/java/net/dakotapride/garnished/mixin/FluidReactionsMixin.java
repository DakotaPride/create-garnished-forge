package net.dakotapride.garnished.mixin;

import com.simibubi.create.api.event.PipeCollisionEvent;
import com.simibubi.create.content.fluids.FluidReactions;
import com.simibubi.create.foundation.fluid.FluidHelper;
import net.dakotapride.garnished.registry.GarnishedFluids;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = FluidReactions.class, remap = false)
public class FluidReactionsMixin {

    @Inject(method = "handlePipeFlowCollisionFallback", at = @At("HEAD"))
    private static void handlePipeFlowCollisionFallback(PipeCollisionEvent.Flow event, CallbackInfo ci) {
        Fluid f1 = event.getFirstFluid();
        Fluid f2 = event.getSecondFluid();

        if (f1 == Fluids.LAVA && FluidHelper.hasBlockState(f2)) {
            BlockState lavaInteraction = GarnishedFluids.getLavaInteraction(FluidHelper.convertToFlowing(f2).defaultFluidState());
            if (lavaInteraction != null) {
                event.setState(lavaInteraction);
            }
        } else if (f2 == Fluids.LAVA && FluidHelper.hasBlockState(f1)) {
            BlockState lavaInteraction = GarnishedFluids.getLavaInteraction(FluidHelper.convertToFlowing(f1).defaultFluidState());
            if (lavaInteraction != null) {
                event.setState(lavaInteraction);
            }
        }
    }

    @Inject(method = "handlePipeSpillCollisionFallback", at = @At("HEAD"))
    private static void handlePipeSpillCollisionFallback(PipeCollisionEvent.Spill event, CallbackInfo ci) {
        Fluid pf = event.getPipeFluid();
        Fluid wf = event.getWorldFluid();

        if (FluidHelper.isTag(pf, FluidTags.WATER) && wf == Fluids.LAVA) {
            event.setState(Blocks.OBSIDIAN.defaultBlockState());
        }

        if (pf == Fluids.LAVA) {
            BlockState lavaInteraction = GarnishedFluids.getLavaInteraction(wf.defaultFluidState());
            if (lavaInteraction != null) {
                event.setState(lavaInteraction);
            }
        } else if (wf == Fluids.FLOWING_LAVA && FluidHelper.hasBlockState(pf)) {
            BlockState lavaInteraction = GarnishedFluids.getLavaInteraction(FluidHelper.convertToFlowing(pf).defaultFluidState());
            if (lavaInteraction != null) {
                event.setState(lavaInteraction);
            }
        }
    }

}
