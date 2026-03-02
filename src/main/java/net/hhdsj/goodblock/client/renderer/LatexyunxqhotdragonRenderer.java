package net.hhdsj.goodblock.client.renderer;

import net.hhdsj.goodblock.client.model.ModelLatexiceredDragonUnified_bw;
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
import org.jetbrains.annotations.NotNull;

public class LatexyunxqhotdragonRenderer extends AdvancedHumanoidRenderer<LatexyunxqhotdragonEntity, Modellatexyunxqhotdragon, ArmorLatexMaleWingedDragonModel<LatexyunxqhotdragonEntity>> {
	public LatexyunxqhotdragonRenderer(EntityRendererProvider.Context context) {
		super(context, new Modellatexyunxqhotdragon(context.bakeLayer(Modellatexyunxqhotdragon.LAYER_LOCATION)),
				ArmorLatexMaleWingedDragonModel.MODEL_SET,
				0.5f);
		this.addLayer(new EmissiveBodyLayer<>(this, new ResourceLocation("goodblock:textures/entities/latex/latex_yunxq_hot_dragon_light.png")));
		this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
		this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor, CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#ff2700")), CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#ff2700")), CustomEyesLayer::noRender, CustomEyesLayer::noRender));
		this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
		
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(LatexyunxqhotdragonEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex/latex_yunxq_hot_dragon.png");
	}
}
//latex_yunqi_ice_dragon_light
