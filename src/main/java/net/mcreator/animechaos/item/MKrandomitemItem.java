
package net.mcreator.animechaos.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class MKrandomitemItem extends Item {

	public MKrandomitemItem() {
		super(new Item.Properties().tab(null).stacksTo(8).rarity(Rarity.EPIC));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		MKrandomProcedureProcedure.execute();
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		MKrandomProcedureProcedure.execute(

		);
		return InteractionResult.SUCCESS;
	}

}
