package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ShowDojutsuAbility1TextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String TheAbility = "";
		if ((((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).LeftDojutsu).equals("\"Sharingan\"")
				|| ((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).RightDojutsu).equals("\"Sharingan\""))
				&& (2 >= (entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).LeftSharinganLevel
						|| 2 >= (entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).RightSharinganLevel)) {
			TheAbility = "1: Sharingan - Genjutsu";
		} else {
			TheAbility = "1: ";
		}
		return TheAbility;
	}
}
