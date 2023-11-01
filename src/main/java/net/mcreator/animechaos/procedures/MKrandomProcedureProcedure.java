package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class MKrandomProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		FamilyRandomizerProcedure.execute(world, entity);
		SpeciesRandomizerProcedure.execute(entity);
		FactionRandomizerProcedure.execute(entity);
	}
}
