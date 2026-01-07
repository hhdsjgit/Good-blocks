package net.hhdsj.goodblock.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mixin(Player.class)
public abstract class PlayerEntityMixin {  // 添加 abstract 关键字
    private static final Logger LOGGER = LogManager.getLogger("goodblock");
    
    @Shadow
    public abstract boolean isJumping();
    
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        Player player = (Player)(Object)this;
        
        if (player.isCreative() && isJumping()) {
            Vec3 velocity = player.getDeltaMovement();
            player.setDeltaMovement(velocity.x, velocity.y * 1.5, velocity.z);
            LOGGER.debug("玩家 {} 跳跃增强", player.getName().getString());
        }
    }
}