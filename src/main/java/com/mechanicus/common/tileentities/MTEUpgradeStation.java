package com.mechanicus.common.tileentities;

import com.mechanicus.registry.TileEntityRegistry;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.extensions.IForgeTileEntity;

public class MTEUpgradeStation extends TileEntity implements IForgeTileEntity {
	public int ticksExisted;

	public MTEUpgradeStation() {
		super(TileEntityRegistry.UPGRADE_STATION);
		ticksExisted = 0;
	}
}
