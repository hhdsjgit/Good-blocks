package net.hhdsj.goodblock.client.model.renderer;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.hhdsj.goodblock.client.model.DragonLatexEntityModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWingedDragonModel;
import net.hhdsj.goodblock.entity.beast.DragonLatexEntity;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class DragonLatexEntityRenderer extends AdvancedHumanoidRenderer<LatexRedDragon, DragonLatexEntityModel, ArmorLatexMaleWingedDragonModel<LatexRedDragon>> {
    public DragonLatexEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new DragonLatexEntityModell(context.bakeLayer(DragonLatexEntityModel.LAYER_LOCATION)),
                ArmorLatexMaleWingedDragonModel::new, ArmorLatexMaleWingedDragonModel.INNER_ARMOR, ArmorLatexMaleWingedDragonModel.OUTER_ARMOR, 0.5f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
                .withSclera(Color3.WHITE).withIris(Color3.fromInt(0xffe93f)).build());
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(DragonLatexEntity p_114482_) {
        return Changed.modResource("textures/DragonLatexEntity.png");
    }
}