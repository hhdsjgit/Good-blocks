package net.hhdsj.goodblock.procedures;

import net.minecraft.client.gui.components.EditBox;

import net.hhdsj.goodblock.network.GoodblockModVariables;

import java.util.HashMap;

public class CatalyzerguiZhiShuZhiProcedure {
	public static void execute(HashMap guistate) {
		if (guistate == null)
			return;
		if (guistate.get("text:label_empty") instanceof EditBox _tf)
			_tf.setValue(("time:" + GoodblockModVariables._Progress));
	}
}
