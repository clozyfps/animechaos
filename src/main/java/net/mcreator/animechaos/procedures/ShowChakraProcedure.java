package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ShowChakraProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("###,###,###").format((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalPlayerEnergy) + "/"
				+ new java.text.DecimalFormat("###,###,###").format((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalMaxPlayerEnergy);
	}
}
