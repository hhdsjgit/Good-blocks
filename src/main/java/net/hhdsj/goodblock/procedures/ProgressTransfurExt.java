package net.hhdsj.goodblock.procedures;

import net.hhdsj.goodblock.event.GoodblockProcessTransfur;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class ProgressTransfurExt {
    private static final ResourceLocation FORM_VARIANT = new ResourceLocation("goodblock", "form_latex_yunxq_hot_dragon");

    public static void execute(LivingEntity livingEntity,String text) {
        final ResourceLocation FORM_VARIANT = new ResourceLocation(text);
        try {
            final var variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(FORM_VARIANT);

            if (variant != null) {
                GoodblockProcessTransfur.progressTransfur(livingEntity, 2.1f, variant, TransfurContext.hazard(TransfurCause.GRAB_REPLICATE));
            }
        } catch (Exception e) {
            e.printStackTrace();
            //QWQ
        }
    }
}
