package net.hhdsj.goodblock.potion.procedures;

import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class LatexSlowInfectionMobProcedure {
    private static final ResourceLocation FORM_VARIANT = new ResourceLocation("goodblock", "form_latex_dragon_fruit_wolf");
    
    public static void execute(LivingEntity livingEntity) {

        final var variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(FORM_VARIANT);

        if (variant != null) {
            ProcessTransfur.progressTransfur(livingEntity, 0.09f, variant, TransfurContext.hazard(TransfurCause.GRAB_REPLICATE));
        }

    }
}