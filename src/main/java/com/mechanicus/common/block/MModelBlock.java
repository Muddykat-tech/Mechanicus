package com.mechanicus.common.block;

import net.minecraft.block.Block.Properties;
import net.minecraft.block.BlockState;

public class MModelBlock extends MBaseBlock {

	public MModelBlock(Properties properties, String registryName) {
		super(properties, registryName);
		
	}
	
	@Override
	public boolean hasTileEntity(BlockState state)
	{
		return true;
	}
	
	
}
