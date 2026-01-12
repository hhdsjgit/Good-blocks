
package net.hhdsj.goodblock.client.renderer;

import net.hhdsj.goodblock.client.model.ModelLatexPurpleCoocWolf;
import net.hhdsj.goodblock.client.model.Modellatexyunxqhotdragon;
import net.hhdsj.goodblock.entity.LatexPurplecoocwolfEntity;
import net.hhdsj.goodblock.entity.LatexyunxqhotdragonEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWolfModel;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class LatexPurpleCoocWolfRenderer extends AdvancedHumanoidRenderer<LatexPurplecoocwolfEntity, ModelLatexPurpleCoocWolf, ArmorLatexMaleWolfModel<LatexPurplecoocwolfEntity>>  {//public class LatexOrangeFoxRenderer extends AdvancedHumanoidRenderer<LatexPurplecoocwolfEntity, ModelLatexPurpleCoocWolf, ArmorLatexMaleWolfModel<LatexPurplecoocwolfEntity>> { //extends MobRenderer<LatexPurplecoocwolfEntity, ModelLatexPurpleCoocWolf<LatexPurplecoocwolfEntity>> {
	public LatexPurpleCoocWolfRenderer(EntityRendererProvider.Context context) {
	
		super(context, new ModelLatexPurpleCoocWolf(context.bakeLayer(ModelLatexPurpleCoocWolf.LAYER_LOCATION)),
            ArmorLatexMaleWolfModel.MODEL_SET,
            0.5f);
		this.addLayer(new EyesLayer<LatexPurplecoocwolfEntity, ModelLatexPurpleCoocWolf>(this) {
			@Override
			public @NotNull RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("goodblock:textures/entities/latex_purple_cooc_wolf_light.png"));
			}
		});
		this.addLayer(new LatexParticlesLayer<>(this, this.getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
		this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor, CustomEyesLayer::glowingIrisColorLeft, CustomEyesLayer::glowingIrisColorRight, CustomEyesLayer::noRender, CustomEyesLayer::noRender));
		this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));

	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull LatexPurplecoocwolfEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex_purple_cooc_wolf.png");
	}
}
