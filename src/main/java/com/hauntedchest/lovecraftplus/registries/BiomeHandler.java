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

public class BiomeHandler {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, LovecraftPlusMod.MOD_ID);

    public static final RegistryObject<Biome> THORN_JUNGLE = BIOMES.register("thorn_jungle", BiomeMaker::makeThornJungle);
    private static final RegistryKey<Biome> THORN_JUNGLE_KEY = RegistryKey.getOrCreateKey(Registry.BIOME_KEY,
            new ResourceLocation(LovecraftPlusMod.MOD_ID, "thorn_jungle"));

    @SuppressWarnings("ConstantConditions")
    public static void biomeLoading(BiomeLoadingEvent event) {
        if (event.getName().equals(THORN_JUNGLE.get().getRegistryName())) {
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
                    new BiomeManager.BiomeEntry(THORN_JUNGLE_KEY, 25));
        }
    }
}
