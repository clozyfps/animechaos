package net.mcreator.animechaos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.animechaos.network.AnimeChaosModVariables;
import net.mcreator.animechaos.AnimeChaosMod;

public class MKfamilyconfirmProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal(("Your Name is " + ((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).PlayerFirstName + ""
					+ (" " + (entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).Family)))), false);
		AnimeChaosMod.queueServerWork(20, () -> {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(("Your Species: " + ((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).Species + "" + ("" + "")))),
						false);
		});
		AnimeChaosMod.queueServerWork(40, () -> {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(
						Component.literal(("Your Clan/Faction: " + ((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).Faction + "" + ("" + "")))), false);
		});
	}
}
