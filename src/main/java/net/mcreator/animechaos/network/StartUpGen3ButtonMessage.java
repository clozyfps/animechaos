
package net.mcreator.animechaos.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.animechaos.world.inventory.StartUpGen3Menu;
import net.mcreator.animechaos.procedures.SelectGen3Procedure;
import net.mcreator.animechaos.procedures.NextGen2Procedure;
import net.mcreator.animechaos.procedures.NextGen1Procedure;
import net.mcreator.animechaos.AnimeChaosMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StartUpGen3ButtonMessage {
	private final int buttonID, x, y, z;

	public StartUpGen3ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public StartUpGen3ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(StartUpGen3ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(StartUpGen3ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = StartUpGen3Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SelectGen3Procedure.execute(entity);
		}
		if (buttonID == 1) {

			NextGen1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			NextGen2Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AnimeChaosMod.addNetworkMessage(StartUpGen3ButtonMessage.class, StartUpGen3ButtonMessage::buffer, StartUpGen3ButtonMessage::new, StartUpGen3ButtonMessage::handler);
	}
}
