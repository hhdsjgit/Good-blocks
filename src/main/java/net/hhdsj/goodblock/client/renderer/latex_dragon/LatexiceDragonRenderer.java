
package net.hhdsj.goodblock.client.renderer.latex_dragon;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.hhdsj.goodblock.entity.LatexiceDragonEntity;
import net.hhdsj.goodblock.client.model.latex_dragon.ModelLatexicedragon;


import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexBigTailDragonModel;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;

public class LatexiceDragonRenderer extends AdvancedHumanoidRenderer<LatexiceDragonEntity, ModelLatexicedragon> {
	public LatexiceDragonRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLatexicedragon(context.bakeLayer(ModelLatexicedragon.LAYER_LOCATION)),
			//ArmorLatexBigTailDragonModel::new,
			ArmorLatexBigTailDragonModel.MODEL_SET,
			0.5f);
		this.addLayer(new LatexParticlesLayer<>(this, this.model));
		this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
		this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
				.withSclera(Color3.WHITE).withIris(Color3.fromInt(0x7889f3)).build());
		this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
	}

	@Override
	public ResourceLocation getTextureLocation(LatexiceDragonEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex/latex_ice_dragon.png");
	}
}
