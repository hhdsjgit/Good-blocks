
package net.hhdsj.goodblock.client.renderer.latex_pup;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;


import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorNoneModel;
import net.ltxprogrammer.changed.util.Color3;


import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;

import net.hhdsj.goodblock.client.model.latex_pup.ModelInksuger;
import net.hhdsj.goodblock.entity.InksugerEntity;
import net.hhdsj.goodblock.client.model.ModelNoNameMob;

public class InksugerRenderer extends AdvancedHumanoidRenderer<InksugerEntity, ModelInksuger> {
	public InksugerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelInksuger(context.bakeLayer(ModelInksuger.LAYER_LOCATION)),
				//ArmorNoneModel::new, 
				ArmorNoneModel.MODEL_SET, 
				0.4F);
		this.addLayer(new LatexParticlesLayer<>(this, this.model));
		this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
				.withSclera(Color3.fromInt(0x242424))
				.withIris(CustomEyesLayer.fixedIfNotDarkLatexOverrideLeft(Color3.WHITE),
						CustomEyesLayer.fixedIfNotDarkLatexOverrideRight(Color3.WHITE))
				.build().setHeadShape(CustomEyesLayer.HeadShape.PUP));
	}

	@Override
	public ResourceLocation getTextureLocation(InksugerEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex/ink_suger_pup.png");
	}
}
