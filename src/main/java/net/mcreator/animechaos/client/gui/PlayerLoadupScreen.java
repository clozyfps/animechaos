package net.mcreator.animechaos.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.animechaos.world.inventory.PlayerLoadupMenu;
import net.mcreator.animechaos.procedures.AnimeSelectedTextProcedure;
import net.mcreator.animechaos.network.PlayerLoadupButtonMessage;
import net.mcreator.animechaos.AnimeChaosMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PlayerLoadupScreen extends AbstractContainerScreen<PlayerLoadupMenu> {
	private final static HashMap<String, Object> guistate = PlayerLoadupMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox FirstName;
	Button button_empty;
	Button button_empty1;
	Button button_set_first_name;
	Button button_next;

	public PlayerLoadupScreen(PlayerLoadupMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 240;
		this.imageHeight = 100;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("anime_chaos:textures/screens/player_loadup.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		FirstName.render(ms, mouseX, mouseY, partialTicks);
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
		if (FirstName.isFocused())
			return FirstName.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		FirstName.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack,

				AnimeSelectedTextProcedure.execute(entity), 40, 59, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.anime_chaos.player_loadup.label_anime_can_be_changed"), 7, 59, -12829636);
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
		FirstName = new EditBox(this.font, this.leftPos + 7, this.topPos + 8, 120, 20, Component.translatable("gui.anime_chaos.player_loadup.FirstName"));
		FirstName.setMaxLength(32767);
		guistate.put("text:FirstName", FirstName);
		this.addWidget(this.FirstName);
		button_empty = new Button(this.leftPos + 41, this.topPos + 72, 30, 20, Component.translatable("gui.anime_chaos.player_loadup.button_empty"), e -> {
			if (true) {
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new PlayerLoadupButtonMessage(0, x, y, z));
				PlayerLoadupButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new Button(this.leftPos + 7, this.topPos + 72, 30, 20, Component.translatable("gui.anime_chaos.player_loadup.button_empty1"), e -> {
			if (true) {
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new PlayerLoadupButtonMessage(1, x, y, z));
				PlayerLoadupButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		button_set_first_name = new Button(this.leftPos + 132, this.topPos + 8, 98, 20, Component.translatable("gui.anime_chaos.player_loadup.button_set_first_name"), e -> {
			if (true) {
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new PlayerLoadupButtonMessage(2, x, y, z));
				PlayerLoadupButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_set_first_name", button_set_first_name);
		this.addRenderableWidget(button_set_first_name);
		button_next = new Button(this.leftPos + 184, this.topPos + 72, 46, 20, Component.translatable("gui.anime_chaos.player_loadup.button_next"), e -> {
			if (true) {
				AnimeChaosMod.PACKET_HANDLER.sendToServer(new PlayerLoadupButtonMessage(3, x, y, z));
				PlayerLoadupButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_next", button_next);
		this.addRenderableWidget(button_next);
	}
}
