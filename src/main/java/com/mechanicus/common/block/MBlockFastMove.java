package com.mechanicus.common.block;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MBlockFastMove extends MBaseBlock {

	public MBlockFastMove(Properties properties, String registryName) {
		super(properties, registryName);
		
	}
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		
		entityIn.setMotion(entityIn.getMotion().mul(1.4D, 1.0D, 1.4D));
		super.onEntityWalk(worldIn, pos, entityIn);
	}
}
