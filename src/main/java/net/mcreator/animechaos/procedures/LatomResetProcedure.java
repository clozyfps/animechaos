package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class LatomResetProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity sourceentity
) {
if(
sourceentity == null
) return ;
if (==true) {if (sourceentity instanceof Player _player && !_player.level.isClientSide())
_player.displayClientMessage(Component.literal("\u00A76\u00A7lL\u00E1tom"), true);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")),
SoundSource.PLAYERS, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")),
SoundSource.PLAYERS, 1, 1, false);
}
}if (world instanceof ServerLevel _level)
_level.getServer().getCommands().performPrefixedCommand(
new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO,
_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "particle minecraft:smoke ~ ~ ~ 0 0.5 0 0.1 100");}
}
}
