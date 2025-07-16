package net.dakotapride.creategarnished.mixin;

import com.simibubi.create.foundation.utility.BlockHelper;
import net.dakotapride.creategarnished.block.BirchLogExtractingSapBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BlockHelper.class, remap = false)
public class BlockHelperMixin {
    @Inject(method = "setZeroAge", at = @At("RETURN"), cancellable = true, remap = false)
    private static void setZeroAge(BlockState blockState, CallbackInfoReturnable<BlockState> cir) {
        if (blockState.hasProperty(BirchLogExtractingSapBlock.HAS_SAP))
            cir.setReturnValue(blockState.setValue(BirchLogExtractingSapBlock.HAS_SAP, false));
    }
}
