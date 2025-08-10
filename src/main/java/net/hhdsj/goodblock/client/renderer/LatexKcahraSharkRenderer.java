
package net.hhdsj.goodblock.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.LatexTigerSharkModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleSharkModel;
import net.ltxprogrammer.changed.entity.beast.LatexPurpleFox;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;

import net.hhdsj.goodblock.entity.LatexKcahraSharkEntity;
import net.hhdsj.goodblock.client.model.ModelLatexKcahraShark;

//public class LatexKcahraSharkRenderer extends MobRenderer<LatexKcahraSharkEntity, ModelLatexKcahraShark> {
public class LatexKcahraSharkRenderer extends AdvancedHumanoidRenderer<LatexKcahraSharkEntity, ModelLatexKcahraShark, ArmorLatexMaleSharkModel<LatexKcahraSharkEntity>>{
	public LatexKcahraSharkRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLatexKcahraShark(context.bakeLayer(ModelLatexKcahraShark.LAYER_LOCATION)),
		ArmorLatexMaleSharkModel::new, 
            ArmorLatexMaleSharkModel.INNER_ARMOR, 
            ArmorLatexMaleSharkModel.OUTER_ARMOR, 
            0.5f);	
		this.addLayer(new LatexParticlesLayer<>(this, this.getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(new CustomEyesLayer<>(this, context.getModelSet()));      
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
	}

	@Override
	public ResourceLocation getTextureLocation(LatexKcahraSharkEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex_texture.png");
	}
}
