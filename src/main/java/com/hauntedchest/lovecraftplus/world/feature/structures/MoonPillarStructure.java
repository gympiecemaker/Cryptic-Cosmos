package com.hauntedchest.lovecraftplus.world.feature.structures;

import com.hauntedchest.lovecraftplus.LovecraftPlusMod;
import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

@SuppressWarnings("NullableProblems")
public class MoonPillarStructure extends Structure<NoFeatureConfig> {
    public MoonPillarStructure(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return MoonPillarStructure.Start::new;
    }

    @Override
    public String getStructureName() {
        return LovecraftPlusMod.MOD_ID + ":moon_pillar";
    }

    @SuppressWarnings("NullableProblems")
    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int reference,
                     long seed) {
            super(structure, chunkX, chunkZ, boundingBox, reference, seed);
        }

        @Override
        public void func_230364_a_(DynamicRegistries registries, ChunkGenerator generator, TemplateManager templateManager, int chunkX, int p_230364_5_, Biome biome, NoFeatureConfig featureConfig) {
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];

            int x = (chunkX << 4) + 7;
            int z = (chunkX << 4) + 7;
            int y = generator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
            BlockPos pos = new BlockPos(x, y, z);

            MoonPillarPieces.start(templateManager, pos, rotation, this.components);

            this.recalculateStructureSize();

            LovecraftPlusMod.LOGGER.info("We can find a moon pillar at: " + pos);
        }
    }
}
