
package net.mcreator.animechaos.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class Tomoe3SharinganImplantItem extends Item {

	public Tomoe3SharinganImplantItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("The 3 Tomoe Sharingan of an Uchiha"));
	}

}
