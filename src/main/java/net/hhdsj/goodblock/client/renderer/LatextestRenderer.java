
package net.hhdsj.goodblock.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.hhdsj.goodblock.entity.LatextestEntity;
import net.hhdsj.goodblock.client.model.ModelNoNameMob;

public class LatextestRenderer extends MobRenderer<LatextestEntity, ModelNoNameMob<LatextestEntity>> {
	public LatextestRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelNoNameMob(context.bakeLayer(ModelNoNameMob.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LatextestEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/dark_latex_yufeng.png");
	}
}
