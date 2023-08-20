package net.mcreator.animechaos.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

public class SpeciesRandomizerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double ClanName = 0;
		double SpeciesSet = 0;
		double RealmSpecies = 0;
		RealmSpecies = Mth.nextInt(RandomSource.create(), 1, 3);
		if (RealmSpecies == 1) {
			{
				String _setval = "Earth Realm";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpeciesRealm = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			EarthSpeciesRandomizerProcedure.execute(entity);
		}
		if (RealmSpecies == 2) {
			{
				String _setval = "NeatherRealm";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpeciesRealm = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			NetherRealmSpeciesRandomizerProcedure.execute(entity);
		}
		if (RealmSpecies == 3) {
			{
				String _setval = "OutWorld";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpeciesRealm = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			OutworldSpeciesRandomizerProcedure.execute(entity);
		}
	}
}
