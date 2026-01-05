/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and it won't get overwritten.
 *    If you change your modid or package, you need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */

package net.hhdsj.goodblock;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import net.hhdsj.goodblock.init.GoodblockModTabs;
import net.hhdsj.goodblock.init.GoodblockModMobEffects;
import net.hhdsj.goodblock.init.GoodblockModItems;
import net.hhdsj.goodblock.init.GoodblockModFluids;
import net.hhdsj.goodblock.init.GoodblockModFeatures;
import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.hhdsj.goodblock.init.GoodblockModBlocks;
//java add
import net.hhdsj.goodblock.init.GoodblockModTransfurVariants;
import net.hhdsj.goodblock.init.GoodblockModParticleTypes;

import net.hhdsj.goodblock.registers.GoodblocksModels;
import net.hhdsj.goodblock.registers.GoodblockEntities;
//import net.hhdsj.goodblock.registers.GoodblockEntityRenderers;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;

@Mod("goodblock")
public class GoodblockMod {
	public static final Logger LOGGER = LogManager.getLogger(GoodblockMod.class);
	public static final String MODID = "goodblock";
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public GoodblockMod() {
		GoodblockModTabs.load();
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		GoodblockModBlocks.REGISTRY.register(bus);
		GoodblockModItems.REGISTRY.register(bus);
		GoodblockModEntities.REGISTRY.register(bus);
		GoodblockEntities.REGISTRY.register(bus);

		GoodblockModFeatures.REGISTRY.register(bus);
		GoodblockModFluids.REGISTRY.register(bus);
		GoodblockModParticleTypes.REGISTRY.register(bus);


		GoodblockModMobEffects.REGISTRY.register(bus);
		//latex java register

		
		GoodblockModTransfurVariants.REGISTRY.register(bus);

	}

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}
}
