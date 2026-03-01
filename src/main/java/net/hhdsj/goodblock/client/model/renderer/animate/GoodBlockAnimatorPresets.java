package net.hhdsj.goodblock.client.model.renderer.animate;

import net.hhdsj.goodblock.client.model.renderer.animate.bipedal.DragontaurBipedalCreativeFlyAnimator;
import net.ltxprogrammer.changed.client.renderer.animate.AnimatorPresets;
import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.client.renderer.animate.arm.ArmBobAnimator;
import net.ltxprogrammer.changed.client.renderer.animate.arm.ArmRideAnimator;
import net.ltxprogrammer.changed.client.renderer.animate.arm.ArmSwimAnimator;
import net.ltxprogrammer.changed.client.renderer.animate.bipedal.DragonBipedalCreativeFlyAnimator;
import net.ltxprogrammer.changed.client.renderer.animate.upperbody.DragonHeadCreativeFlyAnimator;
import net.ltxprogrammer.changed.client.renderer.animate.upperbody.DragonHeadInitAnimator;
import net.ltxprogrammer.changed.client.renderer.animate.upperbody.WolfHeadInitAnimator;
import net.ltxprogrammer.changed.client.renderer.model.AdvancedHumanoidModel;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.minecraft.client.model.geom.ModelPart;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class GoodBlockAnimatorPresets extends AnimatorPresets {
    public GoodBlockAnimatorPresets() {

    }

    public static <T extends ChangedEntity, M extends AdvancedHumanoidModel<T>> @NotNull Consumer<HumanoidAnimator<T, M>>
    dragontaurLike(ModelPart head, ModelPart leftEar, ModelPart rightEar, ModelPart torso, ModelPart leftArm, ModelPart rightArm,
                   ModelPart lowerTorso, ModelPart frontLeftLeg, ModelPart frontLeftLegLower, ModelPart frontLeftFoot,
                   ModelPart frontRightLeg, ModelPart frontRightLegLower, ModelPart frontRightFoot, ModelPart backLeftLeg,
                   ModelPart backLeftLegLower, ModelPart backLeftFoot, ModelPart backLeftPad, ModelPart backRightLeg,
                   ModelPart backRightLegLower, ModelPart backRightFoot, ModelPart backRightPad, ModelPart leftWingRoot,
                   ModelPart leftWingBone1, ModelPart leftWingBone2, ModelPart rightWingRoot, ModelPart rightWingBone1, ModelPart rightWingBone2,
                   ModelPart tail, List<ModelPart> tailJoints) {
        return (animator) -> {
            animator.addPreset(taurLegs(lowerTorso, frontLeftLeg, frontLeftLegLower, frontLeftFoot,
                    frontRightLeg, frontRightLegLower, frontRightFoot, backLeftLeg,
                    backLeftLegLower, backLeftFoot, backLeftPad, backRightLeg,
                    backRightLegLower, backRightFoot, backRightPad))
                    .addPreset(taurUpperBody(head, torso, leftArm, rightArm))
                    .addPreset(dragonTail(tail, tailJoints))
                    .addPreset(dragonWinged(leftWingRoot, leftWingBone1, leftWingBone2, rightWingRoot, rightWingBone1, rightWingBone2))
                    .addAnimator(new WolfHeadInitAnimator<>(head))
                    .addAnimator(new ArmSwimAnimator<>(leftArm, rightArm))
                    .addAnimator(new ArmBobAnimator<>(leftArm, rightArm))
                    .addAnimator(new ArmRideAnimator<>(leftArm, rightArm));

        };
    }
}
/**
 *
 * public static <T extends ChangedEntity, M extends AdvancedHumanoidModel<T>> Consumer<HumanoidAnimator<T, M>>
 *     wingedDragonLike(ModelPart head, ModelPart torso, ModelPart leftArm, ModelPart rightArm, ModelPart tail,
 *     List<ModelPart> tailJoints, ModelPart leftLeg, ModelPart leftLegLower, ModelPart leftFoot, ModelPart leftPad,
 *     ModelPart rightLeg, ModelPart rightLegLower, ModelPart rightFoot, ModelPart rightPad, ModelPart leftWingRoot,
 *     ModelPart leftWingBone1, ModelPart leftWingBone2, ModelPart rightWingRoot, ModelPart rightWingBone1, ModelPart rightWingBone2) {
 *         return (animator) -> {
 *             animator.addPreset(dragonBipedal(leftLeg, leftLegLower, leftFoot,
 *             leftPad, rightLeg, rightLegLower, rightFoot, rightPad))
 *             .addPreset(dragonWingedUpperBody(head, torso, leftArm, rightArm))
 *             .addPreset(dragonTail(tail, tailJoints))
 *             .addPreset(dragonWinged(leftWingRoot, leftWingBone1, leftWingBone2, rightWingRoot, rightWingBone1, rightWingBone2))
 *             .addAnimator(new DragonBipedalCreativeFlyAnimator(leftLeg, leftLegLower, leftFoot, leftPad, rightLeg, rightLegLower, rightFoot, rightPad))
 *             .addAnimator(new DragonTailCreativeFlyAnimator(tail, tailJoints))
 *             .addAnimator(new DragonHeadCreativeFlyAnimator(head))
 *             .addAnimator(new DragonHeadInitAnimator(head))
 *             .addAnimator(new ArmSwimAnimator(leftArm, rightArm))
 *             .addAnimator(new ArmBobAnimator(leftArm, rightArm)).
 *             addAnimator(new ArmRideAnimator(leftArm, rightArm))
 *             .addCameraAnimator(new DragonCameraCreativeFlyAnimator());
 *             .addAnimator(new DragontaurBipedalCreativeFlyAnimator<>(frontLeftLeg, frontLeftLegLower, frontLeftFoot,
 *                             frontRightLeg, frontRightLegLower, frontRightFoot,
 *                             backLeftLeg,backLeftLegLower, backLeftFoot, backLeftPad,
 *                             backRightLeg,
 *                             backRightLegLower, backRightFoot, backRightPad
 *                     ))
 *         };
 *     }
 */