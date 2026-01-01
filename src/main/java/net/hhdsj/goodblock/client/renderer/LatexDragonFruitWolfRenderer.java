
package net.hhdsj.goodblock.client.renderer;

import net.hhdsj.goodblock.client.model.ModelLatexDragonFruitWolf;
import net.hhdsj.goodblock.entity.LatexDragonFruitWolfEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexBigTailDragonModel;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LatexDragonFruitWolfRenderer extends AdvancedHumanoidRenderer<LatexDragonFruitWolfEntity, ModelLatexDragonFruitWolf, ArmorLatexBigTailDragonModel<LatexDragonFruitWolfEntity>> {
	public LatexDragonFruitWolfRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLatexDragonFruitWolf(context.bakeLayer(ModelLatexDragonFruitWolf.LAYER_LOCATION)),
			//ArmorLatexBigTailDragonModel::new,
			ArmorLatexBigTailDragonModel.MODEL_SET,
			0.5f);
		this.addLayer(new LatexParticlesLayer<>(this, this.model));
		this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
		this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor, CustomEyesLayer::glowingIrisColorLeft, CustomEyesLayer::glowingIrisColorRight, CustomEyesLayer::noRender, CustomEyesLayer::noRender));
		this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
	}

	@Override
	public ResourceLocation getTextureLocation(LatexDragonFruitWolfEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex_ice_dragon.png");
	}
}
