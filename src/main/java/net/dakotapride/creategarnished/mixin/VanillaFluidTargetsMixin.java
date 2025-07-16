package net.dakotapride.creategarnished.mixin;

import com.simibubi.create.AllFluids;
import com.simibubi.create.content.fluids.pipes.VanillaFluidTargets;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.block.BirchLogExtractingSapBlock;
import net.dakotapride.creategarnished.block.CreativeBirchLogExtractingSapBlock;
import net.dakotapride.creategarnished.registry.CreateGarnishedBlocks;
import net.dakotapride.creategarnished.registry.CreateGarnishedConfigs;
import net.dakotapride.creategarnished.registry.CreateGarnishedFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = VanillaFluidTargets.class, remap = false)
public class VanillaFluidTargetsMixin {

    @Inject(method = "canProvideFluidWithoutCapability", at = @At("HEAD"), cancellable = true, remap = false)
    private static void canProvideFluidWithoutCapability(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.hasProperty(BirchLogExtractingSapBlock.HAS_SAP))
            cir.setReturnValue(CreateGarnishedConfigs.server().block.allowSapFluidExtraction.get());
        if (state.getBlock() instanceof CreativeBirchLogExtractingSapBlock)
            cir.setReturnValue(CreateGarnishedConfigs.server().block.allowSapFluidExtraction.get());
    }

    @Inject(method = "drainBlock", at = @At("HEAD"), cancellable = true, remap = false)
    private static void drainBlock(Level level, BlockPos pos, BlockState state, boolean simulate, CallbackInfoReturnable<FluidStack> cir) {
        if (state.hasProperty(BirchLogExtractingSapBlock.HAS_SAP) && state.getValue(BirchLogExtractingSapBlock.HAS_SAP) && CreateGarnishedConfigs.server().block.allowSapFluidExtraction.get()) {
            if (!simulate)
                level.setBlock(pos, state.setValue(BirchLogExtractingSapBlock.HAS_SAP, false), 3);
            cir.setReturnValue(new FluidStack(CreateGarnishedFluids.BIRCH_SAP.get().getSource(), CreateGarnishedConfigs.server().block.sapFluidExtractionAmount.get()));
        }

        if (state.getBlock() instanceof CreativeBirchLogExtractingSapBlock && CreateGarnishedConfigs.server().block.allowSapFluidExtraction.get()) {
            cir.setReturnValue(new FluidStack(CreateGarnishedFluids.BIRCH_SAP.get().getSource(), CreateGarnishedConfigs.server().block.sapFluidExtractionAmount.get()));
        }
    }
}
