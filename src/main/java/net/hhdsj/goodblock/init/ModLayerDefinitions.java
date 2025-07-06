package net.hhdsj.goodblock.init;
import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.client.renderer.blockentity.LatexContainerRenderer;
import net.ltxprogrammer.changed.client.renderer.blockentity.PillowRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.*;
import net.ltxprogrammer.changed.client.renderer.model.hair.HairRemodel;
import net.ltxprogrammer.changed.client.tfanimations.TransfurHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.hhdsj.goodblock.entity.latex.TestEntityModel;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModLayerDefinitions {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        //event.registerLayerDefinition(TestEntityModel.LAYER_LOCATION, ModEntityModel::createBodyLayer);
        event.registerLayerDefinition(TestEntityModel.LAYER_LOCATION, TestEntityModel::createBodyLayer);
    }
}