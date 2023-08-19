package net.mcreator.animechaos.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

public class AnimeSelectedTextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).Anime;
	}
}
