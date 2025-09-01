
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
import net.hhdsj.goodblock.client.model.ModelLatexthreemonthwolf;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.LatexSnowLeopardMaleModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleCatModel;
import net.ltxprogrammer.changed.entity.beast.LatexSnowLeopardMale;


import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.model.DarkLatexWolfPupModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorNoneModel;
import net.ltxprogrammer.changed.entity.beast.DarkLatexWolfPup;
import net.ltxprogrammer.changed.util.Color3;
import net.hhdsj.goodblock.client.model.DarkfuLatexWolfMale;


import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.LatexPurpleFoxModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWolfModel;
import net.ltxprogrammer.changed.entity.beast.LatexPurpleFox;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Pose;
import org.jetbrains.annotations.NotNull;


public class LatexthreemonthwolfRenderer extends AdvancedHumanoidRenderer<LatexthreemonthwolfEntity, 
ModelLatexthreemonthwolf, ArmorLatexMaleCatModel<LatexthreemonthwolfEntity>> {

	public LatexthreemonthwolfRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLatexthreemonthwolf(context.bakeLayer(ModelLatexthreemonthwolf.LAYER_LOCATION)), 
		ArmorLatexMaleCatModel.MODEL_SET, 0.5f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(new CustomEyesLayer<>(this, context.getModelSet()));
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
		this.addLayer(new EyesLayer<LatexthreemonthwolfEntity, ModelLatexthreemonthwolf>(this) {
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
