package net.mcreator.animechaos.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

public class OutworldSpeciesRandomizerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double ClanName = 0;
		double SpeciesSet = 0;
		double RealmSpecies = 0;
		SpeciesSet = Mth.nextInt(RandomSource.create(), 1, 5);
		if (SpeciesSet == 1) {
			{
				String _setval = "Edenian";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Species = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (SpeciesSet == 2) {
			{
				String _setval = "Immotal";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Species = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (SpeciesSet == 3) {
			{
				String _setval = "Kytinn";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Species = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (SpeciesSet == 4) {
			{
				String _setval = "Shokan";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Species = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (SpeciesSet == 5) {
			{
				String _setval = "Tarkatan";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Species = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
