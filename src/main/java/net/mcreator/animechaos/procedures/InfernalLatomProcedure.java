package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class InfernalLatomProcedure {
public static void execute(
LevelAccessor world,
Entity sourceentity
) {
if(
sourceentity == null
) return ;
if (==true) {if (sourceentity instanceof Player _player && !_player.level.isClientSide())
_player.displayClientMessage(Component.literal("You've already said your prayer."), true);}if (==false) {if (sourceentity instanceof Player _player && !_player.level.isClientSide())
_player.displayClientMessage(Component.literal("\u00A7f\u00A7oThe flame is the soul\u2019s breath"), true);AnimeChaosMod.queueServerWork(30, () -> {
if (sourceentity instanceof Player _player && !_player.level.isClientSide())
_player.displayClientMessage(Component.literal("\u00A7f\u00A7oThe black smoke is the soul\u2019s release"), true);AnimeChaosMod.queueServerWork(30, () -> {
if (sourceentity instanceof Player _player && !_player.level.isClientSide())
_player.displayClientMessage(Component.literal("\u00A7f\u00A7oAshes thou wert and art"), true);AnimeChaosMod.queueServerWork(30, () -> {
if (sourceentity instanceof Player _player && !_player.level.isClientSide())
_player.displayClientMessage(Component.literal("\u00A7f\u00A7oMay thy soul return to the great flame of fire..."), true);
});
});
});
}
}
}
