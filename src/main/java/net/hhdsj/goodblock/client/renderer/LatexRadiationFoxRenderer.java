
package net.hhdsj.goodblock.client.renderer;

import net.hhdsj.goodblock.client.model.ModelLatexRadiationFox;
import net.hhdsj.goodblock.entity.LatexOrangeFoxEntity;
import net.hhdsj.goodblock.entity.LatexRadiationFoxEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWolfModel;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LatexRadiationFoxRenderer extends
		AdvancedHumanoidRenderer<LatexRadiationFoxEntity, ModelLatexRadiationFox,
				ArmorLatexMaleWolfModel<LatexRadiationFoxEntity>> {
	public LatexRadiationFoxRenderer(EntityRendererProvider.Context context) {
	
		super(context, new ModelLatexRadiationFox(context.bakeLayer(ModelLatexRadiationFox.LAYER_LOCATION)),
            ArmorLatexMaleWolfModel.MODEL_SET,
            0.5f);	
		this.addLayer(new LatexParticlesLayer<>(this, this.getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
                .withSclera(Color3.WHITE).withIris(Color3.fromInt(0x43b44e)).build());
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
	}

	@Override
	public ResourceLocation getTextureLocation(LatexRadiationFoxEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex/latex_orange_fox.png");
	}
}
