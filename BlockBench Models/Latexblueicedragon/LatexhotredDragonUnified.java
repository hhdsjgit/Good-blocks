// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class LatexhotredDragonUnified<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "latexhotreddragonunified"), "main");
	private final ModelPart RightLeg;
	private final ModelPart RightLowerLeg;
	private final ModelPart RightFoot;
	private final ModelPart RightPad;
	private final ModelPart bone5;
	private final ModelPart LeftLeg;
	private final ModelPart LeftLowerLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftPad;
	private final ModelPart bone6;
	private final ModelPart Head;
	private final ModelPart Torso;
	private final ModelPart RightWing;
	private final ModelPart rightWingRoot;
	private final ModelPart rightSecondaries;
	private final ModelPart rightTertiaries;
	private final ModelPart LeftWing;
	private final ModelPart leftWingRoot;
	private final ModelPart leftSecondaries;
	private final ModelPart leftTertiaries;
	private final ModelPart Tail;
	private final ModelPart TailPrimary;
	private final ModelPart TailSecondary;
	private final ModelPart TailTertiary;
	private final ModelPart TailQuaternary;
	private final ModelPart hair;
	private final ModelPart RightArm;
	private final ModelPart bone3;
	private final ModelPart LeftArm;
	private final ModelPart bone4;

	public LatexhotredDragonUnified(ModelPart root) {
		this.RightLeg = root.getChild("RightLeg");
		this.RightLowerLeg = this.RightLeg.getChild("RightLowerLeg");
		this.RightFoot = this.RightLowerLeg.getChild("RightFoot");
		this.RightPad = this.RightFoot.getChild("RightPad");
		this.bone5 = this.RightPad.getChild("bone5");
		this.LeftLeg = root.getChild("LeftLeg");
		this.LeftLowerLeg = this.LeftLeg.getChild("LeftLowerLeg");
		this.LeftFoot = this.LeftLowerLeg.getChild("LeftFoot");
		this.LeftPad = this.LeftFoot.getChild("LeftPad");
		this.bone6 = this.LeftPad.getChild("bone6");
		this.Head = root.getChild("Head");
		this.Torso = root.getChild("Torso");
		this.RightWing = this.Torso.getChild("RightWing");
		this.rightWingRoot = this.RightWing.getChild("rightWingRoot");
		this.rightSecondaries = this.rightWingRoot.getChild("rightSecondaries");
		this.rightTertiaries = this.rightSecondaries.getChild("rightTertiaries");
		this.LeftWing = this.Torso.getChild("LeftWing");
		this.leftWingRoot = this.LeftWing.getChild("leftWingRoot");
		this.leftSecondaries = this.leftWingRoot.getChild("leftSecondaries");
		this.leftTertiaries = this.leftSecondaries.getChild("leftTertiaries");
		this.Tail = this.Torso.getChild("Tail");
		this.TailPrimary = this.Tail.getChild("TailPrimary");
		this.TailSecondary = this.TailPrimary.getChild("TailSecondary");
		this.TailTertiary = this.TailSecondary.getChild("TailTertiary");
		this.TailQuaternary = this.TailTertiary.getChild("TailQuaternary");
		this.hair = this.Torso.getChild("hair");
		this.RightArm = root.getChild("RightArm");
		this.bone3 = this.RightArm.getChild("bone3");
		this.LeftArm = root.getChild("LeftArm");
		this.bone4 = this.LeftArm.getChild("bone4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-2.5F, 10.5F, 0.0F));

		PartDefinition cube_r1 = RightLeg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(34, 69).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 5.5F, -1.2F, -0.3491F, 0.0F, -0.3054F));

		PartDefinition RightThigh_r1 = RightLeg.addOrReplaceChild("RightThigh_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition RightLowerLeg = RightLeg.addOrReplaceChild("RightLowerLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 6.375F, -3.45F));

		PartDefinition RightCalf_r1 = RightLowerLeg.addOrReplaceChild("RightCalf_r1", CubeListBuilder.create().texOffs(32, 16).addBox(-1.99F, -0.125F, -2.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.125F, 1.95F, 0.8727F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLowerLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.8F, 7.175F));

		PartDefinition RightArch_r1 = RightFoot.addOrReplaceChild("RightArch_r1", CubeListBuilder.create().texOffs(32, 35).addBox(-2.0F, -8.45F, -0.725F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(0.0F, 7.075F, -4.975F, -0.3491F, 0.0F, 0.0F));

		PartDefinition RightPad = RightFoot.addOrReplaceChild("RightPad", CubeListBuilder.create().texOffs(46, 44).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.325F, -4.425F));

		PartDefinition bone5 = RightPad.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(20, 88).addBox(12.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(8, 88).addBox(9.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(12, 88).addBox(10.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(16, 88).addBox(11.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(0, 87).addBox(10.0F, 9.1F, -0.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -8.0F, -0.55F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(2.5F, 10.5F, 0.0F));

		PartDefinition cube_r2 = LeftLeg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(28, 69).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 5.5F, -1.2F, -0.3491F, 0.0F, 0.3054F));

		PartDefinition LeftThigh_r1 = LeftLeg.addOrReplaceChild("LeftThigh_r1", CubeListBuilder.create().texOffs(16, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LeftLowerLeg = LeftLeg.addOrReplaceChild("LeftLowerLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 6.375F, -3.45F));

		PartDefinition LeftCalf_r1 = LeftLowerLeg.addOrReplaceChild("LeftCalf_r1", CubeListBuilder.create().texOffs(46, 34).addBox(-2.01F, -0.125F, -2.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.125F, 1.95F, 0.8727F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLowerLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.8F, 7.175F));

		PartDefinition LeftArch_r1 = LeftFoot.addOrReplaceChild("LeftArch_r1", CubeListBuilder.create().texOffs(32, 26).addBox(-2.0F, -8.45F, -0.725F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(0.0F, 7.075F, -4.975F, -0.3491F, 0.0F, 0.0F));

		PartDefinition LeftPad = LeftFoot.addOrReplaceChild("LeftPad", CubeListBuilder.create().texOffs(48, 51).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.325F, -4.425F));

		PartDefinition bone6 = LeftPad.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(20, 85).addBox(12.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(8, 85).addBox(9.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(12, 85).addBox(10.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(16, 85).addBox(11.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(0, 84).addBox(10.0F, 9.1F, -0.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -8.0F, -0.55F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(41, 51).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 14).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 62).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 61).addBox(-5.5F, -1.0F, -1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -7.5F, -2.4F, 0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(31, 63).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -2.25F, -1.4F, 0.1309F, 0.1745F, 0.3927F));

		PartDefinition cube_r5 = Head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(11, 75).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.25F, -1.4F, 0.1309F, -0.1745F, -0.3927F));

		PartDefinition cube_r6 = Head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 71).mirror().addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.35F, -6.2F, 0.35F, -0.9163F, 0.3491F, 0.0F));

		PartDefinition cube_r7 = Head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(10, 73).mirror().addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.35F, -5.85F, 0.35F, -0.9163F, 0.3491F, 0.0F));

		PartDefinition cube_r8 = Head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(10, 64).addBox(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.35F, -5.85F, 0.35F, -0.9163F, -0.3491F, 0.0F));

		PartDefinition cube_r9 = Head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 62).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.35F, -6.2F, 0.35F, -0.9163F, -0.3491F, 0.0F));

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition RightWing = Torso.addOrReplaceChild("RightWing", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 5.0F, 2.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition rightWingRoot = RightWing.addOrReplaceChild("rightWingRoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r10 = rightWingRoot.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(54, 58).addBox(-25.975F, -4.475F, 1.65F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.0F, 1.2654F));

		PartDefinition cube_r11 = rightWingRoot.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(32, 44).addBox(-25.075F, -12.7F, 1.2F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r12 = rightWingRoot.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(21, 53).addBox(-12.775F, -19.75F, 1.2F, 5.0F, 2.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition rightSecondaries = rightWingRoot.addOrReplaceChild("rightSecondaries", CubeListBuilder.create().texOffs(0, 43).addBox(-0.2F, -0.475F, -0.3F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-7.3F, -7.0F, -0.5F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r13 = rightSecondaries.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(24, 43).addBox(1.025F, -22.55F, 1.2F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, 27.0F, -1.5F, 0.0F, 0.0F, -0.48F));

		PartDefinition cube_r14 = rightSecondaries.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 57).addBox(-22.4F, 10.625F, 1.651F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, 27.0F, -1.5F, 0.0F, 0.0F, 1.8326F));

		PartDefinition cube_r15 = rightSecondaries.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(56, 0).addBox(-24.525F, -13.85F, 1.648F, 9.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, 27.0F, -1.5F, 0.0F, 0.0F, 0.7418F));

		PartDefinition rightTertiaries = rightSecondaries.addOrReplaceChild("rightTertiaries", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition cube_r16 = rightTertiaries.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(4, 43).addBox(2.3F, -22.5F, 1.2F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 27.0F, -1.5F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r17 = rightTertiaries.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(48, 16).addBox(-10.15F, -26.2F, 1.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.5F, 21.0F, -1.5F, 0.0F, 0.0F, 1.0908F));

		PartDefinition cube_r18 = rightTertiaries.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(28, 43).addBox(-10.15F, -26.2F, 1.2F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(9.0F, 27.0F, -1.5F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_r19 = rightTertiaries.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(18, 56).addBox(-25.125F, -10.525F, 1.64F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 27.0F, -1.5F, 0.0F, 0.0F, 0.8727F));

		PartDefinition LeftWing = Torso.addOrReplaceChild("LeftWing", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 5.0F, 2.0F, 0.0F, -0.48F, 0.0F));

		PartDefinition leftWingRoot = LeftWing.addOrReplaceChild("leftWingRoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r20 = leftWingRoot.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(62, 39).addBox(18.975F, -4.475F, 1.65F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, 0.0F, -1.2654F));

		PartDefinition cube_r21 = leftWingRoot.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(32, 47).addBox(19.075F, -12.7F, 1.2F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r22 = leftWingRoot.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(21, 50).addBox(7.775F, -19.75F, 1.2F, 5.0F, 2.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition leftSecondaries = leftWingRoot.addOrReplaceChild("leftSecondaries", CubeListBuilder.create().texOffs(12, 43).addBox(-0.8F, -0.475F, -0.3F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(7.3F, -7.0F, -0.5F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r23 = leftSecondaries.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(16, 43).addBox(-2.025F, -22.55F, 1.2F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, 27.0F, -1.5F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r24 = leftSecondaries.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 51).addBox(15.525F, -13.85F, 1.648F, 9.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, 27.0F, -1.5F, 0.0F, 0.0F, -0.7418F));

		PartDefinition cube_r25 = leftSecondaries.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(62, 34).addBox(13.4F, 10.625F, 1.651F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, 27.0F, -1.5F, 0.0F, 0.0F, -1.8326F));

		PartDefinition leftTertiaries = leftSecondaries.addOrReplaceChild("leftTertiaries", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9599F));

		PartDefinition cube_r26 = leftTertiaries.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(8, 43).addBox(-3.3F, -22.5F, 1.2F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 27.0F, -1.5F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r27 = leftTertiaries.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(36, 58).addBox(16.125F, -10.525F, 1.64F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 27.0F, -1.5F, 0.0F, 0.0F, -0.8727F));

		PartDefinition cube_r28 = leftTertiaries.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(44, 16).addBox(9.15F, -26.2F, 1.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.5F, 21.0F, -1.5F, 0.0F, 0.0F, -1.0908F));

		PartDefinition cube_r29 = leftTertiaries.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(20, 43).addBox(9.15F, -26.2F, 1.2F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(-9.0F, 27.0F, -1.5F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Tail = Torso.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition TailPrimary = Tail.addOrReplaceChild("TailPrimary", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Base_r1 = TailPrimary.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(56, 6).addBox(-2.0F, -2.9F, 0.4F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition TailSecondary = TailPrimary.addOrReplaceChild("TailSecondary", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 3.5F));

		PartDefinition Base_r2 = TailSecondary.addOrReplaceChild("Base_r2", CubeListBuilder.create().texOffs(48, 16).addBox(-1.5F, -1.4F, -2.7F, 3.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 1.0F, 2.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition TailTertiary = TailSecondary.addOrReplaceChild("TailTertiary", CubeListBuilder.create(), PartPose.offset(0.0F, 2.5F, 5.0F));

		PartDefinition Base_r3 = TailTertiary.addOrReplaceChild("Base_r3", CubeListBuilder.create().texOffs(46, 25).addBox(-1.5F, -13.225F, 6.6F, 3.0F, 3.0F, 6.0F, new CubeDeformation(-0.32F)), PartPose.offsetAndRotation(0.0F, 10.5F, -8.5F, -0.1309F, 0.0F, 0.0F));

		PartDefinition TailQuaternary = TailTertiary.addOrReplaceChild("TailQuaternary", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5F, 4.5F));

		PartDefinition Base_r4 = TailQuaternary.addOrReplaceChild("Base_r4", CubeListBuilder.create().texOffs(61, 47).addBox(-1.0F, -10.45F, 13.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 10.0F, -13.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition hair = Torso.addOrReplaceChild("hair", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r30 = hair.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(40, 65).addBox(-6.0F, 0.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 1.5929F, -1.2929F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r31 = hair.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(40, 63).addBox(-6.0F, 0.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.7929F, -1.2929F, -0.7854F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 80).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.08F)), PartPose.offset(-5.0F, 1.5F, 0.0F));

		PartDefinition cube_r32 = RightArm.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(22, 68).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.65F, -1.65F, 0.7F, -0.1309F, 0.0F, -2.8362F));

		PartDefinition cube_r33 = RightArm.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(90, 0).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.167F, -0.6431F, 0.5F, -3.1416F, 1.2566F, 2.6616F));

		PartDefinition cube_r34 = RightArm.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(90, 4).addBox(-0.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.367F, -0.6431F, 0.8F, 0.0F, 0.2793F, -0.48F));

		PartDefinition bone3 = RightArm.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(20, 94).addBox(12.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(8, 94).addBox(9.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(12, 94).addBox(10.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(16, 94).addBox(11.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(0, 93).addBox(10.0F, 9.1F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 0.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(24, 80).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.08F)).mirror(false)
		.texOffs(16, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 1.5F, 0.0F));

		PartDefinition cube_r35 = LeftArm.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(16, 67).mirror().addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.65F, -1.65F, 0.7F, -0.1309F, 0.0F, 2.8362F));

		PartDefinition cube_r36 = LeftArm.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(90, 12).mirror().addBox(-2.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.367F, -0.6431F, 0.8F, 0.0F, -0.2793F, 0.48F));

		PartDefinition cube_r37 = LeftArm.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(90, 8).mirror().addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.167F, -0.6431F, 0.5F, -3.1416F, -1.2566F, -2.6616F));

		PartDefinition bone4 = LeftArm.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(20, 91).addBox(2.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(8, 91).addBox(-1.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(12, 91).addBox(0.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(16, 91).addBox(1.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(0, 90).addBox(0.0F, 9.1F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 96, 96);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}