
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.animechaos.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.animechaos.potion.SharinganGenjutsuMobEffect;
import net.mcreator.animechaos.potion.Sharingan3GenjutsuMobEffect;
import net.mcreator.animechaos.AnimeChaosMod;

public class AnimeChaosModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AnimeChaosMod.MODID);
	public static final RegistryObject<MobEffect> SHARINGAN_3_GENJUTSU = REGISTRY.register("sharingan_3_genjutsu", () -> new Sharingan3GenjutsuMobEffect());
	public static final RegistryObject<MobEffect> SHARINGAN_GENJUTSU = REGISTRY.register("sharingan_genjutsu", () -> new SharinganGenjutsuMobEffect());
}
