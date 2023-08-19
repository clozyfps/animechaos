
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animechaos.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.animechaos.client.model.ModelRestingInfernal;
import net.mcreator.animechaos.client.model.ModelInfernal;
import net.mcreator.animechaos.client.model.ModelDemonInfernalResting;
import net.mcreator.animechaos.client.model.ModelDemonInfernal;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AnimeChaosModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelDemonInfernalResting.LAYER_LOCATION, ModelDemonInfernalResting::createBodyLayer);
		event.registerLayerDefinition(ModelInfernal.LAYER_LOCATION, ModelInfernal::createBodyLayer);
		event.registerLayerDefinition(ModelDemonInfernal.LAYER_LOCATION, ModelDemonInfernal::createBodyLayer);
		event.registerLayerDefinition(ModelRestingInfernal.LAYER_LOCATION, ModelRestingInfernal::createBodyLayer);
	}
}
