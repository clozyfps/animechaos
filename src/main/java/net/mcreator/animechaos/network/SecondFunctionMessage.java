
package net.mcreator.animechaos.network;

import net.mcreator.animechaos.AnimeChaosMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SecondFunctionMessage {

	int type, pressedms;

	public SecondFunctionMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public SecondFunctionMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(SecondFunctionMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(SecondFunctionMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;

		if (type == 0) {

			ActivateSecondFunctionProcedure.execute(entity);
		}

		if (type == 1) {

			DeactivateSecondFunctionProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AnimeChaosMod.addNetworkMessage(SecondFunctionMessage.class, SecondFunctionMessage::buffer, SecondFunctionMessage::new, SecondFunctionMessage::handler);
	}

}
