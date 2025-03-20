// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelNoNameMob<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "modelnonamemob"), "main");
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart Head;
	private final ModelPart Torso;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;

	public ModelNoNameMob(ModelPart root) {
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.Head = root.getChild("Head");
		this.Torso = root.getChild("Torso");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(),
				PartPose.offset(-2.5F, 10.5F, 0.0F));

		PartDefinition RightThigh_r1 = RightLeg
				.addOrReplaceChild("RightThigh_r1",
						CubeListBuilder.create().texOffs(32, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition RightLowerLeg = RightLeg.addOrReplaceChild("RightLowerLeg", CubeListBuilder.create(),
				PartPose.offset(0.0F, 6.375F, -3.45F));

		PartDefinition RightCalf_r1 = RightLowerLeg.addOrReplaceChild("RightCalf_r1",
				CubeListBuilder.create().texOffs(48, 47).addBox(-1.99F, -0.125F, -2.9F, 4.0F, 6.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.125F, 1.95F, 0.8727F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLowerLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.8F, 7.175F));

		PartDefinition RightArch_r1 = RightFoot.addOrReplaceChild("RightArch_r1",
				CubeListBuilder.create().texOffs(0, 59).addBox(-2.0F, -8.45F, -0.725F, 4.0F, 6.0F, 3.0F,
						new CubeDeformation(0.005F)),
				PartPose.offsetAndRotation(0.0F, 7.075F, -4.975F, -0.3491F, 0.0F, 0.0F));

		PartDefinition RightPad = RightFoot.addOrReplaceChild("RightPad", CubeListBuilder.create().texOffs(48, 9)
				.addBox(-2.0F, 0.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 4.325F, -4.425F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(),
				PartPose.offset(2.5F, 10.5F, 0.0F));

		PartDefinition LeftThigh_r1 = LeftLeg
				.addOrReplaceChild("LeftThigh_r1",
						CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LeftLowerLeg = LeftLeg.addOrReplaceChild("LeftLowerLeg", CubeListBuilder.create(),
				PartPose.offset(0.0F, 6.375F, -3.45F));

		PartDefinition LeftCalf_r1 = LeftLowerLeg.addOrReplaceChild("LeftCalf_r1",
				CubeListBuilder.create().texOffs(48, 22).addBox(-2.01F, -0.125F, -2.9F, 4.0F, 6.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.125F, 1.95F, 0.8727F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLowerLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.8F, 7.175F));

		PartDefinition LeftArch_r1 = LeftFoot.addOrReplaceChild("LeftArch_r1",
				CubeListBuilder.create().texOffs(14, 61).addBox(-2.0F, -8.45F, -0.725F, 4.0F, 6.0F, 3.0F,
						new CubeDeformation(0.005F)),
				PartPose.offsetAndRotation(0.0F, 7.075F, -4.975F, -0.3491F, 0.0F, 0.0F));

		PartDefinition LeftPad = LeftFoot.addOrReplaceChild("LeftPad", CubeListBuilder.create().texOffs(24, 0)
				.addBox(-2.0F, 0.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 4.325F, -4.425F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 16)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(64, 53)
						.addBox(-1.5F, -1.0F, -6.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition Base_r1 = Head.addOrReplaceChild("Base_r1",
				CubeListBuilder.create().texOffs(56, 65).addBox(-1.9F, 0.15F, -0.3F, 2.0F, 3.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.5F, -5.0F, 0.0F, -1.2217F, 0.4712F, 0.6981F));

		PartDefinition Base_r2 = Head.addOrReplaceChild("Base_r2",
				CubeListBuilder.create().texOffs(0, 16).addBox(-1.4F, 0.25F, 2.3F, 2.0F, 3.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.5F, -5.0F, 0.0F, -1.4312F, 0.6458F, 0.5847F));

		PartDefinition Base_r3 = Head.addOrReplaceChild("Base_r3",
				CubeListBuilder.create().texOffs(64, 65).addBox(-0.1F, 0.15F, -0.3F, 2.0F, 3.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.5F, -5.0F, 0.0F, -1.2217F, -0.4712F, -0.6981F));

		PartDefinition Base_r4 = Head.addOrReplaceChild("Base_r4",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.6F, 0.25F, 2.3F, 2.0F, 3.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.5F, -5.0F, 0.0F, -1.4312F, -0.6458F, -0.5847F));

		PartDefinition Hair = Head.addOrReplaceChild("Hair",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)).texOffs(24, 8)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TopHorn = Head.addOrReplaceChild("TopHorn", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, -4.0F, 2.3F, 0.6109F, 0.0F, 0.0F));

		PartDefinition TopHorn_r1 = TopHorn.addOrReplaceChild("TopHorn_r1",
				CubeListBuilder.create().texOffs(48, 62).addBox(-1.0F, -1.0F, -2.2F, 2.0F, 2.0F, 3.0F,
						new CubeDeformation(0.15F)),
				PartPose.offsetAndRotation(0.0F, -4.5F, 0.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.5F, -8.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition Base_r5 = RightEar.addOrReplaceChild("Base_r5",
				CubeListBuilder.create().texOffs(24, 0).addBox(-0.6F, -1.5F, -3.0F, 1.0F, 3.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, -0.2094F, -0.056F, 0.0059F));

		PartDefinition Base_r6 = RightEar.addOrReplaceChild("Base_r6",
				CubeListBuilder.create().texOffs(38, 62).addBox(-2.0F, -4.75F, -1.0F, 2.0F, 7.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, -0.2182F, 0.0785F));

		PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.5F, -8.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Base_r7 = LeftEar.addOrReplaceChild("Base_r7",
				CubeListBuilder.create().texOffs(0, 32).addBox(-0.4F, -1.5F, -3.0F, 1.0F, 3.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.2094F, 0.056F, -0.0059F));

		PartDefinition Base_r8 = LeftEar.addOrReplaceChild("Base_r8",
				CubeListBuilder.create().texOffs(28, 61).addBox(0.0F, -4.75F, -1.0F, 2.0F, 7.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.2182F, -0.0785F));

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(28, 28)
				.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition Tail = Torso.addOrReplaceChild("Tail", CubeListBuilder.create(),
				PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition TailPrimary = Tail.addOrReplaceChild("TailPrimary", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Base_r9 = TailPrimary.addOrReplaceChild("Base_r9",
				CubeListBuilder.create().texOffs(55, 56).addBox(-2.0F, -2.9F, 0.4F, 4.0F, 4.0F, 5.0F,
						new CubeDeformation(-0.8F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition TailSecondary = TailPrimary.addOrReplaceChild("TailSecondary", CubeListBuilder.create(),
				PartPose.offset(0.0F, 1.0F, 3.5F));

		PartDefinition Base_r10 = TailSecondary.addOrReplaceChild("Base_r10",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.5F, -1.4F, -2.7F, 3.0F, 3.0F, 6.0F,
						new CubeDeformation(-0.15F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, 2.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition TailTertiary = TailSecondary.addOrReplaceChild("TailTertiary", CubeListBuilder.create(),
				PartPose.offset(0.0F, 2.5F, 5.0F));

		PartDefinition Base_r11 = TailTertiary.addOrReplaceChild("Base_r11",
				CubeListBuilder.create().texOffs(46, 38).addBox(-1.5F, -13.225F, 6.6F, 3.0F, 3.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.5F, -8.5F, -0.1309F, 0.0F, 0.0F));

		PartDefinition TailQuaternary = TailTertiary.addOrReplaceChild("TailQuaternary", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.5F, 4.5F));

		PartDefinition Base_r12 = TailQuaternary.addOrReplaceChild("Base_r12",
				CubeListBuilder.create().texOffs(16, 32).addBox(-1.0F, -10.45F, 13.5F, 2.0F, 2.0F, 4.0F,
						new CubeDeformation(0.6F)),
				PartPose.offsetAndRotation(0.0F, 10.0F, -13.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition TailQuaternary2 = TailQuaternary.addOrReplaceChild("TailQuaternary2", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Base_r13 = TailQuaternary2.addOrReplaceChild("Base_r13",
				CubeListBuilder.create().texOffs(14, 30).addBox(-1.0F, -10.7F, 17.5F, 2.0F, 2.0F, 6.0F,
						new CubeDeformation(0.8F)),
				PartPose.offsetAndRotation(0.0F, 11.0F, -11.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition LeftWing = Torso.addOrReplaceChild("LeftWing", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.0F, 5.0F, 2.0F, 0.0F, -0.48F, 0.0F));

		PartDefinition leftWingRoot = LeftWing.addOrReplaceChild("leftWingRoot", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = leftWingRoot.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(37, 0).addBox(18.975F, -4.475F, 1.65F, 7.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, 0.0F, -1.2654F));

		PartDefinition cube_r2 = leftWingRoot.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(60, 47).addBox(19.075F, -12.7F, 1.2F, 6.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r3 = leftWingRoot.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(64, 43).addBox(7.775F, -19.75F, 1.2F, 5.0F, 2.0F, 1.0F,
						new CubeDeformation(-0.01F)),
				PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition leftSecondaries = leftWingRoot.addOrReplaceChild("leftSecondaries",
				CubeListBuilder.create().texOffs(52, 67).addBox(-0.8F, -0.475F, -0.3F, 1.0F, 7.0F, 1.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(7.3F, -7.0F, -0.5F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r4 = leftSecondaries
				.addOrReplaceChild("cube_r4",
						CubeListBuilder.create().texOffs(12, 70).addBox(-2.025F, -22.55F, 1.2F, 1.0F, 6.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-9.3F, 27.0F, -1.5F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r5 = leftSecondaries.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(60, 0).addBox(15.525F, -13.85F, 1.648F, 9.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.3F, 27.0F, -1.5F, 0.0F, 0.0F, -0.7418F));

		PartDefinition cube_r6 = leftSecondaries.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(36, 57).addBox(13.4F, 10.625F, 1.651F, 9.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.3F, 27.0F, -1.5F, 0.0F, 0.0F, -1.8326F));

		PartDefinition leftTertiaries = leftSecondaries.addOrReplaceChild("leftTertiaries", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-0.3F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9599F));

		PartDefinition cube_r7 = leftTertiaries.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(48, 67).addBox(-3.3F, -22.5F, 1.2F, 1.0F, 7.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.0F, 27.0F, -1.5F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r8 = leftTertiaries.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(56, 16).addBox(16.125F, -10.525F, 1.64F, 9.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.0F, 27.0F, -1.5F, 0.0F, 0.0F, -0.8727F));

		PartDefinition cube_r9 = leftTertiaries.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(8, 68).addBox(9.15F, -26.2F, 1.2F, 1.0F, 6.0F, 1.0F,
						new CubeDeformation(0.005F)),
				PartPose.offsetAndRotation(-9.0F, 27.0F, -1.5F, 0.0F, 0.0F, -0.0436F));

		PartDefinition RightWing = Torso.addOrReplaceChild("RightWing", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.0F, 5.0F, 2.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition rightWingRoot = RightWing.addOrReplaceChild("rightWingRoot", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r10 = rightWingRoot.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(60, 21).addBox(-25.975F, -4.475F, 1.65F, 7.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.0F, 1.2654F));

		PartDefinition cube_r11 = rightWingRoot.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(32, 24).addBox(-25.075F, -12.7F, 1.2F, 6.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r12 = rightWingRoot.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(64, 50).addBox(-12.775F, -19.75F, 1.2F, 5.0F, 2.0F, 1.0F,
						new CubeDeformation(-0.01F)),
				PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition rightSecondaries = rightWingRoot.addOrReplaceChild("rightSecondaries",
				CubeListBuilder.create().texOffs(0, 68).addBox(-0.2F, -0.475F, -0.3F, 1.0F, 7.0F, 1.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(-7.3F, -7.0F, -0.5F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r13 = rightSecondaries
				.addOrReplaceChild("cube_r13",
						CubeListBuilder.create().texOffs(20, 70).addBox(1.025F, -22.55F, 1.2F, 1.0F, 6.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(9.3F, 27.0F, -1.5F, 0.0F, 0.0F, -0.48F));

		PartDefinition cube_r14 = rightSecondaries.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(17, 56).addBox(-22.4F, 10.625F, 1.651F, 9.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.3F, 27.0F, -1.5F, 0.0F, 0.0F, 1.8326F));

		PartDefinition cube_r15 = rightSecondaries.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(58, 37).addBox(-24.525F, -13.85F, 1.648F, 9.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.3F, 27.0F, -1.5F, 0.0F, 0.0F, 0.7418F));

		PartDefinition rightTertiaries = rightSecondaries.addOrReplaceChild("rightTertiaries", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition cube_r16 = rightTertiaries.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(4, 68).addBox(2.3F, -22.5F, 1.2F, 1.0F, 7.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.0F, 27.0F, -1.5F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r17 = rightTertiaries.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(16, 70).addBox(-10.15F, -26.2F, 1.2F, 1.0F, 6.0F, 1.0F,
						new CubeDeformation(0.005F)),
				PartPose.offsetAndRotation(9.0F, 27.0F, -1.5F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_r18 = rightTertiaries.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(52, 32).addBox(-25.125F, -10.525F, 1.64F, 9.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.0F, 27.0F, -1.5F, 0.0F, 0.0F, 0.8727F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 32)
				.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 1.5F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(16, 40)
				.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 1.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 96, 96);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}