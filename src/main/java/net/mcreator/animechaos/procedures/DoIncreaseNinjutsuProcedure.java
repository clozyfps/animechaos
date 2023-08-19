package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class DoIncreaseNinjutsuProcedure {
public static void execute(
Entity entity
) {
if(
entity == null
) return ;
if (>=1&&(entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeChaosModVariables.PlayerVariables())).Ninjutsu<500) {{
double _setval = (entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeChaosModVariables.PlayerVariables())).Ninjutsu+1;
entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Ninjutsu = _setval;
capability.syncPlayerVariables(entity);
});
}}
}
}
