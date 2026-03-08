package net.hhdsj.goodblock.mixin;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class TestMixin {

    @Inject(method = "die", at = @At("HEAD"))
    private void onPlayerDie(CallbackInfo ci) {
        //System.out.println("Mixin Successfully executed");
    }
}