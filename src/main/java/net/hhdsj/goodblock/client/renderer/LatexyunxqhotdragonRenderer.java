
package net.hhdsj.goodblock.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.hhdsj.goodblock.entity.LatexyunxqhotdragonEntity;
import net.hhdsj.goodblock.client.model.Modellatexyunxqhotdragon;

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

public class LatexyunxqhotdragonRenderer extends AdvancedHumanoidRenderer<LatexyunxqhotdragonEntity, Modellatexyunxqhotdragon, ArmorLatexMaleWingedDragonModel<LatexyunxqhotdragonEntity>> {
	public LatexyunxqhotdragonRenderer(EntityRendererProvider.Context context) {
		super(context, new Modellatexyunxqhotdragon(context.bakeLayer(Modellatexyunxqhotdragon.LAYER_LOCATION)),
		//ArmorLatexMaleWingedDragonModel::new,
		ArmorLatexMaleWingedDragonModel.MODEL_SET, 
		0.5f);
		this.addLayer(new EyesLayer<LatexyunxqhotdragonEntity, Modellatexyunxqhotdragon>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("goodblock:textures/entities/latex_yunxq_hot_dragon_light.png"));
			}
		});
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        //this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
		
	}

	@Override
	public ResourceLocation getTextureLocation(LatexyunxqhotdragonEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex_yunxq_hot_dragon.png");
	}
}
