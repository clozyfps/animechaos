
package net.mcreator.animechaos.client.renderer;

public class RestingInfernalRenderer extends MobRenderer<RestingInfernalEntity, ModelRestingInfernal<RestingInfernalEntity>> {

	public RestingInfernalRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelRestingInfernal(context.bakeLayer(ModelRestingInfernal.LAYER_LOCATION)), 0.5f);

		this.addLayer(new EyesLayer<RestingInfernalEntity, ModelRestingInfernal<RestingInfernalEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("anime_chaos:textures/entities/restinginfernal-e.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(RestingInfernalEntity entity) {
		return new ResourceLocation("anime_chaos:textures/entities/restinginfernal.png");
	}

}
