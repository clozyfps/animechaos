
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animechaos.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.animechaos.network.SecondFunctionMessage;
import net.mcreator.animechaos.network.OpenStatsMenuMessage;
import net.mcreator.animechaos.network.ActivateDojutsuMessage;
import net.mcreator.animechaos.AnimeChaosMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AnimeChaosModKeyMappings {
	public static final KeyMapping SECOND_FUNCTION = new KeyMapping("key.anime_chaos.second_function", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.anime_chaos") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new SecondFunctionMessage(0, 0));
				SecondFunctionMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				SECOND_FUNCTION_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - SECOND_FUNCTION_LASTPRESS);
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new SecondFunctionMessage(1, dt));
				SecondFunctionMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ACTIVATE_DOJUTSU = new KeyMapping("key.anime_chaos.activate_dojutsu", GLFW.GLFW_KEY_R, "key.categories.anime_chaos_naruto") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new ActivateDojutsuMessage(0, 0));
				ActivateDojutsuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_STATS_MENU = new KeyMapping("key.anime_chaos.open_stats_menu", GLFW.GLFW_KEY_V, "key.categories.anime_chaos_naruto") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new OpenStatsMenuMessage(0, 0));
				OpenStatsMenuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long SECOND_FUNCTION_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SECOND_FUNCTION);
		event.register(ACTIVATE_DOJUTSU);
		event.register(OPEN_STATS_MENU);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SECOND_FUNCTION.consumeClick();
				ACTIVATE_DOJUTSU.consumeClick();
				OPEN_STATS_MENU.consumeClick();
			}
		}
	}
}
