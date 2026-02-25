package net.hhdsj.goodblock.client.renderer.boss;

import net.hhdsj.goodblock.client.model.boss.ModelLatexNightOwlBoss;
import net.hhdsj.goodblock.entity.LatexthreemonthwolfEntity;
import net.hhdsj.goodblock.entity.boss.LatexNightOwlBossEntity;
import net.hhdsj.goodblock.procedures.LatexthreemonthwolfZhanDouShiTiTiaoJianProcedure;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWingedDragonModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class LatexNightOwlBossRenderer extends AdvancedHumanoidRenderer<LatexNightOwlBossEntity, ModelLatexNightOwlBoss, ArmorLatexMaleWingedDragonModel<LatexNightOwlBossEntity>> {
    public LatexNightOwlBossRenderer(EntityRendererProvider.Context context) {

        super(context, new ModelLatexNightOwlBoss(context.bakeLayer(ModelLatexNightOwlBoss.LAYER_LOCATION)),
                ArmorLatexMaleWingedDragonModel.MODEL_SET,
                0.5f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(new CustomEyesLayer<>(this, context.getModelSet()));
        this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor, CustomEyesLayer::glowingIrisColorLeft, CustomEyesLayer::glowingIrisColorRight, CustomEyesLayer::noRender, CustomEyesLayer::noRender));
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(LatexNightOwlBossEntity entity) {
        return new ResourceLocation("goodblock:textures/entities/boss/latex_night_owl_boss_entity.png");
    }

    @Override
    protected boolean isShaking(@NotNull LatexNightOwlBossEntity _ent) {
        if (_ent.getHealth() < _ent.getMaxHealth() * 0.2)
            return true;
        else
            return false;
    }
}
