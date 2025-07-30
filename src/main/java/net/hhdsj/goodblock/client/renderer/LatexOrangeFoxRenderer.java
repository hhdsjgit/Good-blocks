
package net.hhdsj.goodblock.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.hhdsj.goodblock.entity.LatexOrangeFoxEntity;
import net.hhdsj.goodblock.client.model.ModelLatexPurpleFoxUnified;

public class LatexOrangeFoxRenderer extends MobRenderer<LatexOrangeFoxEntity, ModelLatexPurpleFoxUnified<LatexOrangeFoxEntity>> {
	public LatexOrangeFoxRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLatexPurpleFoxUnified(context.bakeLayer(ModelLatexPurpleFoxUnified.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LatexOrangeFoxEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex_orange_fox.png");
	}
}
