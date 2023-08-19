package net.mcreator.animechaos.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

public class SelectGen1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
		{
			double _setval = 1;
			entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.FireForceGen = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = "Infernal";
			entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Pyrokinesis = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("You are now Generation 1..."), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("You have the Ability to \u00A76\u00A7lInfernalize"), false);
	}
}
