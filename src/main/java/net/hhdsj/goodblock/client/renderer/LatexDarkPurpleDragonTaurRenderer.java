package net.hhdsj.goodblock.client.renderer;

import net.hhdsj.goodblock.client.model.taur.ModelLatexDarkPurpleDragonTaur;
import net.hhdsj.goodblock.entity.LatexDarkPurpleDragonTaurEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.*;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class LatexDarkPurpleDragonTaurRenderer extends AdvancedHumanoidRenderer<LatexDarkPurpleDragonTaurEntity, ModelLatexDarkPurpleDragonTaur, ArmorLatexMaleTaurUpperModel<LatexDarkPurpleDragonTaurEntity>> {
    public LatexDarkPurpleDragonTaurRenderer(EntityRendererProvider.Context context) {
        super(context, new ModelLatexDarkPurpleDragonTaur(context.bakeLayer(ModelLatexDarkPurpleDragonTaur.LAYER_LOCATION)),
                ArmorModelPicker.centaur(context.getModelSet(), ArmorLatexMaleTaurUpperModel.MODEL_SET, ArmorLatexCentaurLowerModel.MODEL_SET), 0.7f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(new EmissiveBodyLayer<>(this, new ResourceLocation("goodblock", "textures/entities/latex/taur/dark_purple_latex_dragon_taur_light.png")));
        this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor,
                CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#ca00ff")), CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#ca00ff")),
                CustomEyesLayer::noRender, CustomEyesLayer::noRender));
        this.addLayer(new SaddleLayer<>(this, getModel(), new ResourceLocation("goodblock:textures/entities/latex/taur/dark_purple_latex_dragon_taur_saddle.png")));
        this.addLayer(new TaurChestPackLayer<>(this, context.getModelSet()));
        this.addLayer(TransfurCapeLayer.shortCape(this, context.getModelSet()));
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull LatexDarkPurpleDragonTaurEntity p_114482_) {
        return new ResourceLocation("goodblock:textures/entities/latex/taur/dark_purple_latex_dragon_taur.png");
    }
}