package net.mcreator.animechaos.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

public class AnimeSelectForwardProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean Gate = false;
		Gate = false;
		if (((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).Anime).equals("None") && Gate == false) {
			{
				String _setval = "Naruto";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Anime = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			Gate = true;
		}
		if (((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).Anime).equals("Naruto") && Gate == false) {
			{
				String _setval = "Fire Force";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Anime = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			Gate = true;
		}
		if (((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).Anime).equals("Fire Force") && Gate == false) {
			{
				String _setval = "None";
				entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Anime = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			Gate = true;
		}
	}
}
