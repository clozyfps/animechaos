
package net.mcreator.animechaos.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.animechaos.entity.DemonInfernalEntity;
import net.mcreator.animechaos.client.model.ModelDemonInfernal;

public class DemonInfernalRenderer extends MobRenderer<DemonInfernalEntity, ModelDemonInfernal<DemonInfernalEntity>> {
	public DemonInfernalRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelDemonInfernal(context.bakeLayer(ModelDemonInfernal.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<DemonInfernalEntity, ModelDemonInfernal<DemonInfernalEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("anime_chaos:textures/entities/demoninfernal-e.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(DemonInfernalEntity entity) {
		return new ResourceLocation("anime_chaos:textures/entities/demoninfernal.png");
	}
}
