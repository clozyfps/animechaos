package net.mcreator.animechaos.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RegenChakraProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getItem());
		}
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).Anime).equals("\"Naruto\"")) {
			if ((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalPlayerEnergy
					+ (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) <= (entity
							.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalMaxPlayerEnergy) {
				{
					double _setval = (entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalPlayerEnergy
							+ (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0);
					entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.GlobalPlayerEnergy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalPlayerEnergy
					+ (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) > (entity
							.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalMaxPlayerEnergy) {
				{
					double _setval = (entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AnimeChaosModVariables.PlayerVariables())).GlobalMaxPlayerEnergy;
					entity.getCapability(AnimeChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.GlobalPlayerEnergy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
