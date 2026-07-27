package net.dakotapride.creategarnished.entity.bucketfish.client;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.entity.bucketfish.BucketFishEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class BucketfishRenderer extends MobRenderer<BucketFishEntity, BucketFishModel<BucketFishEntity>> {
    public BucketfishRenderer(EntityRendererProvider.Context context) {
        super(context, new BucketFishModel<>(context.bakeLayer(BucketFishModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    protected @Nullable RenderType getRenderType(BucketFishEntity livingEntity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return super.getRenderType(livingEntity, bodyVisible, true, glowing);
    }

    @Override
    public ResourceLocation getTextureLocation(BucketFishEntity bucketfish) {
        return CreateGarnished.asResource("textures/entity/bucketfish/" + bucketfish.getVariant().getName() + ".png");
    }
}
