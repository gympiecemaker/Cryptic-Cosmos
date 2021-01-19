package com.crypticcosmos.crypticcosmos.creatures.moon_frog;// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.Utils;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class MoonFrogModel extends AnimatedGeoModel<MoonFrogEntity>{

    @Override
    public ResourceLocation getModelLocation(MoonFrogEntity moonFrogEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "geo/moonfrog.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MoonFrogEntity moonFrogEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "textures/entity/moon_frog.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MoonFrogEntity moonFrogEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "animations/moonfrog.json");
    }

    @Override
    public void setLivingAnimations(MoonFrogEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData data = (EntityModelData) customPredicate.getExtraData().get(0);
        // Apply head look to model
        IBone head = this.getAnimationProcessor().getBone("Head");
        head.setRotationY((float) Math.toRadians(Utils.clamp(data.netHeadYaw, -45, 45)));
        head.setRotationX(-(float) Math.toRadians(data.headPitch));
    }
}