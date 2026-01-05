package net.dakotapride.garnished.mixin;

import com.soytutta.mynethersdelight.common.block.ResurgentSoilBlock;
import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(value = ResurgentSoilBlock.class, remap = false)
public abstract class ResurgentSoilBlockMixin extends Block {
    public ResurgentSoilBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "m_213898_", at = @At("HEAD"))
    private void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand, CallbackInfo ci) {
        if (!level.isClientSide && ModList.get().isLoaded("mynethersdelight")) {
            BlockPos abovePos = pos.above();
            BlockState aboveState = level.getBlockState(abovePos);
            Block aboveBlock = aboveState.getBlock();

            if (aboveBlock == GarnishedBlocks.SEPIA_FUNGUS.get()) {
                level.setBlockAndUpdate(pos.above(), GarnishedBlocks.SEPIA_FUNGUS_COLONY.get().defaultBlockState());
            }
        }
    }
}