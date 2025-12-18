package net.dakotapride.creategarnished.mixin;

import net.dakotapride.creategarnished.registry.CreateGarnishedStatusEffects;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = LivingEntity.class, remap = false)
public class LivingEntityMixin {
    @Unique
    LivingEntity entity = (LivingEntity) (Object) this;
    @Inject(method = "stopRiding", at = @At("HEAD"), cancellable = true)
    private void stopRiding(CallbackInfo ci) {
        if (entity.hasEffect(CreateGarnishedStatusEffects.STICKY)) {
            ci.cancel();
        }
    }
}
