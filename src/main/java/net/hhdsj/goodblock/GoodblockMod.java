
package net.hhdsj.goodblock;

import net.hhdsj.goodblock.init.*;
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

//java add
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;

// Enchant imports


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

		GoodblockModEnchantmentInit.ENCHANTMENTS.register(bus);

		GoodblockModBlocks.REGISTRY.register(bus);

		GoodblockModItems.REGISTRY.register(bus);

		GoodblockModEntities.REGISTRY.register(bus);

		GoodblockModFeatures.REGISTRY.register(bus);

		GoodblockModFluids.REGISTRY.register(bus);

		GoodblockModParticleTypes.REGISTRY.register(bus);

		GoodBlockModBiomes.BIOMES.register(bus);

		GoodblockModMobEffects.REGISTRY.register(bus);

        GoodblockModAbilities.REGISTRY.register(bus);

		GoodblockModTransfurVariants.REGISTRY.register(bus);


	}

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}
}
