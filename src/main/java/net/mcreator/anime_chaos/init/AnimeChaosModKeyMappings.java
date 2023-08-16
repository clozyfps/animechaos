
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anime_chaos.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.animechaos.network.ActivateDojutsuMessage;
import net.mcreator.anime_chaos.AnimeChaosMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AnimeChaosModKeyMappings {
	public static final KeyMapping SECOND_FUNCTION = new KeyMapping("key.anime_chaos.second_function", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.anime_chaos");
	public static final KeyMapping ACTIVATE_DOJUTSU = new KeyMapping("key.anime_chaos.activate_dojutsu", GLFW.GLFW_KEY_R, "key.categories.anime_chaos_naruto") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ACTIVATE_DOJUTSU_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ACTIVATE_DOJUTSU_LASTPRESS);
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new ActivateDojutsuMessage(1, dt));
				ActivateDojutsuMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long ACTIVATE_DOJUTSU_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SECOND_FUNCTION);
		event.register(ACTIVATE_DOJUTSU);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				ACTIVATE_DOJUTSU.consumeClick();
			}
		}
	}
}
