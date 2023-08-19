package net.mcreator.animechaos.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.animechaos.world.inventory.StartUpGen3Menu;
import net.mcreator.animechaos.network.StartUpGen3ButtonMessage;
import net.mcreator.animechaos.AnimeChaosMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class StartUpGen3Screen extends AbstractContainerScreen<StartUpGen3Menu> {
	private final static HashMap<String, Object> guistate = StartUpGen3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_select;
	Button button_empty;
	Button button_empty1;

	public StartUpGen3Screen(StartUpGen3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 185;
		this.imageHeight = 202;
	}

	private static final ResourceLocation texture = new ResourceLocation("anime_chaos:textures/screens/start_up_gen_3.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("anime_chaos:textures/screens/background.png"));
		this.blit(ms, this.leftPos + 11, this.topPos + 42, 0, 0, 162, 125, 162, 125);

		RenderSystem.setShaderTexture(0, new ResourceLocation("anime_chaos:textures/screens/gen3label.png"));
		this.blit(ms, this.leftPos + 11, this.topPos + 7, 0, 0, 69, 30, 69, 30);

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
		button_select = new Button(this.leftPos + 64, this.topPos + 173, 56, 20, Component.translatable("gui.anime_chaos.start_up_gen_3.button_select"), e -> {
			if (true) {
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new StartUpGen3ButtonMessage(0, x, y, z));
				StartUpGen3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_select", button_select);
		this.addRenderableWidget(button_select);
		button_empty = new Button(this.leftPos + 191, this.topPos + 93, 30, 20, Component.translatable("gui.anime_chaos.start_up_gen_3.button_empty"), e -> {
			if (true) {
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new StartUpGen3ButtonMessage(1, x, y, z));
				StartUpGen3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new Button(this.leftPos + -36, this.topPos + 93, 30, 20, Component.translatable("gui.anime_chaos.start_up_gen_3.button_empty1"), e -> {
			if (true) {
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new StartUpGen3ButtonMessage(2, x, y, z));
				StartUpGen3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
	}
}
