package net.hhdsj.goodblock.entity;

// net/hhdsj/goodblock/entity/TestEntity.java
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.LatexType;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.ltxprogrammer.changed.util.Color3;

public class TestEntity extends ChangedEntity {
    public TestEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    @Override
    public LatexType getLatexType() {
        return LatexType.NEUTRAL;
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.REPLICATION;
    }
    /*
    @Override
    public Color3 getDripColor() {
        return Color3.getColor("#FFFFFF"); // 使用适合的颜色
    }*/

}