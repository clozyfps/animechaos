
package net.mcreator.animechaos.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class CryomancerAbilitiesItem extends Item {
	public CryomancerAbilitiesItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.EPIC));
	}
}
