package com.hauntedchest.lovecraftplus.world.feature;

import com.hauntedchest.lovecraftplus.registries.BlockHandler;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nonnull;
import java.util.Random;

public class ThornTree extends Tree {
    public static final BaseTreeFeatureConfig THORN_TREE_CONFIG = new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockHandler.THORN_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockHandler.THORN_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(
                    FeatureSpread.func_242252_a(2),
                    FeatureSpread.func_242252_a(0), 3),
            new StraightTrunkPlacer(4, 2, 0),
            new TwoLayerFeature(1, 0, 1)).build();

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(@Nonnull Random randomIn, boolean b) {
        return Feature.TREE.withConfiguration(THORN_TREE_CONFIG);
    }
}
