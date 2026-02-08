
package net.hhdsj.goodblock.client.renderer;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWingedDragonModel;
import net.ltxprogrammer.changed.entity.beast.LatexPurpleFox;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;

import net.hhdsj.goodblock.client.model.Modelbluedragon;
import net.hhdsj.goodblock.entity.LatexbluedragonEntity;

public class LatexbluedragonRenderer extends AdvancedHumanoidRenderer<LatexbluedragonEntity, Modelbluedragon, ArmorLatexMaleWingedDragonModel<LatexbluedragonEntity>> {
	public LatexbluedragonRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbluedragon(context.bakeLayer(Modelbluedragon.LAYER_LOCATION)),
		ArmorLatexMaleWingedDragonModel.MODEL_SET, 
		0.5f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
                .withSclera(Color3.WHITE).withIris(Color3.fromInt(0x7889f3)).build());
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
	}


	@Override
	public ResourceLocation getTextureLocation(LatexbluedragonEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex/latex_bluegreen_texture_new1.png");
	}
}
