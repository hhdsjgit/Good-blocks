
package net.hhdsj.goodblock.client.renderer.latex_wolf;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.hhdsj.goodblock.procedures.LatexthreemonthwolfZhanDouShiTiTiaoJianProcedure;
import net.hhdsj.goodblock.entity.LatexthreemonthwolfEntity;
import net.hhdsj.goodblock.client.model.latex_wolf.ModelLatexthreemonthwolf;

import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleCatModel;


import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;


public class LatexthreemonthwolfRenderer extends AdvancedHumanoidRenderer<LatexthreemonthwolfEntity, ModelLatexthreemonthwolf> {

	public LatexthreemonthwolfRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLatexthreemonthwolf(context.bakeLayer(ModelLatexthreemonthwolf.LAYER_LOCATION)), 
		ArmorLatexMaleCatModel.MODEL_SET, 0.5f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
		this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor, CustomEyesLayer::glowingIrisColorLeft, CustomEyesLayer::glowingIrisColorRight, CustomEyesLayer::noRender, CustomEyesLayer::noRender));
		this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
	}

	@Override
	public ResourceLocation getTextureLocation(LatexthreemonthwolfEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex/latex_purple_ws_wolf1.png");
	}

	@Override
	protected boolean isShaking(LatexthreemonthwolfEntity _ent) {
		Entity entity = _ent;
		Level world = ((LatexthreemonthwolfEntity) entity).level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return LatexthreemonthwolfZhanDouShiTiTiaoJianProcedure.execute(entity);
	}
}
