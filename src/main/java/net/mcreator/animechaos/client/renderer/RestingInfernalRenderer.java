
package net.mcreator.animechaos.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.animechaos.entity.RestingInfernalEntity;
import net.mcreator.animechaos.client.model.ModelRestingInfernal;

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
