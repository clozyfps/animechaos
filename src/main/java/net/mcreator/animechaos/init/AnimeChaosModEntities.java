
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animechaos.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.animechaos.entity.RestingInfernalEntity;
import net.mcreator.animechaos.entity.InfernalEntity;
import net.mcreator.animechaos.entity.DemonInfernalRestingEntity;
import net.mcreator.animechaos.entity.DemonInfernalEntity;
import net.mcreator.animechaos.AnimeChaosMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AnimeChaosModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AnimeChaosMod.MODID);
	public static final RegistryObject<EntityType<InfernalEntity>> INFERNAL = register("infernal",
			EntityType.Builder.<InfernalEntity>of(InfernalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InfernalEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RestingInfernalEntity>> RESTING_INFERNAL = register("resting_infernal", EntityType.Builder.<RestingInfernalEntity>of(RestingInfernalEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RestingInfernalEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DemonInfernalEntity>> DEMON_INFERNAL = register("demon_infernal", EntityType.Builder.<DemonInfernalEntity>of(DemonInfernalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DemonInfernalEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DemonInfernalRestingEntity>> DEMON_INFERNAL_RESTING = register("demon_infernal_resting", EntityType.Builder.<DemonInfernalRestingEntity>of(DemonInfernalRestingEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DemonInfernalRestingEntity::new).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			InfernalEntity.init();
			RestingInfernalEntity.init();
			DemonInfernalEntity.init();
			DemonInfernalRestingEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(INFERNAL.get(), InfernalEntity.createAttributes().build());
		event.put(RESTING_INFERNAL.get(), RestingInfernalEntity.createAttributes().build());
		event.put(DEMON_INFERNAL.get(), DemonInfernalEntity.createAttributes().build());
		event.put(DEMON_INFERNAL_RESTING.get(), DemonInfernalRestingEntity.createAttributes().build());
	}
}
