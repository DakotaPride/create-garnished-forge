package net.dakotapride.creategarnished.entity.bucketfish.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.entity.bucketfish.BucketFishEntity;
import net.dakotapride.creategarnished.entity.squirrel.client.SquirrelAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class BucketFishModel<T extends BucketFishEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(CreateGarnished.asResource("bucketfish"), "main");
	private final ModelPart full;
	private final ModelPart body;
	private final ModelPart outer;
	private final ModelPart legs;

	public BucketFishModel(ModelPart root) {
		this.full = root.getChild("full");
		this.body = this.full.getChild("body");
		this.outer = this.body.getChild("outer");
		this.legs = this.full.getChild("legs");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition full = partdefinition.addOrReplaceChild("full", CubeListBuilder.create(), PartPose.offset(0.0F, 18.5F, 0.0F));

		PartDefinition body = full.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition outer = body.addOrReplaceChild("outer", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs = full.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition cube_r1 = legs.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 13).addBox(-5.0F, -2.5F, 0.0F, 10.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r2 = legs.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 13).addBox(-5.0F, -2.5F, 0.0F, 10.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0F, -2.3562F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(BucketFishEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyBodyRotation(netHeadYaw, headPitch);

		this.animateWalk(BucketFishAnimations.ANIM_BUCKETFISH_SWIM, limbSwing, limbSwingAmount, 1.0F, 1.0F);
		this.animate(entity.idleAnimationState, BucketFishAnimations.ANIM_BUCKETFISH_IDLE, ageInTicks, 1.0F);
	}

	private void applyBodyRotation(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -30F, 30F);
		headPitch = Mth.clamp(headPitch, -25F, 45F);

		this.full.yRot = headYaw * ((float)Math.PI / 180F);
		this.full.xRot = headPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int colour) {
		full.render(poseStack, vertexConsumer, packedLight, packedOverlay, colour);
	}

	@Override
	public ModelPart root() {
		return full;
	}
}