
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anime_chaos.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.animechaos.item.TestItem;
import net.mcreator.anime_chaos.AnimeChaosMod;

public class AnimeChaosModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AnimeChaosMod.MODID);
	public static final RegistryObject<Item> TEST = REGISTRY.register("test", () -> new TestItem());
}
