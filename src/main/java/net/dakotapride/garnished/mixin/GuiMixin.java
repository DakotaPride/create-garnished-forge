package net.dakotapride.garnished.mixin;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.registry.GarnishedEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@OnlyIn(Dist.CLIENT)
@Mixin(value = Gui.class, remap = false)
public class GuiMixin {

    @Inject(method = "renderHeart", at = @At("HEAD"), cancellable = true)
    private void renderHeart(GuiGraphics guiGraphics, Gui.HeartType heartType, int x, int y, boolean hardcore, boolean halfHeart, boolean blinking, CallbackInfo ci) {
        if (heartType == Gui.HeartType.NORMAL && Minecraft.getInstance().cameraEntity instanceof Player player) {
            if (player.hasEffect(GarnishedEffects.AVERSION)) {
                guiGraphics.blitSprite(getSprite(hardcore, blinking, halfHeart,
                        CreateGarnished.asResource("hud/heart/aversion_half_blinking"), CreateGarnished.asResource("hud/heart/aversion_half"),
                        CreateGarnished.asResource("hud/heart/aversion_full_blinking"), CreateGarnished.asResource("hud/heart/aversion_full"),
                        CreateGarnished.asResource("hud/heart/aversion_hardcore_half_blinking"), CreateGarnished.asResource("hud/heart/aversion_hardcore_half"),
                        CreateGarnished.asResource("hud/heart/aversion_hardcore_full_blinking"), CreateGarnished.asResource("hud/heart/aversion_hardcore_full")), x, y, 9, 9);
                ci.cancel();
            }
        }
    }

    @Unique
    public ResourceLocation getSprite(boolean hardcore, boolean halfHeart, boolean blinking,
                                      ResourceLocation halfBlinking, ResourceLocation half,
                                      ResourceLocation fullBlinking, ResourceLocation full,
                                      ResourceLocation hardcoreHalfBlinking, ResourceLocation hardcoreHalf,
                                      ResourceLocation hardcoreFullBlinking, ResourceLocation hardcoreFull) {
        if (!hardcore) {
            if (halfHeart) {
                return blinking ? halfBlinking : half;
            } else {
                return blinking ? fullBlinking : full;
            }
        } else if (halfHeart) {
            return blinking ? hardcoreHalfBlinking : hardcoreHalf;
        } else {
            return blinking ? hardcoreFullBlinking : hardcoreFull;
        }
    }

}
