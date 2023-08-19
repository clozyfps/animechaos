package net.mcreator.animechaos.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import net.mcreator.animechaos.world.inventory.StatScreenMenu;
import net.mcreator.animechaos.procedures.ShowSPProcedure;
import net.mcreator.animechaos.procedures.ShowPlayerProcedure;
import net.mcreator.animechaos.procedures.ShowNinjutsuProcedure;
import net.mcreator.animechaos.procedures.ShowNinjaXPRequiredProcedure;
import net.mcreator.animechaos.procedures.ShowNinjaLevelProcedure;
import net.mcreator.animechaos.network.StatScreenButtonMessage;
import net.mcreator.animechaos.AnimeChaosMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class StatScreenScreen extends AbstractContainerScreen<StatScreenMenu> {
	private final static HashMap<String, Object> guistate = StatScreenMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_addbutton;

	public StatScreenScreen(StatScreenMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 256;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("anime_chaos:textures/screens/stat_screen.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		if (ShowPlayerProcedure.execute(world, x, y, z) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryRaw(this.leftPos + 46, this.topPos + 157, 78, 0f + (float) Math.atan((this.leftPos + 46 - mouseX) / 40.0), (float) Math.atan((this.topPos + 107 - mouseY) / 40.0), livingEntity);
		}
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack,

				ShowNinjutsuProcedure.execute(entity), 126, 8, -12829636);
		this.font.draw(poseStack,

				ShowNinjaXPRequiredProcedure.execute(entity), 173, 151, -12829636);
		this.font.draw(poseStack,

				ShowSPProcedure.execute(entity), 173, 140, -12829636);
		this.font.draw(poseStack,

				ShowNinjaLevelProcedure.execute(entity), 173, 129, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		imagebutton_addbutton = new ImageButton(this.leftPos + 117, this.topPos + 10, 7, 7, 0, 0, 7, new ResourceLocation("anime_chaos:textures/screens/atlas/imagebutton_addbutton.png"), 7, 14, e -> {
			if (true) {
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new StatScreenButtonMessage(0, x, y, z));
				StatScreenButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_addbutton", imagebutton_addbutton);
		this.addRenderableWidget(imagebutton_addbutton);
	}
}
