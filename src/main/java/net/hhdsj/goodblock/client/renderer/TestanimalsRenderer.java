
package net.hhdsj.goodblock.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.hhdsj.goodblock.entity.TestanimalsEntity;
import net.hhdsj.goodblock.client.model.ModelNoNameMob;

public class TestanimalsRenderer extends MobRenderer<TestanimalsEntity, ModelNoNameMob<TestanimalsEntity>> {
	public TestanimalsRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelNoNameMob(context.bakeLayer(ModelNoNameMob.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TestanimalsEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/dark_latex_yufeng.png");
	}
}
