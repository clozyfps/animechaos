
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animechaos.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.animechaos.world.inventory.StatScreenMenu;
import net.mcreator.animechaos.world.inventory.StartUpGen1Menu;
import net.mcreator.animechaos.world.inventory.PlayerLoadupMenu;
import net.mcreator.animechaos.AnimeChaosMod;

public class AnimeChaosModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, AnimeChaosMod.MODID);
	public static final RegistryObject<MenuType<PlayerLoadupMenu>> PLAYER_LOADUP = REGISTRY.register("player_loadup", () -> IForgeMenuType.create(PlayerLoadupMenu::new));
	public static final RegistryObject<MenuType<StatScreenMenu>> STAT_SCREEN = REGISTRY.register("stat_screen", () -> IForgeMenuType.create(StatScreenMenu::new));
	public static final RegistryObject<MenuType<StartUpGen1Menu>> START_UP_GEN_1 = REGISTRY.register("start_up_gen_1", () -> IForgeMenuType.create(StartUpGen1Menu::new));
}
