
package net.hhdsj.goodblock.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.hhdsj.goodblock.entity.LatexfoxEntity;
import net.hhdsj.goodblock.client.model.ModelLatexPurpleFoxUnified;

public class LatexfoxRenderer extends MobRenderer<LatexfoxEntity, ModelLatexPurpleFoxUnified<LatexfoxEntity>> {
	public LatexfoxRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLatexPurpleFoxUnified(context.bakeLayer(ModelLatexPurpleFoxUnified.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LatexfoxEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex_purple_fox.png");
	}
}
