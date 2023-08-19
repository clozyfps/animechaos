
package net.mcreator.animechaos.client.screens;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class NarutoOverlayOverlay {

	@SubscribeEvent(priority = EventPriority.HIGHEST)
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

		IsInAnimeNarutoProcedure.execute(entity)

		) {

			Minecraft.getInstance().font.draw(event.getPoseStack(),

					ShowChakraProcedure.execute(), posX + -207, posY + 103, -16735035);

		}

	}

}
