package net.foxyas.changedaddon.init;

import net.foxyas.changedaddon.advancements.critereon.GrabEntityTrigger;
import net.foxyas.changedaddon.advancements.critereon.LavaSwimmingTrigger;
import net.foxyas.changedaddon.advancements.critereon.PatEntityTrigger;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.advancements.CriteriaTriggers.register;

@Mod.EventBusSubscriber
public class ChangedAddonCriteriaTriggers {

    public static final PatEntityTrigger PAT_ENTITY_TRIGGER = register(new PatEntityTrigger());
    public static final GrabEntityTrigger GRAB_ENTITY_TRIGGER = register(new GrabEntityTrigger());
    public static final LavaSwimmingTrigger LAVA_SWIMMING_TRIGGER = register(new LavaSwimmingTrigger());

}
