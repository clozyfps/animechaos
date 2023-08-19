
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animechaos.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.animechaos.client.gui.StatScreenScreen;
import net.mcreator.animechaos.client.gui.StartUpGen3Screen;
import net.mcreator.animechaos.client.gui.StartUpGen2Screen;
import net.mcreator.animechaos.client.gui.StartUpGen1Screen;
import net.mcreator.animechaos.client.gui.PlayerLoadupScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AnimeChaosModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(AnimeChaosModMenus.PLAYER_LOADUP.get(), PlayerLoadupScreen::new);
			MenuScreens.register(AnimeChaosModMenus.STAT_SCREEN.get(), StatScreenScreen::new);
			MenuScreens.register(AnimeChaosModMenus.START_UP_GEN_1.get(), StartUpGen1Screen::new);
			MenuScreens.register(AnimeChaosModMenus.START_UP_GEN_2.get(), StartUpGen2Screen::new);
			MenuScreens.register(AnimeChaosModMenus.START_UP_GEN_3.get(), StartUpGen3Screen::new);
		});
	}
}
