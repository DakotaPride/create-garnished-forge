package net.dakotapride.creategarnished.entity.gingerbread_man.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.entity.gingerbread_man.GingerManiacEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class GingerManiacModel<T extends GingerManiacEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(CreateGarnished.asResource("gingermaniac"), "main");
    private final ModelPart main;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart body2;
    private final ModelPart legs;
    private final ModelPart right;
    private final ModelPart left;
    private final ModelPart arms;
    private final ModelPart right2;
    private final ModelPart left2;

    public GingerManiacModel(ModelPart root) {
        this.main = root.getChild("main");
        this.head = this.main.getChild("head");
        this.body = this.main.getChild("body");
        this.body2 = this.body.getChild("body2");
        this.legs = this.body.getChild("legs");
        this.right = this.legs.getChild("right");
        this.left = this.legs.getChild("left");
        this.arms = this.body.getChild("arms");
        this.right2 = this.arms.getChild("right2");
        this.left2 = this.arms.getChild("left2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -0.5F));

        PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -4.5F, -0.5F));

        PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -3.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 1.5F, 0.0F));

        PartDefinition right = legs.addOrReplaceChild("right", CubeListBuilder.create().texOffs(6, 5).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.0F, 0.0F));

        PartDefinition left = legs.addOrReplaceChild("left", CubeListBuilder.create().texOffs(6, 5).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, 0.0F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition right2 = arms.addOrReplaceChild("right2", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

        PartDefinition left2 = arms.addOrReplaceChild("left2", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(GingerManiacEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animate(entity.idleAnimationState, GingerManiacAnimations.ANIM_GINGERMANIAC_IDLE, ageInTicks, 1F);
        this.animateWalk(GingerManiacAnimations.ANIM_GINGERMANIAC_WALK, limbSwing, limbSwingAmount, 1.0F, 1.0F);

    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30F, 30F);
        headPitch = Mth.clamp(headPitch, -25F, 45F);

        this.head.yRot = headYaw * ((float)Math.PI / 180F);
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int colour) {
        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, colour);
    }

    @Override
    public ModelPart root() {
        return main;
    }
}