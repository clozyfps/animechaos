package net.mcreator.animechaos.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.animechaos.network.AnimeChaosModVariables;

public class DeactivateSecondFunctionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.holdingSecondFunction = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
