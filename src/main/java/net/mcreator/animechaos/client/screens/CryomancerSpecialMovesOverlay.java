
package net.mcreator.animechaos.client.screens;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class CryomancerSpecialMovesOverlay {

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

		if (

		CryomancerSpecialMovesDisplayOverlayIngameProcedure.execute()

		) {

			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.anime_chaos.cryomancer_special_moves.label_1"), posX + 154, posY + -114, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.anime_chaos.cryomancer_special_moves.label_ice_slide"), posX + 154, posY + -103, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.anime_chaos.cryomancer_special_moves.label_3_ice_clone"), posX + 154, posY + -92, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.anime_chaos.cryomancer_special_moves.label_4creeping_ice"), posX + 154, posY + -81, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.anime_chaos.cryomancer_special_moves.label_5cold_shoulder"), posX + 154, posY + -70, -1);

		}

	}

}
