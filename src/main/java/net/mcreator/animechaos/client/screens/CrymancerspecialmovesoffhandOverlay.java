
package net.mcreator.animechaos.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.animechaos.procedures.CryomancerSMoffhandProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class CrymancerspecialmovesoffhandOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level;
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (CryomancerSMoffhandProcedure.execute(entity)) {
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.anime_chaos.crymancerspecialmovesoffhand.label_1"), posX + -211, posY + -115, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.anime_chaos.crymancerspecialmovesoffhand.label_ice_slide"), posX + -210, posY + -104, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.anime_chaos.crymancerspecialmovesoffhand.label_3_ice_clone"), posX + -210, posY + -92, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.anime_chaos.crymancerspecialmovesoffhand.label_4creeping_ice"), posX + -210, posY + -81, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.anime_chaos.crymancerspecialmovesoffhand.label_5cold_shoulder"), posX + -210, posY + -70, -1);
		}
	}
}
