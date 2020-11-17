package com.hauntedchest.lovecraftplus;

import com.hauntedchest.lovecraftplus.client.entity.model.render.MoonBeastRender;
import com.hauntedchest.lovecraftplus.client.entity.model.render.MoonFrogRender;
import com.hauntedchest.lovecraftplus.entities.MoonBeastEntity;
import com.hauntedchest.lovecraftplus.entities.MoonFrogEntity;
import com.hauntedchest.lovecraftplus.items.CustomSpawnEggItem;
import com.hauntedchest.lovecraftplus.registries.*;
import com.hauntedchest.lovecraftplus.world.FeatureGen;
import com.hauntedchest.lovecraftplus.world.StructureGen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(LovecraftPlusMod.MOD_ID)
public class LovecraftPlusMod {
    public static final Logger LOGGER = LogManager.getLogger();

    // The value here should match an entry in the META-INF/mods.toml file
    public static final String MOD_ID = "lovecraftplus";

    public static final ItemGroup ITEM_TAB = new ItemGroup("item_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemHandler.HUMMING_INGOT.get());
        }
    };

    public static final ItemGroup BLOCK_TAB = new ItemGroup("block_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockHandler.HUMMING_OBSIDIAN.get());
        }
    };

    public static final Item.Properties ITEM_TAB_PROP = new Item.Properties().group(ITEM_TAB);
    public static final Item.Properties BLOCK_TAB_PROP = new Item.Properties().group(BLOCK_TAB);

    public LovecraftPlusMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        BlockHandler.BLOCKS.register(modEventBus);
        ItemHandler.ITEMS.register(modEventBus);
        EntityTypeHandler.ENTITY_TYPES.register(modEventBus);
        BiomeHandler.BIOMES.register(modEventBus);
        MoonBiomeHandler.BIOMES.register(modEventBus);
        FeatureHandler.FEATURE.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        // modEventBus.addGenericListener(Structure.class, FeatureHandler::registerStructurePieces);
        modEventBus.addGenericListener(EntityType.class, this::onRegisterEntities);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::biomeLoading);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            GlobalEntityTypeAttributes.put(
                    EntityTypeHandler.MOON_FROG.get(),
                    MoonFrogEntity.setCustomAttributes().create());

            GlobalEntityTypeAttributes.put(
                    EntityTypeHandler.MOON_BEAST.get(),
                    MoonBeastEntity.setCustomAttributes().create());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockHandler.THORN_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockHandler.THORN_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockHandler.MOON_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockHandler.THORN_DOOR.get(), RenderType.getCutout());

        RenderingRegistry.registerEntityRenderingHandler(
                EntityTypeHandler.MOON_BEAST.get(),
                MoonBeastRender::new);

        RenderingRegistry.registerEntityRenderingHandler(
                EntityTypeHandler.MOON_FROG.get(),
                MoonFrogRender::new);
    }

    private void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        CustomSpawnEggItem.initSpawnEggs();
    }

    public void biomeLoading(BiomeLoadingEvent event) {
        MoonBiomeHandler.biomeLoading(event);
        BiomeHandler.biomeLoading(event);
        FeatureGen.addFeaturesToBiomes(event);
        StructureGen.generateStructures(event);
    }
}