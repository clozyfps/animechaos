package net.mcreator.animechaos.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

public class FactionRandomizerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double ClanName = 0;
		double SpeciesSet = 0;
		double RealmSpecies = 0;
		double FamilySet = 0;
		double ClanSet = 0;
		ClanSet = Mth.nextInt(RandomSource.create(), 1, 8);
		if (ClanSet == 1) {
			{
				String _setval = "Shirai Ryu";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Faction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanSet == 2) {
			{
				String _setval = "Lin Kuei";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Faction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanSet == 3) {
			{
				String _setval = "Black Dragon";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Faction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanSet == 4) {
			{
				String _setval = "Special Forces";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Faction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanSet == 5) {
			{
				String _setval = "White Lotus Society";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Faction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanSet == 6) {
			{
				String _setval = "Matako Tribe";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Faction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanSet == 7) {
			{
				String _setval = "None";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Faction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanSet == 8) {
			{
				String _setval = "None";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Faction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
