
package net.hhdsj.goodblock.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.hhdsj.goodblock.entity.LatexiceDragonEntity;
import net.hhdsj.goodblock.client.model.ModelLatexicedragon;

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

public class LatexiceDragonRenderer extends AdvancedHumanoidRenderer<LatexiceDragonEntity, ModelLatexicedragon, ArmorLatexBigTailDragonModel<LatexiceDragonEntity>> {
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
		return new ResourceLocation("goodblock:textures/entities/latex_ice_dragon.png");
	}
}
