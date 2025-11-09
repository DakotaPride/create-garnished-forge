package net.dakotapride.creategarnished.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.entity.VoltfishEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class VoltfishModel<T extends VoltfishEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(CreateGarnished.asResource("voltfish"), "main");
    private final ModelPart body;
    private final ModelPart head;

    public VoltfishModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -4.3502F, -4.1667F, 5.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.3502F, -2.8333F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 33).addBox(-2.5F, -2.25F, -5.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.8998F, -4.1667F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 34).addBox(-2.475F, 0.0F, -3.0F, 4.95F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.75F, 0.0F));

        PartDefinition fins = body.addOrReplaceChild("fins", CubeListBuilder.create(), PartPose.offset(0.0F, 0.4503F, 2.8333F));

        PartDefinition left = fins.addOrReplaceChild("left", CubeListBuilder.create(), PartPose.offset(2.5F, -2.3005F, -4.0F));

        PartDefinition cube_r1 = left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(26, 17).addBox(0.0F, -1.0F, -1.0F, 1.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition right = fins.addOrReplaceChild("right", CubeListBuilder.create(), PartPose.offset(-2.6288F, -2.3498F, -4.0F));

        PartDefinition cube_r2 = right.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1288F, 0.0493F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition back = fins.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 17).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5505F, 4.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(VoltfishEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        //this.animateWalk();
        if (!entity.isAggressive()) {
            this.animate(entity.idleAnimationState, VoltfishAnimations.ANIM_VOLTFISH_IDLE, ageInTicks, 1F);
        } else {
            this.animate(entity.idleAnimationState, VoltfishAnimations.ANIM_VOLTFISH_HASTEN, ageInTicks, 1F);
        }
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30F, 30F);
        headPitch = Mth.clamp(headPitch, -25F, 45F);

        this.head.yRot = headYaw * ((float)Math.PI / 180F);
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int colour) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, colour);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}