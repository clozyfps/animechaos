
package net.mcreator.animechaos.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.animechaos.entity.DemonInfernalRestingEntity;
import net.mcreator.animechaos.client.model.ModelDemonInfernalResting;

public class DemonInfernalRestingRenderer extends MobRenderer<DemonInfernalRestingEntity, ModelDemonInfernalResting<DemonInfernalRestingEntity>> {
	public DemonInfernalRestingRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelDemonInfernalResting(context.bakeLayer(ModelDemonInfernalResting.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<DemonInfernalRestingEntity, ModelDemonInfernalResting<DemonInfernalRestingEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("anime_chaos:textures/entities/demoninfernalresting-e.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(DemonInfernalRestingEntity entity) {
		return new ResourceLocation("anime_chaos:textures/entities/demoninfernalresting.png");
	}
}
