
package net.hhdsj.goodblock.client.renderer.latex_pup;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.hhdsj.goodblock.entity.WhitebluepupEntity;
import net.hhdsj.goodblock.client.model.ModelDarkLatexYufengUnified;

import net.hhdsj.goodblock.client.model.latex_pup.Modelwhitebluepup;


import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorNoneModel;
import net.ltxprogrammer.changed.util.Color3;


import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;

import net.hhdsj.goodblock.client.model.ModelNoNameMob;


public class WhitebluepupRenderer extends AdvancedHumanoidRenderer<WhitebluepupEntity, Modelwhitebluepup> {
	public WhitebluepupRenderer (EntityRendererProvider.Context context) {
		super(context, new Modelwhitebluepup(context.bakeLayer(Modelwhitebluepup.LAYER_LOCATION)),
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
	public ResourceLocation getTextureLocation(WhitebluepupEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex/wihteblue_latex_wolf_pup.png");
	}
}
