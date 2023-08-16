
package net.mcreator.animechaos.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TestItem extends Item {
	public TestItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.COMMON));
	}
}
