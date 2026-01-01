package net.ltxprogrammer.changed.init;

import net.ltxprogrammer.changed.client.renderer.accessory.*;
import net.ltxprogrammer.changed.client.renderer.layers.AccessoryLayer;
import net.ltxprogrammer.changed.client.renderer.model.ExoskeletonModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorModel;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ChangedAccessoryRenderers {
    @SubscribeEvent
    public static void registerAccessoryRenderers(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            var modelSet = Minecraft.getInstance().getEntityModels();

            AccessoryLayer.registerRenderer(ChangedItems.BENIGN_SHORTS.get(), SimpleClothingRenderer.of(ArmorModel.CLOTHING_INNER, EquipmentSlot.LEGS));
            AccessoryLayer.registerRenderer(ChangedItems.PINK_SHORTS.get(), SimpleClothingRenderer.of(ArmorModel.CLOTHING_INNER, EquipmentSlot.LEGS));
            AccessoryLayer.registerRenderer(ChangedItems.SPORTS_BRA.get(), SimpleClothingRenderer.of(ArmorModel.CLOTHING_INNER, EquipmentSlot.CHEST));
            AccessoryLayer.registerRenderer(ChangedItems.BLACK_TSHIRT.get(), SimpleClothingRenderer.of(ArmorModel.CLOTHING_INNER, EquipmentSlot.CHEST));
            AccessoryLayer.registerRenderer(ChangedItems.LAB_COAT.get(), SimpleClothingRenderer.of(ArmorModel.CLOTHING_OUTER, Set.of(
                    new SimpleClothingRenderer.ModelComponent(ArmorModel.CLOTHING_OUTER, EquipmentSlot.CHEST),
                    new SimpleClothingRenderer.ModelComponent(ArmorModel.CLOTHING_MIDDLE, EquipmentSlot.LEGS)
            )));
            AccessoryLayer.registerRenderer(ChangedItems.WETSUIT.get(), SimpleClothingRenderer.of(ArmorModel.CLOTHING_INNER, Set.of(
                    new SimpleClothingRenderer.ModelComponent(ArmorModel.CLOTHING_INNER, EquipmentSlot.CHEST),
                    new SimpleClothingRenderer.ModelComponent(ArmorModel.CLOTHING_INNER, EquipmentSlot.LEGS)
            )));
            AccessoryLayer.registerRenderer(ChangedItems.NITRILE_GLOVES.get(), SimpleClothingRenderer.of(ArmorModel.CLOTHING_OUTER, EquipmentSlot.CHEST));

            AccessoryLayer.registerRenderer(ChangedItems.EXOSKELETON.get(), () ->
                    new WornExoskeletonRenderer(modelSet, ExoskeletonModel.LAYER_LOCATION_SUIT, ExoskeletonModel.LAYER_LOCATION_VISOR, ExoskeletonModel.LAYER_LOCATION_HUMAN));
        });
    }
}
