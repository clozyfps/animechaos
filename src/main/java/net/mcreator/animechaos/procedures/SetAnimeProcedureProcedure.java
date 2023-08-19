package net.mcreator.animechaos.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class SetAnimeProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = (new Object() {
				public String getMessage() {
					try {
						return MessageArgument.getMessage(arguments, "AnimeName").getString();
					} catch (CommandSyntaxException ignored) {
						return "";
					}
				}
			}).getMessage();
			entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Anime = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("(!!!) Anime are CASE-SENSITIVE, make sure you enter correctly."), false);
		SetAnimeConfirmationProcedure.execute(entity);
	}
}
