package com.hauntedchest.LovecraftPlus.world.feature;

import com.hauntedchest.LovecraftPlus.Inits.BlockHandeler;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class ThornTree extends Tree {
        public static final TreeFeatureConfig THORN_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockHandeler.THORN_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockHandeler.THORN_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))).baseHeight(9).heightRandA(4).foliageHeight(3)
            .setSapling((IPlantable) BlockHandeler.THORN_SAPLING.get()).build();

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(THORN_TREE_CONFIG);
    }


}