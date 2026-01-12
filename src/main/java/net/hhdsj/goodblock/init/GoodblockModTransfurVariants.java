package net.hhdsj.goodblock.init;

import net.minecraft.world.entity.monster.*;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import net.ltxprogrammer.changed.*;
import net.ltxprogrammer.changed.ability.*;
import net.ltxprogrammer.changed.entity.*;
import net.ltxprogrammer.changed.init.*;
import net.ltxprogrammer.changed.entity.variant.*;

import net.foxyas.changedaddon.init.ChangedAddonAbilities;

import net.hhdsj.goodblock.entity.*;//推荐不要用*(来自hhdsj的话=))
import net.hhdsj.goodblock.registers.GoodblockEntities;

public class GoodblockModTransfurVariants {
    public static final DeferredRegister<TransfurVariant<?>> REGISTRY = ChangedRegistry.TRANSFUR_VARIANT.createDeferred("goodblock");

    

	/* Test latex
    public static final RegistryObject<TransfurVariant<LatexfoxEntity>> LATEXFOX = REGISTRY.register("form_latex_fox",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXFOX)
	    .stepSize(0.7f)
	    .build());
	*/

    public static final RegistryObject<TransfurVariant<LatexOrangeFoxEntity>> LATEX_ORANGE_FOX = REGISTRY.register("form_orange_fox",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_ORANGE_FOX)
	    .stepSize(0.7f)
	    .nightVision()
	    .transfurMode(TransfurMode.ABSORPTION)
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .build());

	public static final RegistryObject<TransfurVariant<LatexKcahraSharkEntity>> LATEX_KCAHRA_SHARK = REGISTRY.register("form_latex_kcahra_shark",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_KCAHRA_SHARK)
	    .stepSize(0.7f)
	    .gills()
	    .breatheMode(TransfurVariant.BreatheMode.ANY)
	    .transfurMode(TransfurMode.ABSORPTION)
	    .replicating()
	    .build());

	public static final RegistryObject<TransfurVariant<LatexbluedragonEntity>> LATEXBLUEDRAGON = REGISTRY.register("form_blue_dragon",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXBLUEDRAGON)
	    .stepSize(0.7f)
	    .glide()
	    .addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
	    //.breatheMode(TransfurVariant.BreatheMode.NORMAL)
	    //.addAbility(() -> ChangedAbilities.SWITCH_TRANSFUR_MODE.get())
	    .transfurMode(TransfurMode.ABSORPTION)
	    .replicating()
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .build());

	public static final RegistryObject<TransfurVariant<DarkfuLatexWolfMaleEntity>> DARKFU_LATEX_WOLF_MALE = REGISTRY.register("form_darkfu_latex_wolf_male",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.DARKFU_LATEX_WOLF_MALE)
	    .stepSize(0.7f)
	    .faction(LatexType.DARK_LATEX)
	    .breatheMode(TransfurVariant.BreatheMode.NORMAL)
	    .transfurMode(TransfurMode.ABSORPTION)
	    //.addAbility(() -> ChangedAbilities.SWITCH_TRANSFUR_MODE.get())
	    .replicating()
	    .build());

	public static final RegistryObject<TransfurVariant<LatexiceDragonEntity>> LATEXICE_DRAGON = REGISTRY.register("form_latex_ice_dragon",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXICE_DRAGON)
	    .stepSize(0.7f)
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    //.addAbility(() -> ChangedAbilities.SWITCH_TRANSFUR_MODE.get())
	    .replicating()
	    .build());

	public static final RegistryObject<TransfurVariant<InksugerEntity>> INKSUGER = REGISTRY.register("form_ink_suger",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.INKSUGER)
	    .stepSize(0.7f)
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .transfurMode(TransfurMode.ABSORPTION)
	    .holdItemsInMouth()
	    .reducedFall()
	    .build());
	
	public static final RegistryObject<TransfurVariant<LatexkamonaHSguydragonwolfEntity>> LATEX_KAMONA_HSGUY_DRAGON_WOLF = REGISTRY.register("form_latex_kamona_hsguy_dragon_wolf",
    () -> TransfurVariant.Builder.of(GoodblockEntities.LATEX_KAMONA_HSGUY_DRAGON_WOLF)
	    .stepSize(0.7f)
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .transfurMode(TransfurMode.ABSORPTION)
	    .replicating()
	    .build());	

	public static final RegistryObject<TransfurVariant<BlackpupmaleEntity>> BLACKPUPMALE = REGISTRY.register("form_black_pup",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.BLACKPUPMALE)
	    .stepSize(0.7f)
	    .nightVision()
	    .transfurMode(TransfurMode.NONE)
	    .holdItemsInMouth()
	    .reducedFall()
	    .build());

	public static final RegistryObject<TransfurVariant<WhitebluepupEntity>> WHITEBLUEPUP = REGISTRY.register("form_white_blue_pup",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.WHITEBLUEPUP)
	    .stepSize(0.7f)
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .holdItemsInMouth()
	    .reducedFall()
	    .build());

	public static final RegistryObject<TransfurVariant<LatexpurplewswolfEntity>> LATEXPURPLEWSWOLF = REGISTRY.register("form_latex_purplews_wolf",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXPURPLEWSWOLF)
	    .stepSize(0.7f)
		.breatheMode(TransfurVariant.BreatheMode.WEAK)
		.reducedFall()
		.scares(Creeper.class)
		.nightVision()
		.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
		.jumpStrength(2f)
	    .build());
	
	public static final RegistryObject<TransfurVariant<LatexthreemonthwolfEntity>> LATEXTHREEMONTHWOLF = REGISTRY.register("form_latex_three_month_wolf",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXTHREEMONTHWOLF)
	    .stepSize(0.7f)
		.breatheMode(TransfurVariant.BreatheMode.WEAK)
		.reducedFall()
		.scares(Creeper.class)
		.nightVision()
		.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
		.jumpStrength(2f)
	    .build());

	public static final RegistryObject<TransfurVariant<LatexyunxqhotdragonEntity>> LATEXYUNXQHOTDRAGON = REGISTRY.register("form_latex_yunxq_hot_dragon",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXYUNXQHOTDRAGON)
	    .stepSize(0.7f)
	    .glide()
	    .addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
	    .transfurMode(TransfurMode.ABSORPTION)
	    .replicating()
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .build());

	public static final RegistryObject<TransfurVariant<LatexyunxqicedragonEntity>> LATEXYUNXQICEDRAGON = REGISTRY.register("form_latex_yun_xq_ice_dragon",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXYUNXQICEDRAGON)
	    .stepSize(0.7f)
	    .glide()
	    .addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
	    .transfurMode(TransfurMode.ABSORPTION)
	    .replicating()
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .build());

	public static final RegistryObject<TransfurVariant<LatexPurplecoocwolfEntity>> LATEXPRTPLECOOCWOLF = REGISTRY.register("form_latex_purple_cooc_wolf",
			() -> TransfurVariant.Builder.of(GoodblockEntities.LATEXPRTPLECOOCWOLF)
					.stepSize(0.7f)
					.glide()
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.build());

	//火龙果狼>?
	public static final RegistryObject<TransfurVariant<LatexDragonFruitWolfEntity>> LATEXDRAGONFRUITWOLF = REGISTRY.register("form_latex_dragon_fruit_wolf",
	() -> TransfurVariant.Builder.of(GoodblockEntities.LATEXDRAGONFRUITWOLF)
			.stepSize(0.7f)
			.glide()
			.addAbility(entityType -> GoodblockModAbilities.CREATE_DRAGON_FRUIT.get())
			.transfurMode(TransfurMode.ABSORPTION)
			.replicating()
			.nightVision()
			.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
			.build());
	    
	public static void register(IEventBus bus) {
        REGISTRY.register(bus);
    }


}












