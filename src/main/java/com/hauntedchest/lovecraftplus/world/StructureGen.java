package com.hauntedchest.lovecraftplus.world;

import com.hauntedchest.lovecraftplus.registries.FeatureHandler;
import com.hauntedchest.lovecraftplus.registries.MoonBiomeHandler;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class StructureGen {
    @SuppressWarnings("ConstantConditions")
    public static void generateStructures(BiomeLoadingEvent event) {
        if (event.getName().equals(MoonBiomeHandler.MOON_PLAINS.get().getRegistryName())) {
            event.getGeneration().withStructure(FeatureHandler.MOON_PILLAR.get()
                    .withConfiguration(NoFeatureConfig.NO_FEATURE_CONFIG));
        }

        if (event.getName().equals(MoonBiomeHandler.MOON_MOUNTAINS.get().getRegistryName())) {
            event.getGeneration().withStructure(FeatureHandler.MOON_PILLAR.get()
                    .withConfiguration(NoFeatureConfig.NO_FEATURE_CONFIG));
        }

        if (event.getName().equals(MoonBiomeHandler.MOON_FOREST.get().getRegistryName())) {
            event.getGeneration().withStructure(FeatureHandler.MOON_PILLAR.get()
                    .withConfiguration(NoFeatureConfig.NO_FEATURE_CONFIG));
        }
    }
}
