package com.hauntedchest.lovecraftplus.world;

import com.hauntedchest.lovecraftplus.registries.BlockHandler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class FeatureGen {
    private static final int veinSize = 7;
    private static final int maxHeight = 22;
    private static final int minHeight = 16;
    private static final int veinsPerChunk = 7;

    public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
        if (!(event.getCategory().equals(Biome.Category.NETHER) && event.getCategory().equals(Biome.Category.THEEND))) {
            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.withConfiguration(
                            new OreFeatureConfig(
                                    OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                                    BlockHandler.HUMMING_STONE.get().getDefaultState(),
                                    veinSize))
                            .withPlacement(Placement.RANGE.configure(
                                    new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                            .square().func_242731_b(veinsPerChunk)
            );
        }
    }
}
