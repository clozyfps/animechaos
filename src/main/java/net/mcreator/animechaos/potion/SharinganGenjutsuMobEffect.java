
package net.mcreator.animechaos.potion;

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
