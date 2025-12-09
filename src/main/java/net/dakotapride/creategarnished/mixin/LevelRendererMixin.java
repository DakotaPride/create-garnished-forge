package net.dakotapride.creategarnished.mixin;

import net.dakotapride.creategarnished.entity.squirrel.SquirrelEntity;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = LevelRenderer.class, remap = false)
public class LevelRendererMixin {
    @Inject(method = "notifyNearbyEntities", at = @At("HEAD"))
    private void notify(Level level, BlockPos pos, boolean playing, CallbackInfo ci) {
        for (LivingEntity livingentity : level.getEntitiesOfClass(LivingEntity.class, new AABB(pos).inflate(16.0))) {
            if (livingentity instanceof SquirrelEntity)
                livingentity.setRecordPlayingNearby(pos, playing);
        }
    }
}
