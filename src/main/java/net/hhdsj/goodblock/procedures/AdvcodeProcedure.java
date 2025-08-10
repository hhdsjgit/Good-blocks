package net.hhdsj.goodblock.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.hhdsj.goodblock.network.GoodblockModVariables;

import javax.annotation.Nullable;

import java.util.Iterator;

@Mod.EventBusSubscriber
public class AdvcodeProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getPlayer());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(GoodblockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GoodblockModVariables.PlayerVariables())).Player_die + 1;
			entity.getCapability(GoodblockModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Player_die = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(GoodblockModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GoodblockModVariables.PlayerVariables())).Player_die >= 20) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("goodblock:gha_13"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemainingCriteria().iterator();
					while (_iterator.hasNext())
						_player.getAdvancements().award(_adv, (String) _iterator.next());
				}
			}
		}
	}
}
