
package net.mcreator.animechaos.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class Tomoe2SharinganImplantItem extends Item {

	public Tomoe2SharinganImplantItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.RARE));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("The 2 Tomoe Sharingan of an Uchiha"));
	}

}
