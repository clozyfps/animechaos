package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class Sharingan2TomoeGenjutsuDoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 240, 3, true, false));
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1, 9, true, false));
	}
}
