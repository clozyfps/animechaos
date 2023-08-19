
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animechaos.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.animechaos.client.renderer.RestingInfernalRenderer;
import net.mcreator.animechaos.client.renderer.InfernalRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AnimeChaosModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(AnimeChaosModEntities.INFERNAL.get(), InfernalRenderer::new);
		event.registerEntityRenderer(AnimeChaosModEntities.RESTING_INFERNAL.get(), RestingInfernalRenderer::new);
	}
}
