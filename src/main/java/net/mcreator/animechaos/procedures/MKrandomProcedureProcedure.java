package net.mcreator.animechaos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class MKrandomProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		FamilyRandomizerProcedure.execute(world, entity);
		SpeciesRandomizerProcedure.execute(entity);
		FactionRandomizerProcedure.execute(entity);
	}
}
