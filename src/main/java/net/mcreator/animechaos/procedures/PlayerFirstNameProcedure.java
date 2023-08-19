package net.mcreator.animechaos.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

import java.util.HashMap;

public class PlayerFirstNameProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			String _setval = guistate.containsKey("text:FirstName") ? ((EditBox) guistate.get("text:FirstName")).getValue() : "";
			entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerFirstName = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
