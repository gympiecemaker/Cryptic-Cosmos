package com.hauntedchest.lovecraftplus.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class MoonBeastEntity extends MonsterEntity {
    public MoonBeastEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI() {
        this.goalSelector.addGoal(4, new SwimGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));

        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, EndermanEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return func_234295_eP_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 50f)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5f)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 6f)
                .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 4f);
    }

    protected int getExperiencePoints(@Nonnull PlayerEntity player) {
        if (this.isChild()) {
            this.experienceValue = (int) ((float) this.experienceValue * 4F);
        }

        return super.getExperiencePoints(player);
    }

}
