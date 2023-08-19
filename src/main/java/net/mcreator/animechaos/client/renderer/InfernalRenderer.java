
package net.mcreator.animechaos.client.renderer;

public class InfernalRenderer extends MobRenderer<InfernalEntity, ModelInfernal<InfernalEntity>> {

	public InfernalRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelInfernal(context.bakeLayer(ModelInfernal.LAYER_LOCATION)), 0.5f);

		this.addLayer(new EyesLayer<InfernalEntity, ModelInfernal<InfernalEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("anime_chaos:textures/entities/infernal-e.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(InfernalEntity entity) {
		return new ResourceLocation("anime_chaos:textures/entities/infernal.png");
	}

}
