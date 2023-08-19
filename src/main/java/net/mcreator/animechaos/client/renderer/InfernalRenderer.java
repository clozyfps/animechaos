
package net.mcreator.animechaos.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.animechaos.entity.InfernalEntity;
import net.mcreator.animechaos.client.model.ModelInfernal;

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
