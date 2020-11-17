package com.hauntedchest.lovecraftplus.world;

import com.google.common.collect.ImmutableList;
import com.hauntedchest.lovecraftplus.registries.BlockHandler;
import com.hauntedchest.lovecraftplus.registries.EntityTypeHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.trunkplacer.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import static net.minecraft.world.biome.Biome.*;

public class BiomeMaker {
    private static final int waterColor = 0x3f76e4;
    private static final int waterFogColor = 0x50533;
    private static final int grassColor = 0x91bd59;
    private static final int foliageColor = 0x77ab2f;
    private static final int skyFogColor = 0xc0d8ff;
    private static final ConfiguredFeature<?, ?> MOON_TREE_FEATURE = Feature.TREE.withConfiguration(
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BlockHandler.MOON_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BlockHandler.MOON_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2),
                            FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)).setIgnoreVines().build())
            .withPlacement(Placement.COUNT_EXTRA.configure(
                    new AtSurfaceWithExtraConfig(
                            10, 0.1F, 1)
            ));

    public static Biome makeMoonPlains() {
        BiomeGenerationSettings.Builder genSettings = genSettings(new SurfaceBuilderConfig(
                BlockHandler.MOONCALITE.get().getDefaultState(),
                BlockHandler.MOONSTONE.get().getDefaultState(),
                BlockHandler.MOONCALITE.get().getDefaultState()));

        WorldGenRegistries.init();

        // genSettings.withStructure(new StructureFeature<>(FeatureHandler.MOON_PILLAR.get(),
        //         NoFeatureConfig.NO_FEATURE_CONFIG));

        MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.MONSTER, EntityType.ENDERMAN,
                4, 1, 4);

        addSpawn(spawnSettings, EntityClassification.MONSTER, EntityTypeHandler.MOON_BEAST.get(),
                8, 1, 2);

        return biome(
                RainType.RAIN,
                Category.PLAINS,
                0.125f,
                1f,
                0f,
                0.0001f,
                effects(0xfffff5,
                        0xfffff5,
                        grassColor, foliageColor, getSkyForTemp(0f), skyFogColor),
                genSettings,
                spawnSettings
        );
    }

    public static Biome makeMoonMountains() {
        BiomeGenerationSettings.Builder genSettings = genSettings(new SurfaceBuilderConfig(
                BlockHandler.MOONCALITE.get().getDefaultState(),
                BlockHandler.MOONSTONE.get().getDefaultState(),
                BlockHandler.MOONCALITE.get().getDefaultState()));

        WorldGenRegistries.init();

        DefaultBiomeFeatures.withCavesAndCanyons(genSettings);

        // genSettings.withStructure(new StructureFeature<>(FeatureHandler.MOON_PILLAR.get(),
        //         NoFeatureConfig.NO_FEATURE_CONFIG));

        MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.MONSTER, EntityType.ENDERMAN,
                4, 1, 4);

        addSpawn(spawnSettings, EntityClassification.MONSTER, EntityTypeHandler.MOON_BEAST.get(),
                8, 1, 2);

        return biome(
                RainType.RAIN,
                Category.PLAINS,
                0.125f,
                1f,
                0f,
                0.0001f,
                effects(0xfffff5,
                        0xfffff5,
                        grassColor, foliageColor, getSkyForTemp(0f), skyFogColor),
                genSettings,
                spawnSettings
        );
    }

    public static Biome makeMoonForest() {
        BiomeGenerationSettings.Builder genSettings = genSettings(new SurfaceBuilderConfig(
                BlockHandler.MOONCALITE.get().getDefaultState(),
                BlockHandler.MOONSTONE.get().getDefaultState(),
                BlockHandler.MOONCALITE.get().getDefaultState()));

        WorldGenRegistries.init();

        DefaultBiomeFeatures.withCavesAndCanyons(genSettings);
        genSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MOON_TREE_FEATURE);

        // genSettings.withStructure(new StructureFeature<>(FeatureHandler.MOON_PILLAR.get(),
        //         NoFeatureConfig.NO_FEATURE_CONFIG));

        MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.MONSTER, EntityType.ENDERMAN,
                4, 1, 4);

        addSpawn(spawnSettings, EntityClassification.MONSTER, EntityTypeHandler.MOON_BEAST.get(),
                8, 1, 2);

        return biome(
                RainType.RAIN,
                Category.PLAINS,
                0.125f,
                1f,
                0f,
                0.0001f,
                effects(0xfffff5,
                        0xfffff5,
                        grassColor, foliageColor, getSkyForTemp(0f), skyFogColor),
                genSettings,
                spawnSettings
        );
    }

    public static Biome makeThornJungle() {
        BiomeGenerationSettings.Builder genSettings = genSettings(new SurfaceBuilderConfig(
                Blocks.GRASS_BLOCK.getDefaultState(),
                Blocks.STONE.getDefaultState(),
                Blocks.SAND.getDefaultState()));

        WorldGenRegistries.init();

        DefaultBiomeFeatures.withCavesAndCanyons(genSettings);
        DefaultBiomeFeatures.withStrongholdAndMineshaft(genSettings);
        DefaultBiomeFeatures.withLavaAndWaterLakes(genSettings);
        DefaultBiomeFeatures.withMonsterRoom(genSettings);
        DefaultBiomeFeatures.withCommonOverworldBlocks(genSettings);
        DefaultBiomeFeatures.withOverworldOres(genSettings);
        DefaultBiomeFeatures.withDisks(genSettings);
        DefaultBiomeFeatures.withBambooVegetation(genSettings);
        DefaultBiomeFeatures.withDefaultFlowers(genSettings);
        DefaultBiomeFeatures.withJungleGrass(genSettings);
        DefaultBiomeFeatures.withNormalMushroomGeneration(genSettings);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(genSettings);
        DefaultBiomeFeatures.withLavaAndWaterSprings(genSettings);
        DefaultBiomeFeatures.withJungleTrees(genSettings);
        DefaultBiomeFeatures.withFrozenTopLayer(genSettings);

        genSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(
                                ImmutableList.of(
                                        Feature.TREE.withConfiguration(
                                                new BaseTreeFeatureConfig.Builder(
                                                        new SimpleBlockStateProvider(
                                                                BlockHandler.THORN_LOG.get().getDefaultState()),
                                                        new SimpleBlockStateProvider(
                                                                BlockHandler.THORN_LEAVES.get().getDefaultState()),
                                                        new AcaciaFoliagePlacer(
                                                                FeatureSpread.func_242252_a(2),
                                                                FeatureSpread.func_242252_a(0)),
                                                        new MegaJungleTrunkPlacer(10,
                                                                2, 19),
                                                        new TwoLayerFeature(1, 1, 2)).build())
                                                .withChance(0.8F)),
                                Features.MEGA_JUNGLE_TREE)));

        MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.CREATURE, EntityType.BEE,
                1, 2, 2);

        addSpawn(spawnSettings, EntityClassification.MONSTER, EntityTypeHandler.MOON_BEAST.get(),
                8, 1, 2);

        return biome(
                RainType.RAIN,
                Category.JUNGLE,
                0.125f,
                1f,
                0.2f,
                0.0001f,
                effects(0x465623,
                        0x88ba40,
                        grassColor, foliageColor, getSkyForTemp(0.2f), skyFogColor),
                genSettings,
                spawnSettings
        );
    }

    @SuppressWarnings("SameParameterValue")
    private static Biome biome(
            RainType precipitation,
            Category category,
            float depth,
            float scale,
            float temperature,
            float downfall,
            BiomeAmbience.Builder effects,
            BiomeGenerationSettings.Builder genSettings,
            MobSpawnInfo.Builder spawnSettings
    ) {
        return new Builder()
                .precipitation(precipitation)
                .category(category)
                .depth(depth)
                .scale(scale)
                .temperature(temperature)
                .downfall(downfall)
                .setEffects(effects.build())
                .withGenerationSettings(genSettings.build())
                .withMobSpawnSettings(spawnSettings.copy())
                .build();
    }

    private static BiomeGenerationSettings.Builder genSettings(SurfaceBuilderConfig config) {
        return new BiomeGenerationSettings.Builder().withSurfaceBuilder(
                SurfaceBuilder.DEFAULT.func_242929_a(config));
    }

    private static MobSpawnInfo.Builder spawnSettings() {
        return new MobSpawnInfo.Builder();
    }

    private static void addSpawn(MobSpawnInfo.Builder spawnSettings,
                                 EntityClassification classification,
                                 EntityType<?> entityType,
                                 int weight,
                                 int min,
                                 int max) {
        spawnSettings.withSpawner(classification,
                new MobSpawnInfo.Spawners(entityType, weight, min, max));
    }

    @SuppressWarnings("SameParameterValue")
    private static BiomeAmbience.Builder effects(
            int waterColor,
            int waterFogColor,
            int grassColor,
            int foliageColor,
            int skyColor,
            int skyFogColor
    ) {
        return new BiomeAmbience.Builder()
                .setWaterColor(waterColor)
                .setWaterFogColor(waterFogColor)
                .withGrassColor(grassColor)
                .withFoliageColor(foliageColor)
                .withSkyColor(skyColor)
                .setFogColor(skyFogColor);
    }

    private static int getSkyForTemp(float temperature) {
        float a = MathHelper.clamp(temperature / 3f, -1f, 1f);
        return MathHelper.hsvToRGB(0.62222224f - a * 0.05f, 0.5f + a * 0.1f, 1.0f);
    }
}
