/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.hhdsj.goodblock as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
 * 
faction(LatexType)- 指定玩家的对齐方式，默认值：。请参阅 LatexTypeLatexType.NEUTRAL
jumpStrength(float)- 乘以玩家的跳跃高度，默认值：1.0
breatheMode(BreatheMode)/gills()- 指定玩家的呼吸方式。请参阅 BreatheMode
reducedFall()- 玩家受到的掉落伤害会减少
canClimb()- 玩家可以爬墙，无视蜘蛛网
scares(Class<E>)- 添加到玩家吓跑的实体列表中
stepSize(float)- 玩家将跨步多少个物块，默认值：0.6
glide()- 玩家有翅膀，可以创造性地飞行（削弱），并且可以坠落飞行（鞘翅）
extraJumps(int)/doubleJump()- 玩家可以在半空中跳跃的次数，默认值：0
transfurMode(TransfurMode)/absorbing()/replicating()- 玩家如何转毛其他实体。请参见 TransfurMode
visionType(VisionType)/nightVision()- 玩家如何看到，参见 VisionType
noLegs()/quadrupedal()- 玩家可以穿什么样的盔甲。参见盔甲类型
itemuseMode(UseItemMode)/disableItems()/holdItemsInMouth()- 玩家如何与他们的物品互动。请参阅 UseItemMode
cameraZOffset(float)- 玩家的相机与中心偏移的距离，默认值：0.0
sound(ResourceLocation)- 当它们被 transfurred 时播放什么声音，默认：“changed：poison”
addAbility(Supplier<AbstractAbility>)- 添加玩家可以使用的能力。参见 AbstractAbility
*/

package net.hhdsj.goodblock;

import net.ltxprogrammer.changed.Changed;
/*
import net.ltxprogrammer.changed.registry.ChangedRegistry;
import net.ltxprogrammer.changed.variant.TransfurVariant;
import net.ltxprogrammer.changed.variant.TransfurVariant.Builder;
import net.ltxprogrammer.changed.entity.ChangedEntities;
import net.ltxprogrammer.changed.faction.LatexType;
import net.ltxprogrammer.changed.entity.ExampleEntity;
import net.ltxprogrammer.changed.ability.ExampleAbility;

public class Latex {
    public static void main(String[] args) {

        TransfurVariant.Builder.of(ChangedEntities.LATEX_RED_DRAGON)
//            .stepSize(0.8f)
            .glide()
//            .addAbility(() -> new ExampleAbility())
            .build();
            
        ChangedRegistry.TRANSFUR_VARIANT.createDeferred("goodblocks")
            .register(variant);
    }
}
*/