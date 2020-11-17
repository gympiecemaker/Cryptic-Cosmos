package com.hauntedchest.lovecraftplus.registries;

import com.hauntedchest.lovecraftplus.LovecraftPlusMod;
import com.hauntedchest.lovecraftplus.world.feature.structures.MoonPillarPieces;
import com.hauntedchest.lovecraftplus.world.feature.structures.MoonPillarStructure;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;

public class FeatureHandler {
    public static final DeferredRegister<Structure<?>> FEATURE =
            DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, LovecraftPlusMod.MOD_ID);
    public static final RegistryObject<MoonPillarStructure> MOON_PILLAR =
            FEATURE.register("moon_pillar", () -> new MoonPillarStructure(NoFeatureConfig.field_236558_a_));

    public static IStructurePieceType MOON_PILLAR_PIECE = MoonPillarPieces.Piece::new;

    public static void registerStructurePieces(RegistryEvent.Register<Structure<?>> event) {
        Registry.register(Registry.STRUCTURE_PIECE,
                "MOON_PILLAR".toLowerCase(Locale.ROOT), MOON_PILLAR_PIECE);
    }
}
