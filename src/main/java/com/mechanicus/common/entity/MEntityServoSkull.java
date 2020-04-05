package com.mechanicus.common.entity;

import com.mechanicus.client.sound.MSoundRegistry;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class MEntityServoSkull extends AnimalEntity {

	public MEntityServoSkull(EntityType<? extends MEntityServoSkull> type, World worldIn) {
		super(type, worldIn);
		this.stepHeight = 1.0f;
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.16D);
	}
 
	@Override
    protected SoundEvent getAmbientSound() {
		return MSoundRegistry.SERVO_SKULL_AMBIENT;
	}
	
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return MSoundRegistry.SERVO_SKULL_AMBIENT;
    }
	
	@Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new LookRandomlyGoal(this));
	}
	
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
