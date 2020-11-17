package com.hauntedchest.lovecraftplus.registries;

import com.hauntedchest.lovecraftplus.LovecraftPlusMod;
import com.hauntedchest.lovecraftplus.world.BiomeMaker;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MoonBiomeHandler {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, LovecraftPlusMod.MOD_ID);

    public static final RegistryObject<Biome> MOON_PLAINS = BIOMES.register("moon_plains", BiomeMaker::makeMoonPlains);
    public static final RegistryObject<Biome> MOON_MOUNTAINS = BIOMES.register("moon_mountains", BiomeMaker::makeMoonMountains);
    public static final RegistryObject<Biome> MOON_FOREST = BIOMES.register("moon_forest", BiomeMaker::makeMoonForest);
    private static final RegistryKey<Biome> MOON_PLAINS_KEY = RegistryKey.getOrCreateKey(Registry.BIOME_KEY,
            new ResourceLocation(LovecraftPlusMod.MOD_ID, "moon_plains"));
    private static final RegistryKey<Biome> MOON_MOUNTAINS_KEY = RegistryKey.getOrCreateKey(Registry.BIOME_KEY,
            new ResourceLocation(LovecraftPlusMod.MOD_ID, "moon_mountains"));
    private static final RegistryKey<Biome> MOON_FOREST_KEY = RegistryKey.getOrCreateKey(Registry.BIOME_KEY,
            new ResourceLocation(LovecraftPlusMod.MOD_ID, "moon_forest"));

    @SuppressWarnings("ConstantConditions")
    public static void biomeLoading(BiomeLoadingEvent event) {
        if (event.getName().equals(MOON_PLAINS.get().getRegistryName())) {
            BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
                    new BiomeManager.BiomeEntry(MOON_PLAINS_KEY, 6));
        }

        if (event.getName().equals(MOON_MOUNTAINS.get().getRegistryName())) {
            BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
                    new BiomeManager.BiomeEntry(MOON_MOUNTAINS_KEY, 6));
        }

        if (event.getName().equals(MOON_FOREST.get().getRegistryName())) {
            BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
                    new BiomeManager.BiomeEntry(MOON_FOREST_KEY, 6));
        }
    }
}