
package net.mcreator.animechaos.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class TestItem extends Item {
	public TestItem() {
		super(new Item.Properties().tab(null).stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState state) {
		return true;
	}
}
