package net.hhdsj.goodblock.init;
/**

import net.ltxprogrammer.changed.ability.*;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.core.particles.ParticleTypes;

public class DragonBreathAbility extends AbstractAbility {
    public DragonBreathAbility() {
        super(UseType.CHARGE_RELEASE, 60); // 充能释放型，冷却60ticks
    }

    public static class DragonBreathInstance extends AbstractAbilityInstance {
        private int chargeTicks = 0;

        public DragonBreathInstance(AbstractAbility ability, IAbstractChangedEntity entity) {
            super(ability, entity);
        }

        @Override
        public void tickCharge() {
            chargeTicks++;
            // 充能粒子效果
            entity.getLevel().addParticle(ParticleTypes.FLAME, 
                entity.getX(), entity.getY() + 1.5, entity.getZ(), 
                0, 0.1, 0);
        }

        @Override
        public void onStop() {
            if (chargeTicks < 20) return; // 至少充能20ticks

            // 发射火球
            DragonFireball fireball = new DragonFireball(
                entity.getLevel(), entity, 
                entity.getLookAngle().x, 
                entity.getLookAngle().y, 
                entity.getLookAngle().z);
            fireball.setPos(entity.getX(), entity.getY() + 1.5, entity.getZ());
            entity.getLevel().addFreshEntity(fireball);
        }
    }
}*/