
package net.hhdsj.goodblock.client.renderer.latex_wolf;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.hhdsj.goodblock.entity.LatexpurplewswolfEntity;
import net.hhdsj.goodblock.client.model.latex_wolf.ModelLatexpurplewswolf;

import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleCatModel;


import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;

import org.jetbrains.annotations.NotNull;

public class LatexpurplewswolfRenderer extends AdvancedHumanoidRenderer<LatexpurplewswolfEntity, ModelLatexpurplewswolf> {
	public LatexpurplewswolfRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLatexpurplewswolf(context.bakeLayer(ModelLatexpurplewswolf.LAYER_LOCATION)), 
		ArmorLatexMaleCatModel.MODEL_SET, 0.5f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
		this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor, CustomEyesLayer::glowingIrisColorLeft, CustomEyesLayer::glowingIrisColorRight, CustomEyesLayer::noRender, CustomEyesLayer::noRender));
		this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(LatexpurplewswolfEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex/latex_purple_ws_wolf1.png");
	}
}
