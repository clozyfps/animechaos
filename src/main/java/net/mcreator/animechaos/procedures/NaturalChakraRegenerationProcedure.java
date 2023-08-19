package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NaturalChakraRegenerationProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

private static void execute(
@Nullable Event event,
Entity entity
) {
if(
entity == null
) return ;
if (((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeChaosModVariables.PlayerVariables())).Anime).equals("\"Naruto\"")) {if (>=20&&(entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalPlayerEnergy<(entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalMaxPlayerEnergy) {{
double _setval = (entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalPlayerEnergy+2;
entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.GlobalPlayerEnergy = _setval;
capability.syncPlayerVariables(entity);
});
}}else if (>=20&&(entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalPlayerEnergy>=(entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalMaxPlayerEnergy) {{
double _setval = (entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalMaxPlayerEnergy;
entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.GlobalPlayerEnergy = _setval;
capability.syncPlayerVariables(entity);
});
}}}
}
}
