package com.hauntedchest.lovecraftplus.world.feature;

import com.hauntedchest.lovecraftplus.registries.BlockHandler;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class MoonTree extends Tree {
    public static final BaseTreeFeatureConfig MOON_TREE_CONFIG2 = new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(
                    BlockHandler.MOON_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockHandler.MOON_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(
                    FeatureSpread.func_242252_a(2),
                    FeatureSpread.func_242252_a(0), 3),
            new StraightTrunkPlacer(4, 2, 0),
            new TwoLayerFeature(1, 0, 1))
            .setIgnoreVines().build();

    public static final BaseTreeFeatureConfig MOON_TREE_CONFIG = new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockHandler.MOON_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockHandler.MOON_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(
                    FeatureSpread.func_242252_a(2),
                    FeatureSpread.func_242252_a(0), 3),
            new StraightTrunkPlacer(4, 2, 0),
            new TwoLayerFeature(1, 0, 1))
            .setIgnoreVines().build();

    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(@Nonnull Random randomIn, boolean p_225546_2_) {
        return Feature.TREE.withConfiguration(p_225546_2_ ? MOON_TREE_CONFIG2 : MOON_TREE_CONFIG);
    }
}
