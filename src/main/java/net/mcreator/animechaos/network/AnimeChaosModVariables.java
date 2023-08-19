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
			clone.GlobalMaxPlayerEnergy = original.GlobalMaxPlayerEnergy;
			clone.Ninjutsu = original.Ninjutsu;
			clone.ChakraControl = original.ChakraControl;
			clone.GlobalPlayerEnergy = original.GlobalPlayerEnergy;
			clone.NinjaXP = original.NinjaXP;
			clone.NunjaXPRequired = original.NunjaXPRequired;
			clone.GlobalMaxPlayerHealth = original.GlobalMaxPlayerHealth;
			clone.NinjaLevel = original.NinjaLevel;
			clone.NarutoIterator = original.NarutoIterator;
			clone.StatXP = original.StatXP;
			clone.GlobalPlayerHealth = original.GlobalPlayerHealth;
			clone.JutsuXP = original.JutsuXP;
			if (!event.isWasDeath()) {
				clone.DojutsuIsActive = original.DojutsuIsActive;
				clone.holdingSecondFunction = original.holdingSecondFunction;
				clone.SaidLatom = original.SaidLatom;
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
		public String Clan = "none";
		public String Anime = "none";
		public String LeftDojutsu = "\"Sharingan\"";
		public String RightDojutsu = "\"Sharingan\"";
		public double RightSharinganXP = 0;
		public double RightSharinganLevel = 2.0;
		public boolean DojutsuIsActive = false;
		public boolean holdingSecondFunction = false;
		public double GlobalMaxPlayerEnergy = 0;
		public double Ninjutsu = 1.0;
		public boolean ChakraControl = false;
		public double GlobalPlayerEnergy = 0;
		public double NinjaXP = 0;
		public double NunjaXPRequired = 5.0;
		public double GlobalMaxPlayerHealth = 0;
		public double NinjaLevel = 0;
		public double NarutoIterator = 0;
		public double StatXP = 0;
		public double GlobalPlayerHealth = 0;
		public double JutsuXP = 0;
		public boolean SaidLatom = false;

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
			nbt.putBoolean("holdingSecondFunction", holdingSecondFunction);
			nbt.putDouble("GlobalMaxPlayerEnergy", GlobalMaxPlayerEnergy);
			nbt.putDouble("Ninjutsu", Ninjutsu);
			nbt.putBoolean("ChakraControl", ChakraControl);
			nbt.putDouble("GlobalPlayerEnergy", GlobalPlayerEnergy);
			nbt.putDouble("NinjaXP", NinjaXP);
			nbt.putDouble("NunjaXPRequired", NunjaXPRequired);
			nbt.putDouble("GlobalMaxPlayerHealth", GlobalMaxPlayerHealth);
			nbt.putDouble("NinjaLevel", NinjaLevel);
			nbt.putDouble("NarutoIterator", NarutoIterator);
			nbt.putDouble("StatXP", StatXP);
			nbt.putDouble("GlobalPlayerHealth", GlobalPlayerHealth);
			nbt.putDouble("JutsuXP", JutsuXP);
			nbt.putBoolean("SaidLatom", SaidLatom);
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
			holdingSecondFunction = nbt.getBoolean("holdingSecondFunction");
			GlobalMaxPlayerEnergy = nbt.getDouble("GlobalMaxPlayerEnergy");
			Ninjutsu = nbt.getDouble("Ninjutsu");
			ChakraControl = nbt.getBoolean("ChakraControl");
			GlobalPlayerEnergy = nbt.getDouble("GlobalPlayerEnergy");
			NinjaXP = nbt.getDouble("NinjaXP");
			NunjaXPRequired = nbt.getDouble("NunjaXPRequired");
			GlobalMaxPlayerHealth = nbt.getDouble("GlobalMaxPlayerHealth");
			NinjaLevel = nbt.getDouble("NinjaLevel");
			NarutoIterator = nbt.getDouble("NarutoIterator");
			StatXP = nbt.getDouble("StatXP");
			GlobalPlayerHealth = nbt.getDouble("GlobalPlayerHealth");
			JutsuXP = nbt.getDouble("JutsuXP");
			SaidLatom = nbt.getBoolean("SaidLatom");
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
					variables.holdingSecondFunction = message.data.holdingSecondFunction;
					variables.GlobalMaxPlayerEnergy = message.data.GlobalMaxPlayerEnergy;
					variables.Ninjutsu = message.data.Ninjutsu;
					variables.ChakraControl = message.data.ChakraControl;
					variables.GlobalPlayerEnergy = message.data.GlobalPlayerEnergy;
					variables.NinjaXP = message.data.NinjaXP;
					variables.NunjaXPRequired = message.data.NunjaXPRequired;
					variables.GlobalMaxPlayerHealth = message.data.GlobalMaxPlayerHealth;
					variables.NinjaLevel = message.data.NinjaLevel;
					variables.NarutoIterator = message.data.NarutoIterator;
					variables.StatXP = message.data.StatXP;
					variables.GlobalPlayerHealth = message.data.GlobalPlayerHealth;
					variables.JutsuXP = message.data.JutsuXP;
					variables.SaidLatom = message.data.SaidLatom;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
