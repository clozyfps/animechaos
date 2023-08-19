package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class DoOpenStatMenuProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity
) {
if(
entity == null
) return ;
if ((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeChaosModVariables.PlayerVariables())).holdingSecondFunction==false) {if(entity instanceof Player _player) _player.closeContainer();{
if(entity instanceof ServerPlayer _ent) {
BlockPos _bpos = new BlockPos(x,y,z);
NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
@Override public Component getDisplayName() {
return Component.literal("StatScreen");
}
@Override public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
return new StatScreenMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
}
}, _bpos);
}
}
}else if ((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeChaosModVariables.PlayerVariables())).holdingSecondFunction==true) {if (==true) {if (entity instanceof Player _player && !_player.level.isClientSide())
_player.displayClientMessage(Component.literal("Chakra Control Off"), true);}else if (==false) {if (entity instanceof Player _player && !_player.level.isClientSide())
_player.displayClientMessage(Component.literal("Chakra Control On"), true);}}
}
}
