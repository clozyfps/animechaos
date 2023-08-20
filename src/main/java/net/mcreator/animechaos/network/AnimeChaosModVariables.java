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
			clone.Anime = original.Anime;
			clone.ChakraControl = original.ChakraControl;
			clone.Clan = original.Clan;
			clone.Family = original.Family;
			clone.FireForceGen = original.FireForceGen;
			clone.GlobalMaxPlayerEnergy = original.GlobalMaxPlayerEnergy;
			clone.GlobalMaxPlayerHealth = original.GlobalMaxPlayerHealth;
			clone.GlobalPlayerEnergy = original.GlobalPlayerEnergy;
			clone.GlobalPlayerHealth = original.GlobalPlayerHealth;
			clone.JoinedWorld = original.JoinedWorld;
			clone.JutsuXP = original.JutsuXP;
			clone.LeftDojutsu = original.LeftDojutsu;
			clone.LeftSharinganLevel = original.LeftSharinganLevel;
			clone.LeftSharinganXP = original.LeftSharinganXP;
			clone.NarutoIterator = original.NarutoIterator;
			clone.NinjaLevel = original.NinjaLevel;
			clone.NinjaXP = original.NinjaXP;
			clone.Ninjutsu = original.Ninjutsu;
			clone.NunjaXPRequired = original.NunjaXPRequired;
			clone.PlayerFirstName = original.PlayerFirstName;
			clone.Pyrokinesis = original.Pyrokinesis;
			clone.RightDojutsu = original.RightDojutsu;
			clone.RightSharinganLevel = original.RightSharinganLevel;
			clone.RightSharinganXP = original.RightSharinganXP;
			clone.Species = original.Species;
			clone.StatXP = original.StatXP;
			clone.Faction = original.Faction;
			if (!event.isWasDeath()) {
				clone.DojutsuIsActive = original.DojutsuIsActive;
				clone.holdingSecondFunction = original.holdingSecondFunction;
				clone.SaidLatom = original.SaidLatom;
				clone.SpeciesRealm = original.SpeciesRealm;
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
		public String Anime = "None";
		public boolean ChakraControl = false;
		public String Clan = "None";
		public boolean DojutsuIsActive = false;
		public String Family = "\"\"";
		public double FireForceGen = 0;
		public double GlobalMaxPlayerEnergy = 0;
		public double GlobalMaxPlayerHealth = 0;
		public double GlobalPlayerEnergy = 0;
		public double GlobalPlayerHealth = 0;
		public boolean holdingSecondFunction = false;
		public boolean JoinedWorld = false;
		public double JutsuXP = 0;
		public String LeftDojutsu = "\"Sharingan\"";
		public double LeftSharinganLevel = 1.0;
		public double LeftSharinganXP = 0;
		public double NarutoIterator = 0;
		public double NinjaLevel = 0;
		public double NinjaXP = 0;
		public double Ninjutsu = 1.0;
		public double NunjaXPRequired = 5.0;
		public String PlayerFirstName = "\"\"";
		public String Pyrokinesis = "\"\"";
		public String RightDojutsu = "\"Sharingan\"";
		public double RightSharinganLevel = 2.0;
		public double RightSharinganXP = 0;
		public boolean SaidLatom = false;
		public String Species = "None";
		public String SpeciesRealm = "None";
		public double StatXP = 0;
		public String Faction = "None";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				AnimeChaosMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("Anime", Anime);
			nbt.putBoolean("ChakraControl", ChakraControl);
			nbt.putString("Clan", Clan);
			nbt.putBoolean("DojutsuIsActive", DojutsuIsActive);
			nbt.putString("Family", Family);
			nbt.putDouble("FireForceGen", FireForceGen);
			nbt.putDouble("GlobalMaxPlayerEnergy", GlobalMaxPlayerEnergy);
			nbt.putDouble("GlobalMaxPlayerHealth", GlobalMaxPlayerHealth);
			nbt.putDouble("GlobalPlayerEnergy", GlobalPlayerEnergy);
			nbt.putDouble("GlobalPlayerHealth", GlobalPlayerHealth);
			nbt.putBoolean("holdingSecondFunction", holdingSecondFunction);
			nbt.putBoolean("JoinedWorld", JoinedWorld);
			nbt.putDouble("JutsuXP", JutsuXP);
			nbt.putString("LeftDojutsu", LeftDojutsu);
			nbt.putDouble("LeftSharinganLevel", LeftSharinganLevel);
			nbt.putDouble("LeftSharinganXP", LeftSharinganXP);
			nbt.putDouble("NarutoIterator", NarutoIterator);
			nbt.putDouble("NinjaLevel", NinjaLevel);
			nbt.putDouble("NinjaXP", NinjaXP);
			nbt.putDouble("Ninjutsu", Ninjutsu);
			nbt.putDouble("NunjaXPRequired", NunjaXPRequired);
			nbt.putString("PlayerFirstName", PlayerFirstName);
			nbt.putString("Pyrokinesis", Pyrokinesis);
			nbt.putString("RightDojutsu", RightDojutsu);
			nbt.putDouble("RightSharinganLevel", RightSharinganLevel);
			nbt.putDouble("RightSharinganXP", RightSharinganXP);
			nbt.putBoolean("SaidLatom", SaidLatom);
			nbt.putString("Species", Species);
			nbt.putString("SpeciesRealm", SpeciesRealm);
			nbt.putDouble("StatXP", StatXP);
			nbt.putString("Faction", Faction);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Anime = nbt.getString("Anime");
			ChakraControl = nbt.getBoolean("ChakraControl");
			Clan = nbt.getString("Clan");
			DojutsuIsActive = nbt.getBoolean("DojutsuIsActive");
			Family = nbt.getString("Family");
			FireForceGen = nbt.getDouble("FireForceGen");
			GlobalMaxPlayerEnergy = nbt.getDouble("GlobalMaxPlayerEnergy");
			GlobalMaxPlayerHealth = nbt.getDouble("GlobalMaxPlayerHealth");
			GlobalPlayerEnergy = nbt.getDouble("GlobalPlayerEnergy");
			GlobalPlayerHealth = nbt.getDouble("GlobalPlayerHealth");
			holdingSecondFunction = nbt.getBoolean("holdingSecondFunction");
			JoinedWorld = nbt.getBoolean("JoinedWorld");
			JutsuXP = nbt.getDouble("JutsuXP");
			LeftDojutsu = nbt.getString("LeftDojutsu");
			LeftSharinganLevel = nbt.getDouble("LeftSharinganLevel");
			LeftSharinganXP = nbt.getDouble("LeftSharinganXP");
			NarutoIterator = nbt.getDouble("NarutoIterator");
			NinjaLevel = nbt.getDouble("NinjaLevel");
			NinjaXP = nbt.getDouble("NinjaXP");
			Ninjutsu = nbt.getDouble("Ninjutsu");
			NunjaXPRequired = nbt.getDouble("NunjaXPRequired");
			PlayerFirstName = nbt.getString("PlayerFirstName");
			Pyrokinesis = nbt.getString("Pyrokinesis");
			RightDojutsu = nbt.getString("RightDojutsu");
			RightSharinganLevel = nbt.getDouble("RightSharinganLevel");
			RightSharinganXP = nbt.getDouble("RightSharinganXP");
			SaidLatom = nbt.getBoolean("SaidLatom");
			Species = nbt.getString("Species");
			SpeciesRealm = nbt.getString("SpeciesRealm");
			StatXP = nbt.getDouble("StatXP");
			Faction = nbt.getString("Faction");
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
					variables.Anime = message.data.Anime;
					variables.ChakraControl = message.data.ChakraControl;
					variables.Clan = message.data.Clan;
					variables.DojutsuIsActive = message.data.DojutsuIsActive;
					variables.Family = message.data.Family;
					variables.FireForceGen = message.data.FireForceGen;
					variables.GlobalMaxPlayerEnergy = message.data.GlobalMaxPlayerEnergy;
					variables.GlobalMaxPlayerHealth = message.data.GlobalMaxPlayerHealth;
					variables.GlobalPlayerEnergy = message.data.GlobalPlayerEnergy;
					variables.GlobalPlayerHealth = message.data.GlobalPlayerHealth;
					variables.holdingSecondFunction = message.data.holdingSecondFunction;
					variables.JoinedWorld = message.data.JoinedWorld;
					variables.JutsuXP = message.data.JutsuXP;
					variables.LeftDojutsu = message.data.LeftDojutsu;
					variables.LeftSharinganLevel = message.data.LeftSharinganLevel;
					variables.LeftSharinganXP = message.data.LeftSharinganXP;
					variables.NarutoIterator = message.data.NarutoIterator;
					variables.NinjaLevel = message.data.NinjaLevel;
					variables.NinjaXP = message.data.NinjaXP;
					variables.Ninjutsu = message.data.Ninjutsu;
					variables.NunjaXPRequired = message.data.NunjaXPRequired;
					variables.PlayerFirstName = message.data.PlayerFirstName;
					variables.Pyrokinesis = message.data.Pyrokinesis;
					variables.RightDojutsu = message.data.RightDojutsu;
					variables.RightSharinganLevel = message.data.RightSharinganLevel;
					variables.RightSharinganXP = message.data.RightSharinganXP;
					variables.SaidLatom = message.data.SaidLatom;
					variables.Species = message.data.Species;
					variables.SpeciesRealm = message.data.SpeciesRealm;
					variables.StatXP = message.data.StatXP;
					variables.Faction = message.data.Faction;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
