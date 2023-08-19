package net.mcreator.animechaos.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelDemonInfernalResting<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("anime_chaos", "model_demon_infernal_resting"), "main");
	public final ModelPart bone;

	public ModelDemonInfernalResting(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, 0.0F));
		PartDefinition head = bone.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 1.0F, 0.6981F, 0.0F, 0.0F));
		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 38).addBox(-1.5F, -4.5F, 0.0F, 3.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -8.5F, -4.1F, 0.0F, 0.0F, 0.0873F));
		PartDefinition head_r2 = head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(6, 38).addBox(-1.5F, -4.5F, 0.0F, 3.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, -8.5F, -4.1F, 0.0F, 0.0F, -0.0873F));
		PartDefinition horn1 = head.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -0.4224F, -1.3398F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, -8.5776F, -3.6602F, 0.7526F, -0.4891F, 0.0609F));
		PartDefinition head_r3 = horn1.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(42, 10).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0776F, 0.3398F, -0.6109F, 0.0F, 0.0F));
		PartDefinition horn2 = head.addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.4224F, -1.3398F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, -8.5776F, -3.6602F, 0.7526F, 0.4891F, -0.0609F));
		PartDefinition head_r4 = horn2.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(15, 28).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0776F, 0.3398F, -0.6109F, 0.0F, 0.0F));
		PartDefinition torso = bone.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(26, 24).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.25F, 2.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition torso_r1 = torso.addOrReplaceChild("torso_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-4.5F, -5.0F, -3.25F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.48F, 0.0F, 0.0F));
		PartDefinition left_arm = bone.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(16, 34).addBox(-1.0F, 3.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 28).addBox(-1.5F, -2.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.0F, -1.5F, 2.0F));
		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(32, 34).addBox(-2.5F, -6.5F, 0.0F, 5.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, -3.5F, -2.6F, 0.0F, 0.0F, 0.3054F));
		PartDefinition right_arm = bone.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 34).mirror().addBox(-3.0F, 3.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 28).mirror()
				.addBox(-3.5F, -2.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -1.5F, 2.0F));
		PartDefinition left_arm_r2 = right_arm.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(32, 34).mirror().addBox(-2.5F, -6.5F, 0.0F, 5.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.0F, -3.5F, -2.6F, 0.0F, 0.0F, -0.3054F));
		PartDefinition left_leg = bone.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(27, 11).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 8.0F, 2.0F, -1.4817F, -0.1278F, -0.0285F));
		PartDefinition left_leg_r1 = left_leg.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(32, 0).addBox(0.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 6.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition right_leg = bone.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(27, 11).mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.0F, 8.0F, 2.0F, -1.5253F, 0.1278F, 0.0285F));
		PartDefinition left_leg_r2 = right_leg.addOrReplaceChild("left_leg_r2", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-4.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(2.0F, 6.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
