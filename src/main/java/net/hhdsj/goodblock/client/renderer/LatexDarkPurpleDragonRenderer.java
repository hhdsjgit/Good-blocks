package net.hhdsj.goodblock.client.renderer;

import net.hhdsj.goodblock.client.model.ModelDarkPurpleLatexDragon;
import net.hhdsj.goodblock.client.model.Modellatexyunxqhotdragon;
import net.hhdsj.goodblock.client.model.taur.ModelLatexDarkPurpleDragonTaur;
import net.hhdsj.goodblock.entity.DarkPurpleLatexDragonEntity;
import net.hhdsj.goodblock.entity.LatexDarkPurpleDragonTaurEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexCentaurLowerModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleTaurUpperModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWingedDragonModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorModelPicker;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class LatexDarkPurpleDragonRenderer extends AdvancedHumanoidRenderer<DarkPurpleLatexDragonEntity, ModelDarkPurpleLatexDragon, ArmorLatexMaleWingedDragonModel<DarkPurpleLatexDragonEntity>> {
    public LatexDarkPurpleDragonRenderer(EntityRendererProvider.Context context) {
        super(context, new ModelDarkPurpleLatexDragon(context.bakeLayer(ModelDarkPurpleLatexDragon.LAYER_LOCATION)),
                ArmorLatexMaleWingedDragonModel.MODEL_SET,
                0.5f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(new EmissiveBodyLayer<>(this, new ResourceLocation("goodblock", "textures/entities/latex/taur/dark_purple_latex_dragon_light.png")));
        this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor,
                CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#ca00ff")), CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#ca00ff")),
                CustomEyesLayer::noRender, CustomEyesLayer::noRender));
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull DarkPurpleLatexDragonEntity p_114482_) {
        return new ResourceLocation("goodblock:textures/entities/latex/taur/dark_purple_latex_dragon.png");
    }
}