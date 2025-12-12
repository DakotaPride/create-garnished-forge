package net.dakotapride.garnished.mixin;

import net.dakotapride.garnished.registry.GarnishedEffects;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Player.class, remap = false)
public abstract class PlayerMixin {
    @Unique
    Player player = (Player) (Object) this;
    @Shadow public abstract Inventory getInventory();

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        if (this.getInventory().contains(GarnishedTags.DUNE_CURSE)) {
            player.addEffect(new MobEffectInstance(GarnishedEffects.MUMMIFICATION, 400, 4, false, true, false));
        }
    }
}
