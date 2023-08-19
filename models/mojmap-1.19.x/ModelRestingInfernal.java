// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelRestingInfernal<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "restinginfernal"), "main");
	private final ModelPart bone;

	public ModelRestingInfernal(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(),
				PartPose.offset(0.0F, 22.5F, 5.0F));

		PartDefinition Head = bone.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.0F, -1.0F, 0.9599F, 0.0F, 0.0F));

		PartDefinition head_r1 = Head.addOrReplaceChild("head_r1",
				CubeListBuilder.create().texOffs(25, 0).addBox(-2.0F, -3.0F, 2.0F, 4.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition Body = bone.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.0F, -1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition LeftLeg = bone.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(22, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, -1.4828F, -0.1304F, -0.0115F));

		PartDefinition RightLeg = bone.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(30, 28).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, -1.5265F, 0.1744F, 0.0077F));

		PartDefinition LeftArm = bone.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(24, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -9.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition LeftArm_r1 = LeftArm
				.addOrReplaceChild("LeftArm_r1",
						CubeListBuilder.create().texOffs(32, 6).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 7.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.5F, -2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition RightArm = bone.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition LeftArm_r2 = RightArm.addOrReplaceChild("LeftArm_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 7.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}