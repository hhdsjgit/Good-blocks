package net.hhdsj.goodblock.procedures;

import net.hhdsj.goodblock.event.GoodblockProcessTransfur;
import net.ltxprogrammer.changed.init.ChangedItems;
import net.ltxprogrammer.changed.init.ChangedTransfurVariants;
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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.ltxprogrammer.changed.entity.*;

import java.util.List;

import static net.hhdsj.goodblock.fluid.FluidhottestFluid.PROPERTIES;

public class LatexhotparZaiXiaoGuoChiXuShiMeiKeFaShengProcedure {
    private static final ResourceLocation FORM_VARIANT = new ResourceLocation("goodblock", "form_latex_yunxq_hot_dragon");

    public static void execute(LivingEntity livingEntity) {
        try {
            final var variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(FORM_VARIANT);
            
            if (variant != null) {
                GoodblockProcessTransfur.progressTransfur(livingEntity, 2.1f, variant, TransfurContext.hazard(TransfurCause.GRAB_REPLICATE));
            }
        } catch (Exception e) {
            //System.err.println("Error during transfur process: " + e.getMessage());
            e.printStackTrace();
        }
    }


    /*
    public DarkDragonCrystal(Properties p_53514_) {
        super(ChangedTransfurVariants.DARK_DRAGON, ChangedItems.DARK_DRAGON_CRYSTAL_FRAGMENT, p_53514_);
    }*/
}