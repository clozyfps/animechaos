
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animechaos.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.animechaos.AnimeChaosMod;

public class AnimeChaosModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AnimeChaosMod.MODID);
	public static final RegistryObject<SoundEvent> SHARINGAN_ACTIVATED = REGISTRY.register("sharingan_activated", () -> new SoundEvent(new ResourceLocation("anime_chaos", "sharingan_activated")));
	public static final RegistryObject<SoundEvent> SHARINGAN_DEACTIVATED = REGISTRY.register("sharingan_deactivated", () -> new SoundEvent(new ResourceLocation("anime_chaos", "sharingan_deactivated")));
}
