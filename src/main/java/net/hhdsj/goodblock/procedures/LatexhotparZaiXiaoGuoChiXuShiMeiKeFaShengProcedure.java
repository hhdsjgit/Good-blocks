package net.hhdsj.goodblock.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.init.ChangedTabs;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.ltxprogrammer.changed.util.TagUtil;
import net.ltxprogrammer.changed.util.UniversalDist;

public class LatexhotparZaiXiaoGuoChiXuShiMeiKeFaShengProcedure {
    private static final ResourceLocation FORM_VARIANT = new ResourceLocation("goodblock", "form_latex_yunxq_hot_dragon");
    
    public static void execute(LivingEntity livingEntity) {
        try {
            final var variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(FORM_VARIANT);
            
            if (variant != null) {
                ProcessTransfur.progressTransfur(livingEntity, 0.02f, variant, TransfurContext.hazard(TransfurCause.GRAB_REPLICATE));
            } else {
                System.err.println("Could not find TransfurVariant for: " + FORM_VARIANT);
            }
        } catch (Exception e) {
            System.err.println("Error during transfur process: " + e.getMessage());
            e.printStackTrace();
        }
    }
}