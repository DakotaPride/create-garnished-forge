package net.dakotapride.creategarnished.entity.squirrel.client;

// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.entity.squirrel.SquirrelEntity;
import net.minecraft.client.animation.definitions.CamelAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.ParrotModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.animal.Parrot;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class SquirrelModel<T extends SquirrelEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(CreateGarnished.asResource("squirrel"), "main");
    public final ModelPart main;
    public final ModelPart head;
    public final ModelPart ears;
    public final ModelPart body;
    public final ModelPart body2;
    public final ModelPart arms;
    public final ModelPart right;
    public final ModelPart left;
    public final ModelPart legs;
    public final ModelPart left2;
    public final ModelPart foot;
    public final ModelPart right2;
    public final ModelPart foot2;
    public final ModelPart tail;

    public SquirrelModel(ModelPart root) {
        this.main = root.getChild("main");
        this.head = this.main.getChild("head");
        this.ears = this.head.getChild("ears");
        this.body = this.main.getChild("body");
        this.body2 = this.body.getChild("body2");
        this.arms = this.body.getChild("arms");
        this.right = this.arms.getChild("right");
        this.left = this.arms.getChild("left");
        this.legs = this.body.getChild("legs");
        this.left2 = this.legs.getChild("left2");
        this.foot = this.left2.getChild("foot");
        this.right2 = this.legs.getChild("right2");
        this.foot2 = this.right2.getChild("foot2");
        this.tail = this.body.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(-0.5313F, 22.0F, 0.5781F));

        PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 13).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).addBox(-0.5F, 0.25F, -1.975F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0313F, -0.5F, -2.5781F));

        PartDefinition ears = head.addOrReplaceChild("ears", CubeListBuilder.create().texOffs(8, 19).addBox(0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(10, 19).addBox(-1.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -0.5F));

        PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(-0.0313F, 0.75F, 2.5781F));

        PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(2, 2).addBox(-1.4375F, -1.75F, -5.1563F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0625F, -0.25F, -5.0313F));

        PartDefinition right = arms.addOrReplaceChild("right", CubeListBuilder.create().texOffs(4, 20).addBox(-0.25F, 0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.0F, 0.375F, -0.1309F, 0.0F, 0.0F));

        PartDefinition left = arms.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 20).addBox(-0.75F, 0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.0F, 0.375F, -0.1309F, 0.0F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0625F, -0.75F, -1.2813F));

        PartDefinition left2 = legs.addOrReplaceChild("left2", CubeListBuilder.create().texOffs(6, 15).addBox(-0.5F, -0.975F, -1.025F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, 0.125F, 0.1309F, 0.0F, 0.0F));

        PartDefinition foot = left2.addOrReplaceChild("foot", CubeListBuilder.create().texOffs(12, 17).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.5F, -0.1309F, 0.0F, 0.0F));

        PartDefinition right2 = legs.addOrReplaceChild("right2", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, -0.975F, -1.025F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0F, 0.125F, 0.1309F, 0.0F, 0.0F));

        PartDefinition foot2 = right2.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(18, 17).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.5F, -0.1309F, 0.0F, 0.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, -2.25F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0625F, -1.25F, -0.1563F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(SquirrelEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(SquirrelAnimations.ANIM_SQUIRREL_WALK, limbSwing, limbSwingAmount, 2.0F, 2.5F);
        this.animate(entity.idleAnimationState, SquirrelAnimations.ANIM_SQUIRREL_IDLE, ageInTicks, 1.0F);
        this.animate(entity.sittingAnimationState, SquirrelAnimations.ANIM_SQUIRREL_SITTING, ageInTicks, 1.0F);
        this.animate(entity.dancingAnimationState, SquirrelAnimations.ANIM_SQUIRREL_DANCING, ageInTicks, 2.0F);
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
