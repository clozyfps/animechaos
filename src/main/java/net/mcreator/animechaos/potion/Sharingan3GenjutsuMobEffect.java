
package net.mcreator.animechaos.potion;

public class Sharingan3GenjutsuMobEffect extends MobEffect {

	public Sharingan3GenjutsuMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.anime_chaos.sharingan_3_genjutsu";
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

}
