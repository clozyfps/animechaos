package net.mcreator.animechaos.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

public class ClanFactionRandomizerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double ClanName = 0;
		double ClanfactionSet = 0;
		ClanfactionSet = Mth.nextInt(RandomSource.create(), 1, 10);
		if (ClanfactionSet == 1) {
			{
				String _setval = "Shirai Ryu";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.clanfaction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanfactionSet == 2) {
			{
				String _setval = "Black Dragon";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.clanfaction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanfactionSet == 3) {
			{
				String _setval = "Lin Kuei";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.clanfaction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanfactionSet == 4) {
			{
				String _setval = "Special Forces";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.clanfaction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanfactionSet == 5) {
			{
				String _setval = "White Lotus Society";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.clanfaction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanfactionSet == 6) {
			{
				String _setval = "Matako Tribe";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.clanfaction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanfactionSet == 7) {
			{
				String _setval = "None";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.clanfaction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClanfactionSet == 8) {
			{
				String _setval = "None";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.clanfaction = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
