
package net.hhdsj.goodblock.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.hhdsj.goodblock.entity.LatexkamonaHSguydragonwolfEntity;
import net.hhdsj.goodblock.client.model.ModelLatexkamonaHSguydragonwolf;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.LatexTrafficConeDragonModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexBigTailDragonModel;
import net.ltxprogrammer.changed.entity.beast.LatexTrafficConeDragon;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;

public class LatexkamonaHSguydragonwolfRenderer extends AdvancedHumanoidRenderer<LatexkamonaHSguydragonwolfEntity, ModelLatexkamonaHSguydragonwolf, ArmorLatexBigTailDragonModel<LatexkamonaHSguydragonwolfEntity>> {
	public LatexkamonaHSguydragonwolfRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLatexkamonaHSguydragonwolf(context.bakeLayer(ModelLatexkamonaHSguydragonwolf.LAYER_LOCATION)), 
		ArmorLatexBigTailDragonModel.MODEL_SET,
		0.5f);
		this.addLayer(new LatexParticlesLayer<>(this, this.model));
		this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
		this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
				.withSclera(Color3.fromInt(0xffea86)).withIris(Color3.BLACK).build());
		this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
		
		this.addLayer(new EyesLayer<LatexkamonaHSguydragonwolfEntity, ModelLatexkamonaHSguydragonwolf>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("goodblock:textures/entities/latex_kamona_hsguy_dragonwolf_png_light.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(LatexkamonaHSguydragonwolfEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex_kamona_hsguy_dragonwolf_png1.png");
	}
}
