package net.mcreator.animechaos.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

public class LatomResetProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		{
			boolean _setval = false;
			sourceentity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SaidLatom = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		if (sourceentity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("\u00A76\u00A7lL\u00E1tom"), true);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
	}
}
