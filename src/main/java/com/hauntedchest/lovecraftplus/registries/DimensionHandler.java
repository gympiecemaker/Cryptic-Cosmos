package com.hauntedchest.lovecraftplus.registries;

import com.hauntedchest.lovecraftplus.LovecraftPlusMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class DimensionHandler {
    public static final RegistryKey<DimensionType> MOON_DIM_TYPE = RegistryKey.getOrCreateKey(
            Registry.DIMENSION_TYPE_KEY, new ResourceLocation(LovecraftPlusMod.MOD_ID, "moon_dim"));
    public static final RegistryKey<World> MOON_DIM = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("moon_dim"));

}
