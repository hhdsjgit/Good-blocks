package net.hhdsj.goodblock.procedures;

import net.hhdsj.goodblock.network.GoodblockModVariables;

public class CatalyzerGengXinYouXiKeProcedure {
	public static void execute() {
		if (GoodblockModVariables._Progress >= 100) {
			GoodblockModVariables._Progress = 0;
		} else {
			GoodblockModVariables._Progress = GoodblockModVariables._Progress + 1;
		}
	}
}
