package net.mcreator.animechaos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.animechaos.network.AnimeChaosModVariables;
import net.mcreator.animechaos.AnimeChaosMod;

public class InfernalLatomProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((sourceentity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).SaidLatom == true) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("You've already said your prayer."), true);
		}
		if ((sourceentity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).SaidLatom == false) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7f\u00A7oThe flame is the soul\u2019s breath"), true);
			AnimeChaosMod.queueServerWork(30, () -> {
				if (sourceentity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7f\u00A7oThe black smoke is the soul\u2019s release"), true);
				AnimeChaosMod.queueServerWork(30, () -> {
					if (sourceentity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7f\u00A7oAshes thou wert and art"), true);
					AnimeChaosMod.queueServerWork(30, () -> {
						if (sourceentity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7oMay thy soul return to the great flame of fire..."), true);
						{
							boolean _setval = true;
							sourceentity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaidLatom = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					});
				});
			});
		}
	}
}
