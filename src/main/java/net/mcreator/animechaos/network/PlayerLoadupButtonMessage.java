
package net.mcreator.animechaos.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.animechaos.world.inventory.PlayerLoadupMenu;
import net.mcreator.animechaos.procedures.PlayerFirstNameProcedure;
import net.mcreator.animechaos.procedures.AnimeSelectForwardProcedure;
import net.mcreator.animechaos.procedures.AnimeSelectBackwardsProcedure;
import net.mcreator.animechaos.AnimeChaosMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlayerLoadupButtonMessage {
	private final int buttonID, x, y, z;

	public PlayerLoadupButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public PlayerLoadupButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(PlayerLoadupButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(PlayerLoadupButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = PlayerLoadupMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			AnimeSelectForwardProcedure.execute(entity);
		}
		if (buttonID == 1) {

			AnimeSelectBackwardsProcedure.execute(entity);
		}
		if (buttonID == 2) {

			PlayerFirstNameProcedure.execute(entity, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AnimeChaosMod.addNetworkMessage(PlayerLoadupButtonMessage.class, PlayerLoadupButtonMessage::buffer, PlayerLoadupButtonMessage::new, PlayerLoadupButtonMessage::handler);
	}
}
