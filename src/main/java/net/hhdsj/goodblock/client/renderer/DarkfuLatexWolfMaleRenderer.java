
package net.hhdsj.goodblock.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.hhdsj.goodblock.entity.DarkfuLatexWolfMaleEntity;
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

public class DarkfuLatexWolfMaleRenderer extends AdvancedHumanoidRenderer<DarkfuLatexWolfMaleEntity ,DarkfuLatexWolfMale , ArmorLatexMaleWolfModel<DarkfuLatexWolfMaleEntity>>{
	public DarkfuLatexWolfMaleRenderer(EntityRendererProvider.Context context) {
		super(context, new DarkfuLatexWolfMale(context.bakeLayer(DarkfuLatexWolfMale.LAYER_LOCATION)),
			ArmorLatexMaleWolfModel::new, 
            ArmorLatexMaleWolfModel.INNER_ARMOR, 
            ArmorLatexMaleWolfModel.OUTER_ARMOR, 
            0.5f);	
		this.addLayer(new LatexParticlesLayer<>(this, this.getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
                .withSclera(Color3.WHITE).withIris(Color3.fromInt(0x43b44e)).build());
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
	}

	@Override
	public ResourceLocation getTextureLocation(DarkfuLatexWolfMaleEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/dark_latex_wolf_male.png");
	}
}
