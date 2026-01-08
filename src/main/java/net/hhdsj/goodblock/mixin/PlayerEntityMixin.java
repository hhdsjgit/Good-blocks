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
public abstract class PlayerEntityMixin {
    private static final Logger LOGGER = LogManager.getLogger("goodblock");
    
    @Shadow
    public abstract boolean isJumping();
    
    @Shadow
    public abstract boolean isCreative();
    
    // Shadow the onGround field to access it
    @Shadow
    public boolean onGround;
    
    /**
     * Called every tick to enhance creative mode jump height
     */
    @Inject(method = "tick()V", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        Player player = (Player)(Object)this;
        
        // Debug information (optional)
        // LOGGER.debug("Player tick: {}", player.getName().getString());
        
        // Only apply jump boost in creative mode while jumping
        if (isCreative() && isJumping()) {
            Vec3 velocity = player.getDeltaMovement();
            
            // Enhance jump only when airborne
            if (!this.onGround && velocity.y > 0) {
                // Increase jump height (10x multiplier - note: this is very high!)
                double newYVelocity = velocity.y * 10;
                
                // Limit maximum vertical velocity
                if (newYVelocity < 5.0) {
                    player.setDeltaMovement(velocity.x, newYVelocity, velocity.z);
                    LOGGER.debug("Player {} received jump boost", player.getName().getString());
                }
            }
        }
    }
    
    /**
     * Called when the player initiates a jump from the ground
     */
    @Inject(method = "jumpFromGround()V", at = @At("HEAD"))
    private void onJumpFromGround(CallbackInfo ci) {
        Player player = (Player)(Object)this;
        if (isCreative()) {
            LOGGER.debug("Player {} started jumping", player.getName().getString());
        }
    }
}