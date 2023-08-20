package net.mcreator.animechaos.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

public class MKspecieconfirmProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal(("Your Name is " + ((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).PlayerFirstName + ""
					+ (" and your Species is " + (entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).Species)))), false);
	}
}
