/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;
//原版我的世界导入
import net.hhdsj.goodblock.entity.boss.LatexNightOwlEntity;
import net.hhdsj.goodblock.entity.simple.LatexIqGoldDragonEntity;
import net.minecraft.world.entity.monster.*;
//FORGE导入
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
//changed-mc mod导入
import net.ltxprogrammer.changed.entity.*;
import net.ltxprogrammer.changed.init.*;
import net.ltxprogrammer.changed.entity.variant.*;

import net.foxyas.changedaddon.init.ChangedAddonAbilities;

import net.hhdsj.goodblock.entity.*;//推荐不要用*(来自hhdsj的话=))
import net.hhdsj.goodblock.init.GoodblockModEntities;

import java.util.List;

public class GoodblockModTransfurVariants {
    public static final DeferredRegister<TransfurVariant<?>> REGISTRY = ChangedRegistry.TRANSFUR_VARIANT.createDeferred("goodblock");
	
    public static final RegistryObject<TransfurVariant<LatexOrangeFoxEntity>> LATEX_ORANGE_FOX = 
			REGISTRY.register("form_orange_fox", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_ORANGE_FOX)
			.stepSize(0.7f)
			.nightVision()
			.transfurMode(TransfurMode.ABSORPTION)
			.addAbility(ChangedAddonAbilities.CLAWS)
			.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
			.build());

	public static final RegistryObject<TransfurVariant<LatexKcahraSharkEntity>> LATEX_KCAHRA_SHARK = 
			REGISTRY.register("form_latex_kcahra_shark", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_KCAHRA_SHARK)
			.stepSize(0.7f)
			.gills()
			.breatheMode(TransfurVariant.BreatheMode.ANY)
			.transfurMode(TransfurMode.ABSORPTION)
			.replicating()
			.build());

	public static final RegistryObject<TransfurVariant<LatexbluedragonEntity>> LATEXBLUEDRAGON = 
			REGISTRY.register("form_blue_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXBLUEDRAGON)
			.stepSize(0.7f)
			.glide()
			.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
			.transfurMode(TransfurMode.ABSORPTION)
			.replicating()
			.nightVision()
			.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
			.build());

	public static final RegistryObject<TransfurVariant<DarkfuLatexWolfMaleEntity>> DARKFU_LATEX_WOLF_MALE = 
			REGISTRY.register("form_darkfu_latex_wolf_male", () -> TransfurVariant.Builder.of(GoodblockModEntities.DARKFU_LATEX_WOLF_MALE)
			.stepSize(0.7f)
			.faction(LatexType.DARK_LATEX)
			.breatheMode(TransfurVariant.BreatheMode.NORMAL)
			.transfurMode(TransfurMode.ABSORPTION)
			.replicating()
			.build());

	public static final RegistryObject<TransfurVariant<LatexiceDragonEntity>> LATEXICE_DRAGON = 
			REGISTRY.register("form_latex_ice_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXICE_DRAGON)
			.stepSize(0.7f)
			.nightVision()
			.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
			.replicating()
			.build());

	public static final RegistryObject<TransfurVariant<InksugerEntity>> INKSUGER = 
			REGISTRY.register("form_ink_suger", () -> TransfurVariant.Builder.of(GoodblockModEntities.INKSUGER)
			.stepSize(0.7f)
			.nightVision()
			.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
			.transfurMode(TransfurMode.ABSORPTION)
			.holdItemsInMouth()
			.reducedFall()
			.build());
	
	public static final RegistryObject<TransfurVariant<LatexIceFieldWolfDragonEntity>> LATEX_KAMONA_HSGUY_DRAGON_WOLF = 
			REGISTRY.register("form_latex_ice_field_wolf_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_ICE_FIELD_WOLF_DRAGON)
			.stepSize(0.7f)
			.nightVision()
			.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
			.addAbility(ChangedAddonAbilities.CLAWS)
			.transfurMode(TransfurMode.ABSORPTION)
			.replicating()
			.build());	

	public static final RegistryObject<TransfurVariant<BlackpupmaleEntity>> BLACKPUPMALE = 
			REGISTRY.register("form_black_pup", () -> TransfurVariant.Builder.of(GoodblockModEntities.BLACKPUPMALE)
			.stepSize(0.7f)
			.nightVision()
			.transfurMode(TransfurMode.NONE)
			.holdItemsInMouth()
			.reducedFall()
			.build());

	public static final RegistryObject<TransfurVariant<WhitebluepupEntity>> WHITEBLUEPUP = 
			REGISTRY.register("form_white_blue_pup", () -> TransfurVariant.Builder.of(GoodblockModEntities.WHITEBLUEPUP)
			.stepSize(0.7f)
			.nightVision()
			.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
			.holdItemsInMouth()
			.reducedFall()
			.build());

	public static final RegistryObject<TransfurVariant<LatexpurplewswolfEntity>> LATEXPURPLEWSWOLF = 
			REGISTRY.register("form_latex_purplews_wolf", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXPURPLEWSWOLF)
			.stepSize(0.7f)
			.breatheMode(TransfurVariant.BreatheMode.WEAK)
			.addAbility(ChangedAddonAbilities.CLAWS)
			.reducedFall()
			.scares(Creeper.class)
			.nightVision()
			.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
			.jumpStrength(2f)
			.build());
	
	public static final RegistryObject<TransfurVariant<LatexthreemonthwolfEntity>> LATEXTHREEMONTHWOLF = 
			REGISTRY.register("form_latex_three_month_wolf", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXTHREEMONTHWOLF)
			.stepSize(0.7f)
			.breatheMode(TransfurVariant.BreatheMode.WEAK)
			.addAbility(ChangedAddonAbilities.CLAWS)
			.reducedFall()
			.scares(Creeper.class)
			.nightVision()
			.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
			.jumpStrength(2f)
			.build());

	public static final RegistryObject<TransfurVariant<LatexyunxqhotdragonEntity>> LATEXYUNXQHOTDRAGON = 
			REGISTRY.register("form_latex_yunxq_hot_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXYUNXQHOTDRAGON)
			.stepSize(0.7f)
			.glide()
			.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
			.transfurMode(TransfurMode.ABSORPTION)
			.replicating()
			.nightVision()
			.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
			.build());

	public static final RegistryObject<TransfurVariant<LatexyunxqicedragonEntity>> LATEXYUNXQICEDRAGON = 
			REGISTRY.register("form_latex_yun_xq_ice_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXYUNXQICEDRAGON)
			.stepSize(0.7f)
			.glide()
			.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
			.transfurMode(TransfurMode.ABSORPTION)
			.replicating()
			.nightVision()
			.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
			.build());

	public static final RegistryObject<TransfurVariant<LatexPurplecoocwolfEntity>> LATEXPRTPLECOOCWOLF = 
			REGISTRY.register("form_latex_purple_cooc_wolf", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXPRTPLECOOCWOLF)
			.stepSize(0.7f)
			.transfurMode(TransfurMode.ABSORPTION)
			.replicating()
			.nightVision()
			.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
			.build());

	//火龙果狼>?
	public static final RegistryObject<TransfurVariant<LatexDragonFruitWolfEntity>> LATEXDRAGONFRUITWOLF =
			REGISTRY.register("form_latex_dragon_fruit_wolf", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXDRAGONFRUITWOLF)
				.stepSize(0.7f)
				.addAbility(entityType -> GoodblockModAbilities.CREATE_DRAGON_FRUIT.get())
				.transfurMode(TransfurMode.ABSORPTION)
				.replicating()
				.nightVision()
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.build());

	public static final RegistryObject<TransfurVariant<LatexYunQiIceDragonEntity>> LATEXYUNQIICEDRAGON =
			REGISTRY.register("form_latex_yun_qi_ice_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXYUNQIICEDRAGON)
					.stepSize(0.7f)
					.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
					.glide()
					.jumpStrength(1.1f)
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.build());

	public static final RegistryObject<TransfurVariant<LatexRadiationFoxEntity>> LATEXRADIATIONFOX =
			REGISTRY.register("form_latex_radiation_fox", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXRADIATIONFOX)
					.stepSize(0.7f)
					.glide()
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.build());

	public static final RegistryObject<TransfurVariant<LatexNightOwlEntity>> LATEXNIGHTOWL =
			REGISTRY.register("form_latex_night_owl_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXNIGHTOWLDRAGON)
					.stepSize(0.7f)
					.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
					.addAbility(ChangedAddonAbilities.CLAWS)
					.scares(List.of(Creeper.class))
					.glide()
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.jumpStrength(1.15f)
					.build());

    public static final RegistryObject<TransfurVariant<LatexIqGoldDragonEntity>> LATEXIQGOLDDRAGON =
            REGISTRY.register("form_latex_iq_gold_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXIQGOLDDRAGON)
                    .stepSize(0.7f)
                    .addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
                    .addAbility(ChangedAddonAbilities.CLAWS)
                    .scares(List.of(Creeper.class))
                    .glide()
                    .transfurMode(TransfurMode.ABSORPTION)
                    .replicating()
                    .nightVision()
                    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
                    .jumpStrength(1f)
                    .build());

	public static final RegistryObject<TransfurVariant<LatexDarkPurpleDragonTaurEntity>> LATEXDARKPURPLEDRAGONTAUR =
			REGISTRY.register("form_latex_dark_purple_dragon_taur", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXDARKPURPLEDRAGONTAUR)
					.stepSize(1.1f)
					//.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
					.addAbility(entityType -> GoodblockModAbilities.TURN_FERA_LATEX_DARK_PURPLE.get())
					.scares(List.of(Creeper.class))
					.replicating()
					.nightVision()
					.quadrupedal()
					.cameraZOffset(7.0f / 16.0f)
					.jumpStrength(1.25f)
					.rideable()
					.reducedFall()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.build());

	public static final RegistryObject<TransfurVariant<DarkPurpleLatexDragonEntity>> LATEXDARKPURPLEDRAGON =
			REGISTRY.register("form_latex_dark_purple_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXDARKPURPLEDRAGON)
					.stepSize(0.7f)
					.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
					.addAbility(entityType -> GoodblockModAbilities.TURN_FERA_LATEX_DARK_PURPLE.get())
					.addAbility(ChangedAddonAbilities.CLAWS)
					.scares(List.of(Creeper.class))
					.glide()
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.jumpStrength(1.25f)
					.build());

	//

	public static void register(IEventBus bus) {
        REGISTRY.register(bus);
    }


}












