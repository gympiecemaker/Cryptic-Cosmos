package com.hauntedchest.LovecraftPlus.Inits;

import com.hauntedchest.LovecraftPlus.Blocks.*;
import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.world.feature.ThornTree;
import net.minecraft.block.*;
import com.hauntedchest.LovecraftPlus.Blocks.LogBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockHandeler {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister(ForgeRegistries.BLOCKS, LovecraftPlusMod.MOD_ID);

    public static void init(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    //Portal Blocks
    public static final RegistryObject<Block> HUMMING_STONE = BLOCKS.register("humming_stone", HummingStone::new);
    public static final RegistryObject<Block> DREAMING_SOULS = BLOCKS.register("dreaming_souls", DreamingSouls::new);

    //Moon Blocks
    public static final RegistryObject<Block> MOON_BLOCK = BLOCKS.register("moon_block", MoonBlock::new);
    public static final RegistryObject<Block> MOONSTONE_BRICKS = BLOCKS.register("moonstone_bricks", MoonStoneBricks::new);
    public static final RegistryObject<Block> MOONSTONE = BLOCKS.register("moonstone", MoonHolesBlock::new);
    public static final RegistryObject<Block> SMOOTH_MOONSTONE = BLOCKS.register("smooth_moonstone", MoonStoneBricks::new);

    //Wood Blocks

    //Thorn Wood
    public static final RegistryObject<Block> THORN_LOG = BLOCKS.register("thorn_log",() -> new LogBlocks(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> THORN_PLANKS = BLOCKS.register("thorn_planks",() -> new LogBlocks(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> THORN_SAPLING = BLOCKS.register("thorn_sapling",
            () -> new ThornSapling(ThornTree::new, Block.Properties.from(Blocks.JUNGLE_SAPLING)));
    public static final RegistryObject<Block> THORN_LEAVES = BLOCKS.register("thorn_leaves",() -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> THORN_DOOR = BLOCKS.register("thorn_door", () -> new ThornDoor(Block.Properties.from(Blocks.JUNGLE_DOOR)));

    //Other Blocks
    public static final RegistryObject<Block> LAVA_SPONGE = BLOCKS.register("lava_sponge",() -> new LavaSponge(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.6F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOLTEN_LAVA_SPONGE = BLOCKS.register("molten_lava_sponge", () -> new MoltenLavaSponge(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.6F).sound(SoundType.STONE)));


}
