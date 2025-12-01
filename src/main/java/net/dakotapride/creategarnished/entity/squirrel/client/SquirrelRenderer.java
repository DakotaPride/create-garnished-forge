package net.dakotapride.creategarnished.entity.squirrel.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.entity.squirrel.SquirrelEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class SquirrelRenderer extends MobRenderer<SquirrelEntity, SquirrelModel<SquirrelEntity>> {
    public SquirrelRenderer(EntityRendererProvider.Context context) {
        super(context, new SquirrelModel<>(context.bakeLayer(SquirrelModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(SquirrelEntity squirrelEntity) {
        String name = ChatFormatting.stripFormatting(squirrelEntity.getName().getString());
        List<String> peppermintTypeNames = List.of("Peppermint", "Pepper", "Mint");
        for (String peppermintTypeName : peppermintTypeNames) {
            if (peppermintTypeName.equalsIgnoreCase(name))
                return CreateGarnished.asResource("textures/entity/squirrel/peppermint.png");
        }
        if ("Quirrel".equalsIgnoreCase(name))
            return CreateGarnished.asResource("textures/entity/squirrel/quirrel.png");
        return CreateGarnished.asResource("textures/entity/squirrel/" + squirrelEntity.getVariant().getName() + ".png");
    }

    @Override
    public void render(SquirrelEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isBaby())
            poseStack.scale(0.65F, 0.65F, 0.65F);
        else poseStack.scale(1.0F, 1.0F, 1.0F);

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
