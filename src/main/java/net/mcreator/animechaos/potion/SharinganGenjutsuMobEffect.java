
package net.mcreator.animechaos.potion;

import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.animechaos.procedures.Sharingan2TomoeGenjutsuDoProcedure;
import net.mcreator.animechaos.procedures.RemoveAmbientSharinganEffectsProcedure;

public class SharinganGenjutsuMobEffect extends MobEffect {
	public SharinganGenjutsuMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.anime_chaos.sharingan_genjutsu";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Sharingan2TomoeGenjutsuDoProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		RemoveAmbientSharinganEffectsProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void initializeClient(java.util.function.Consumer<IClientMobEffectExtensions> consumer) {
		consumer.accept(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		});
	}
}
