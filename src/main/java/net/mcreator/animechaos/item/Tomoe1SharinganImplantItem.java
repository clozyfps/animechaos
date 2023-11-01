
package net.mcreator.animechaos.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class Tomoe1SharinganImplantItem extends Item {

	public Tomoe1SharinganImplantItem() {
		super(new Item.Properties().tab(null).stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.SPEAR;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 100;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("The 1 Tomoe Sharingan of an Uchiha"));
	}

}
