package com.mechanicus.common.block;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.mechanicus.common.tileentities.MTEUpgradeStation;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class MUpgradeStation extends MBaseBlock {

	public MUpgradeStation(Properties properties, String registryName) {
		super(properties, registryName);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
		return new MTEUpgradeStation();
	}

	
	public MTEUpgradeStation getTileEntity (IBlockReader blockAccess, BlockPos pos) {
        TileEntity tile = blockAccess.getTileEntity(pos);
        return (tile instanceof MTEUpgradeStation) ? (MTEUpgradeStation) tile : null;
    }
	
	public static String getName() {
		return "upgrade_station";
	}
}
