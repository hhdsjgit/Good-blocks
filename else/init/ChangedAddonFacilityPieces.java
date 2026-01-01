package net.foxyas.changedaddon.init;

import net.foxyas.changedaddon.ChangedAddonMod;
import net.ltxprogrammer.changed.world.features.structures.LootTables;
import net.ltxprogrammer.changed.world.features.structures.facility.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChangedAddonFacilityPieces {

    @SubscribeEvent
    public static void RegisterAddonFacilityPieces(GatherFacilityPiecesEvent event) {
        switch (event.getPieceType()) {
            case ROOM -> registerAddonRooms(event.getBuilder());
            case CORRIDOR -> registerAddonCorridors(event.getBuilder());
        }
    }

    public static void registerAddonCorridors(FacilityPieceCollectionBuilder builder) {
       builder.register((int) (FacilityPieceCollectionBuilder.WEIGHT_COMMON * 1.5f),
                        new FacilityCorridorSection(new ResourceLocation("changed_addon:facility_hallways/specimen_containment_a"),
                                LootTables.HIGH_TIER_LAB))
                .register((int) (FacilityPieceCollectionBuilder.WEIGHT_COMMON * 1.5f),
                        new FacilityCorridorSection(new ResourceLocation("changed_addon:facility_hallways/specimen_containment_b"),
                                LootTables.HIGH_TIER_LAB));
    }

    public static void registerAddonRooms(FacilityPieceCollectionBuilder builder) {
        builder.register(FacilityPieceCollectionBuilder.WEIGHT_UNCOMMON,
                new FacilityRoomPiece(new ResourceLocation("changed_addon:facility_rooms/exp009room"),
                        new ResourceLocation("changed_addon:chests/experiment_009_loot_dna")))
                .register(FacilityPieceCollectionBuilder.WEIGHT_UNCOMMON,
                new FacilityRoomPiece(new ResourceLocation("changed_addon:facility_rooms/exp10room"),
                        new ResourceLocation("changed_addon:chests/experiment_10_loot_op")))
                .register(FacilityPieceCollectionBuilder.WEIGHT_UNCOMMON,
                        new FacilityRoomPiece(new ResourceLocation("changed_addon:facility_rooms/luminar_crystal_room"),
                                new ResourceLocation("changed:chests/high_tier_lab")))
                .register(FacilityPieceCollectionBuilder.WEIGHT_COMMON,
                        new FacilityRoomPiece(new ResourceLocation("changed_addon:facility_rooms/closed_meteor"),
                                new ResourceLocation("changed:chests/high_tier_lab")));
    }
}