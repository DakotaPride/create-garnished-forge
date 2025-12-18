package net.dakotapride.creategarnished.mixin;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.registry.CreateGarnishedStatusEffects;
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

    @Unique
    private void heartResourceLocations(String id,
                                        GuiGraphics guiGraphics,
                                        boolean hardcore,
                                        boolean blinking,
                                        boolean halfHeart,
                                        int x,
                                        int y) {
        guiGraphics.blitSprite(getSprite(hardcore, blinking, halfHeart,
                CreateGarnished.asResource("hud/heart/"+id+"_half_blinking"), CreateGarnished.asResource("hud/heart/"+id+"_half"),
                CreateGarnished.asResource("hud/heart/"+id+"_full_blinking"), CreateGarnished.asResource("hud/heart/"+id+"_full"),
                CreateGarnished.asResource("hud/heart/"+id+"_hardcore_half_blinking"), CreateGarnished.asResource("hud/heart/"+id+"_hardcore_half"),
                CreateGarnished.asResource("hud/heart/"+id+"_hardcore_full_blinking"), CreateGarnished.asResource("hud/heart/"+id+"_hardcore_full")), x, y, 9, 9);
    }

    @Inject(method = "renderHeart", at = @At("HEAD"), cancellable = true)
    private void renderHeart(GuiGraphics guiGraphics, Gui.HeartType heartType, int x, int y, boolean hardcore, boolean halfHeart, boolean blinking, CallbackInfo ci) {
        if (heartType == Gui.HeartType.NORMAL && Minecraft.getInstance().cameraEntity instanceof Player player) {
            if (player.hasEffect(CreateGarnishedStatusEffects.VOLT_STRUCK)) {
                heartResourceLocations("volt", guiGraphics, hardcore, blinking, halfHeart, x, y);
                ci.cancel();
            }

            if (player.hasEffect(CreateGarnishedStatusEffects.NUT_ALLERGY)) {
                heartResourceLocations("nut_allergy", guiGraphics, hardcore, blinking, halfHeart, x, y);
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
