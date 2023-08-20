package net.mcreator.animechaos.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

public class EarthSpeciesRandomizerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double ClanName = 0;
		double SpeciesSet = 0;
		double RealmSpecies = 0;
		SpeciesSet = Mth.nextInt(RandomSource.create(), 1, 3);
		if (SpeciesSet == 1) {
			{
				String _setval = "Human";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Species = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (RealmSpecies == 2) {
			{
				String _setval = "Cryomancer";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Species = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (SpeciesSet == 3) {
			{
				String _setval = "Saurian";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Species = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
