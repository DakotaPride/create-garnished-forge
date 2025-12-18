package net.dakotapride.creategarnished.entity.gingerbread_man.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.entity.gingerbread_man.GingerManiacEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GingerManiacRenderer extends MobRenderer<GingerManiacEntity, GingerManiacModel<GingerManiacEntity>> {
    public GingerManiacRenderer(EntityRendererProvider.Context context) {
        super(context, new GingerManiacModel<>(context.bakeLayer(GingerManiacModel.LAYER_LOCATION)), 0.15F);
    }

    @Override
    public ResourceLocation getTextureLocation(GingerManiacEntity gingerbreadMan) {
        return CreateGarnished.asResource("textures/entity/gingerbread_man.png");
    }

    @Override
    public void render(GingerManiacEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isBaby())
            // unused
            poseStack.scale(0.5F, 0.5F, 0.5F);
        else poseStack.scale(1.0F, 1.0F, 1.0F);

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
