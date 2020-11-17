package com.hauntedchest.lovecraftplus.world.feature.structures;

import com.google.common.collect.ImmutableMap;
import com.hauntedchest.lovecraftplus.LovecraftPlusMod;
import com.hauntedchest.lovecraftplus.registries.FeatureHandler;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MoonPillarPieces {
    private static final ResourceLocation PART_1 = new ResourceLocation(LovecraftPlusMod.MOD_ID, "moon_pillar");

    private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(PART_1, new BlockPos(0, 1, 0));

    public static void start(TemplateManager manager, @Nonnull BlockPos pos, Rotation rot, @Nonnull List<StructurePiece> pieces) {
        int x = pos.getX();
        int z = pos.getZ();

        BlockPos rotationOffset = new BlockPos(0, 0, 0).rotate(rot);
        BlockPos blockpos = rotationOffset.add(x, pos.getY(), z);
        pieces.add(new MoonPillarPieces.Piece(manager, PART_1, blockpos, rot));
    }

    @SuppressWarnings("NullableProblems")
    public static class Piece extends TemplateStructurePiece {
        private final ResourceLocation resourceLocation;
        private final Rotation rotation;

        public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, @Nonnull BlockPos pos,
                     Rotation rotationIn) {
            super(FeatureHandler.MOON_PILLAR_PIECE, 0);
            this.resourceLocation = resourceLocationIn;
            BlockPos blockpos = MoonPillarPieces.OFFSET.get(resourceLocation);
            this.templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
            this.rotation = rotationIn;
            this.setupPiece(templateManagerIn);
        }

        public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
            super(FeatureHandler.MOON_PILLAR_PIECE, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.setupPiece(templateManagerIn);
        }

        private void setupPiece(@Nonnull TemplateManager templateManager) {
            Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation)
                    .setMirror(Mirror.NONE);
            this.setup(template, this.templatePosition, placementsettings);
        }

        @Override
        protected void readAdditional(@Nonnull CompoundNBT tagCompound) {
            super.readAdditional(tagCompound);
            tagCompound.putString("Template", this.resourceLocation.toString());
            tagCompound.putString("Rot", this.rotation.name());
        }

        @Override
        protected void handleDataMarker(String function, BlockPos pos, IServerWorld worldIn, Random rand, MutableBoundingBox sbb) {
            if ("chest".equals(function)) {
                worldIn.setBlockState(pos, Blocks.CHEST.getDefaultState(), 2);
                TileEntity tileentity = worldIn.getTileEntity(pos);
                if (tileentity instanceof ChestTileEntity) {
                    // here you can set any loot tables for the chests
                }
            }
        }

        @Override
        public boolean func_230383_a_(ISeedReader seedReader,
                                      StructureManager structureManager,
                                      ChunkGenerator chunkGenerator,
                                      Random random,
                                      MutableBoundingBox boundingBox,
                                      ChunkPos chunkPos,
                                      BlockPos pos) {
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation)
                    .setMirror(Mirror.NONE);
            BlockPos blockpos = MoonPillarPieces.OFFSET.get(this.resourceLocation);
            this.templatePosition.add(Template.transformedBlockPos(placementsettings,
                    new BlockPos(-blockpos.getX(), 0, -blockpos.getZ())));

            return super.func_230383_a_(seedReader,
                    structureManager,
                    chunkGenerator,
                    random,
                    boundingBox,
                    chunkPos,
                    pos);
        }
    }
}
