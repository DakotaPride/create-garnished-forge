package net.dakotapride.creategarnished.entity.voltfish.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.entity.voltfish.VoltfishEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class VoltfishRenderer extends MobRenderer<VoltfishEntity, VoltfishModel<VoltfishEntity>> {
    public VoltfishRenderer(EntityRendererProvider.Context context) {
        super(context, new VoltfishModel<>(context.bakeLayer(VoltfishModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(VoltfishEntity voltfishEntity) {
        return CreateGarnished.asResource("textures/entity/voltfish.png");
    }

    @Override
    public void render(VoltfishEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isBaby())
            // unused
            poseStack.scale(0.5F, 0.5F, 0.5F);
        else poseStack.scale(1.0F, 1.0F, 1.0F);

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
