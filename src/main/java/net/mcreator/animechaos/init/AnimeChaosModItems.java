
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animechaos.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.animechaos.item.TestItem;
import net.mcreator.animechaos.item.MKrandomitemItem;
import net.mcreator.animechaos.item.CryomancerAbilitiesItem;
import net.mcreator.animechaos.AnimeChaosMod;

public class AnimeChaosModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AnimeChaosMod.MODID);
	public static final RegistryObject<Item> INFERNAL_SPAWN_EGG = REGISTRY.register("infernal_spawn_egg", () -> new ForgeSpawnEggItem(AnimeChaosModEntities.INFERNAL, -14941180, -9945, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> RESTING_INFERNAL_SPAWN_EGG = REGISTRY.register("resting_infernal_spawn_egg", () -> new ForgeSpawnEggItem(AnimeChaosModEntities.RESTING_INFERNAL, -14941180, -9945, new Item.Properties().tab(null)));
	public static final RegistryObject<Item> DEMON_INFERNAL_SPAWN_EGG = REGISTRY.register("demon_infernal_spawn_egg",
			() -> new ForgeSpawnEggItem(AnimeChaosModEntities.DEMON_INFERNAL, -14941180, -9945, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> DEMON_INFERNAL_RESTING_SPAWN_EGG = REGISTRY.register("demon_infernal_resting_spawn_egg",
			() -> new ForgeSpawnEggItem(AnimeChaosModEntities.DEMON_INFERNAL_RESTING, -14941180, -9945, new Item.Properties().tab(null)));
	public static final RegistryObject<Item> TEST = REGISTRY.register("test", () -> new TestItem());
	public static final RegistryObject<Item> M_KRANDOMITEM = REGISTRY.register("m_krandomitem", () -> new MKrandomitemItem());
	public static final RegistryObject<Item> CRYOMANCER_ABILITIES = REGISTRY.register("cryomancer_abilities", () -> new CryomancerAbilitiesItem());
}
