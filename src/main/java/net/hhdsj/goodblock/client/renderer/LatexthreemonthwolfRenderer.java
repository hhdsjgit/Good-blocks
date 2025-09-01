
package net.hhdsj.goodblock.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.hhdsj.goodblock.procedures.LatexthreemonthwolfZhanDouShiTiTiaoJianProcedure;
import net.hhdsj.goodblock.entity.LatexthreemonthwolfEntity;
import net.hhdsj.goodblock.client.model.ModelLatexPurpleFoxUnified;

public class LatexthreemonthwolfRenderer extends MobRenderer<LatexthreemonthwolfEntity, ModelLatexPurpleFoxUnified<LatexthreemonthwolfEntity>> {
	public LatexthreemonthwolfRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLatexPurpleFoxUnified(context.bakeLayer(ModelLatexPurpleFoxUnified.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<LatexthreemonthwolfEntity, ModelLatexPurpleFoxUnified<LatexthreemonthwolfEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("goodblock:textures/entities/latex_purple_ws_wolf_light.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(LatexthreemonthwolfEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex_purple_ws_wolf.png");
	}

	@Override
	protected boolean isShaking(LatexthreemonthwolfEntity _ent) {
		Entity entity = _ent;
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return LatexthreemonthwolfZhanDouShiTiTiaoJianProcedure.execute(entity);
	}
}
