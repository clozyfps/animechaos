package net.mcreator.animechaos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

public class FamilyRandomizerProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ClanName = 0;
		double SpeciesSet = 0;
		double RealmSpecies = 0;
		double FamilySet = 0;
		FamilySet = Mth.nextInt(RandomSource.create(), 1, 10);
		if (FamilySet == 1) {
			{
				String _setval = "[Family Unknow]";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Family = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (FamilySet == 2) {
			{
				String _setval = "Cage";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Family = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (FamilySet == 3) {
			{
				String _setval = "Takashi";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Family = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (FamilySet == 4) {
			{
				String _setval = "Liang";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Family = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (FamilySet == 5) {
			{
				String _setval = "Kahn";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Family = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (FamilySet == 6) {
			{
				String _setval = "Hasashi";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Family = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (FamilySet == 7) {
			{
				String _setval = "Chi";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Family = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (FamilySet == 8) {
			{
				String _setval = "Vrbada";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Family = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (FamilySet == 9) {
			{
				String _setval = "Lao";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Family = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (FamilySet == 10) {
			{
				String _setval = "[Family Unknow]";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Family = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		MKfamilyconfirmProcedure.execute(world, entity);
	}
}
