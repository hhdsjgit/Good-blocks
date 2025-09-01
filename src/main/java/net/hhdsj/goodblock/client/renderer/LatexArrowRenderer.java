package net.hhdsj.goodblock.client.renderer;

import net.hhdsj.goodblock.entity.LatexthreemonthwolfEntityProjectile;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LatexArrowRenderer extends ArrowRenderer<LatexthreemonthwolfEntityProjectile> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/projectiles/arrow.png");
    
    public LatexArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(LatexthreemonthwolfEntityProjectile entity) {
        return TEXTURE;
    }
}