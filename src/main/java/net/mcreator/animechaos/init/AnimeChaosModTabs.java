
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animechaos.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class AnimeChaosModTabs {
	public static CreativeModeTab TAB_ANIME_CHAOS_NARUTO;

	public static void load() {
		TAB_ANIME_CHAOS_NARUTO = new CreativeModeTab("tabanime_chaos_naruto") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(AnimeChaosModItems.TOMOE_3_SHARINGAN_IMPLANT.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
