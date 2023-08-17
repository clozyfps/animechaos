package net.mcreator.animechaos.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.animechaos.AnimeChaosMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AnimeChaosModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		AnimeChaosMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.LeftSharinganXP = original.LeftSharinganXP;
			clone.LeftSharinganLevel = original.LeftSharinganLevel;
			clone.Clan = original.Clan;
			clone.Anime = original.Anime;
			clone.LeftDojutsu = original.LeftDojutsu;
			clone.RightDojutsu = original.RightDojutsu;
			clone.RightSharinganXP = original.RightSharinganXP;
			clone.RightSharinganLevel = original.RightSharinganLevel;
			if (!event.isWasDeath()) {
				clone.DojutsuIsActive = original.DojutsuIsActive;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("anime_chaos", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double LeftSharinganXP = 0;
		public double LeftSharinganLevel = 1.0;
		public String Clan = "\"Uchiha\"";
		public String Anime = "\"Naruto\"";
		public String LeftDojutsu = "\"\"";
		public String RightDojutsu = "\"\"";
		public double RightSharinganXP = 0;
		public double RightSharinganLevel = 1.0;
		public boolean DojutsuIsActive = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				AnimeChaosMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("LeftSharinganXP", LeftSharinganXP);
			nbt.putDouble("LeftSharinganLevel", LeftSharinganLevel);
			nbt.putString("Clan", Clan);
			nbt.putString("Anime", Anime);
			nbt.putString("LeftDojutsu", LeftDojutsu);
			nbt.putString("RightDojutsu", RightDojutsu);
			nbt.putDouble("RightSharinganXP", RightSharinganXP);
			nbt.putDouble("RightSharinganLevel", RightSharinganLevel);
			nbt.putBoolean("DojutsuIsActive", DojutsuIsActive);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			LeftSharinganXP = nbt.getDouble("LeftSharinganXP");
			LeftSharinganLevel = nbt.getDouble("LeftSharinganLevel");
			Clan = nbt.getString("Clan");
			Anime = nbt.getString("Anime");
			LeftDojutsu = nbt.getString("LeftDojutsu");
			RightDojutsu = nbt.getString("RightDojutsu");
			RightSharinganXP = nbt.getDouble("RightSharinganXP");
			RightSharinganLevel = nbt.getDouble("RightSharinganLevel");
			DojutsuIsActive = nbt.getBoolean("DojutsuIsActive");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.LeftSharinganXP = message.data.LeftSharinganXP;
					variables.LeftSharinganLevel = message.data.LeftSharinganLevel;
					variables.Clan = message.data.Clan;
					variables.Anime = message.data.Anime;
					variables.LeftDojutsu = message.data.LeftDojutsu;
					variables.RightDojutsu = message.data.RightDojutsu;
					variables.RightSharinganXP = message.data.RightSharinganXP;
					variables.RightSharinganLevel = message.data.RightSharinganLevel;
					variables.DojutsuIsActive = message.data.DojutsuIsActive;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
