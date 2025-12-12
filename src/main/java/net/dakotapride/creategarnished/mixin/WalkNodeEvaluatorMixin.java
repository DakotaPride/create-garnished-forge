package net.dakotapride.creategarnished.mixin;

import net.dakotapride.creategarnished.registry.CreateGarnishedBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = WalkNodeEvaluator.class, remap = false)
public class WalkNodeEvaluatorMixin {
    @Inject(method = "getPathTypeFromState", at = @At("HEAD"), cancellable = true)
    private static void getPathTypeFromState(BlockGetter level, BlockPos pos, CallbackInfoReturnable<PathType> cir) {
        BlockState blockstate = level.getBlockState(pos);
        if (blockstate.is(CreateGarnishedBlocks.ELVEN_SWEET_BERRY_BUSH)) {
            cir.setReturnValue(PathType.DAMAGE_OTHER);
        }
    }
}
