package net.hhdsj.goodblock.client.model.renderer.animate.bipedal;

import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.client.renderer.animate.bipedal.AbstractBipedalAnimator;
import net.ltxprogrammer.changed.client.renderer.model.AdvancedHumanoidModel;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class DragontaurBipedalCreativeFlyAnimator<T extends ChangedEntity, M extends AdvancedHumanoidModel<T>> extends AbstractBipedalAnimator<T, M> {
    public static final float LEG_SWAY_RATE = 0.3331F;
    public static final float LEG_SWAY_AMOUNT = 0.35F;
    public final ModelPart leftLegLower;
    public final ModelPart leftFoot;
    public final ModelPart leftPad;
    public final ModelPart rightLegLower;
    public final ModelPart rightFoot;
    public final ModelPart rightPad;
    public final ModelPart frontLeftLeg;
    public final ModelPart frontLeftLegLower;
    public final ModelPart frontLeftFoot;
    public final ModelPart frontRightLeg;
    public final ModelPart frontRightLegLower;
    public final ModelPart frontRightFoot;

    public DragontaurBipedalCreativeFlyAnimator(ModelPart frontLeftLeg, ModelPart frontLeftLegLower, ModelPart frontLeftFoot,
                                                ModelPart frontRightLeg, ModelPart frontRightLegLower, ModelPart frontRightFoot, ModelPart backLeftLeg,
                                                ModelPart backLeftLegLower, ModelPart backLeftFoot, ModelPart backLeftPad, ModelPart backRightLeg,
                                                ModelPart backRightLegLower, ModelPart backRightFoot, ModelPart backRightPad) {
        super(backLeftLeg, backRightLeg);
        //后腿
        this.leftLegLower = backLeftLegLower;
        this.leftFoot = backLeftFoot;
        this.leftPad = backLeftPad;
        this.rightLegLower = backRightLegLower;
        this.rightFoot = backRightFoot;
        this.rightPad = backRightPad;
        //前腿
        this.frontLeftLeg = frontLeftLeg;
        this.frontLeftLegLower = frontLeftLegLower;
        this.frontLeftFoot = frontLeftFoot;
        this.frontRightLeg = frontRightLeg;
        this.frontRightLegLower = frontRightLegLower;
        this.frontRightFoot = frontRightFoot;
    }

    public HumanoidAnimator.AnimateStage preferredStage() {
        return HumanoidAnimator.AnimateStage.CREATIVE_FLY;
    }

    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float flapAmount = Mth.cos(ageInTicks * 0.2F);
        flapAmount = Mth.map(flapAmount * flapAmount, 0.0F, 1.0F, -0.5F, 0.5F);
        ModelPart var10000 = this.leftLeg;
        var10000.y += Mth.lerp(this.core.flyAmount, 0.0F, flapAmount - 4.0F);
        var10000 = this.rightLeg;
        var10000.y += Mth.lerp(this.core.flyAmount, 0.0F, flapAmount - 4.0F);
        var10000 = this.leftLeg;
        var10000.z += Mth.lerp(this.core.flyAmount, 0.0F, 7.0F);
        var10000 = this.rightLeg;
        var10000.z += Mth.lerp(this.core.flyAmount, 0.0F, 7.0F);
        this.leftLeg.xRot = Mth.lerp(this.core.flyAmount, 0.0F, 0.2617994F + Mth.cos(limbSwing * 0.3331F + 3.1415927F) * 0.35F * limbSwingAmount);
        this.rightLeg.xRot = Mth.lerp(this.core.flyAmount, 0.0F, 0.2617994F + Mth.cos(limbSwing * 0.3331F) * 0.35F * limbSwingAmount);
        this.rightLegLower.xRot = Mth.lerp(this.core.flyAmount, this.rightLegLower.xRot, -0.16362463F);
        this.leftLegLower.xRot = Mth.lerp(this.core.flyAmount, this.leftLegLower.xRot, -0.16362463F);
        this.rightFoot.xRot = Mth.lerp(this.core.flyAmount, this.rightFoot.xRot, 0.3926991F);
        this.leftFoot.xRot = Mth.lerp(this.core.flyAmount, this.leftFoot.xRot, 0.3926991F);
        this.rightPad.xRot = Mth.lerp(this.core.flyAmount, this.rightPad.xRot, 0.3490659F);
        this.leftPad.xRot = Mth.lerp(this.core.flyAmount, this.leftPad.xRot, 0.3490659F);

        this.frontLeftLeg.xRot= Mth.lerp(this.core.flyAmount, 0.0F, 0.2617994F + Mth.cos(limbSwing * 0.3331F + 3.1415927F) * 0.35F * limbSwingAmount);
        this.frontLeftLegLower.xRot = Mth.lerp(this.core.flyAmount, this.frontLeftLegLower.xRot, -0.16362463F);
        this.frontLeftFoot.xRot = Mth.lerp(this.core.flyAmount, this.frontLeftFoot.xRot, 0.3926991F);
        this.frontRightLeg.xRot = Mth.lerp(this.core.flyAmount, 0.0F, 0.2617994F + Mth.cos(limbSwing * 0.3331F) * 0.35F * limbSwingAmount);
        this.frontRightLegLower.xRot = Mth.lerp(this.core.flyAmount, this.frontRightLegLower.xRot, -0.16362463F);
        this.frontRightFoot.xRot = Mth.lerp(this.core.flyAmount, this.frontRightFoot.xRot, 0.3926991F);
    }
}
/*
frontLeftLeg, frontLeftLegLower, frontLeftFoot,
frontRightLeg, frontRightLegLower, frontRightFoot,
backLeftLeg,backLeftLegLower, backLeftFoot, backLeftPad,
backRightLeg,
backRightLegLower, backRightFoot, backRightPad

 */