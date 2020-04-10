package com.mechanicus.common.tileentities;

import com.mechanicus.registry.TileEntityRegistry;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class MTEUpgradeStation extends TileEntity implements ITickableTileEntity {

	private float holoRot;
	
	public MTEUpgradeStation(TileEntityType<?> typeIn) {
		super(typeIn);
		holoRot = 0;
	}
	
	
	public MTEUpgradeStation() {
		this(TileEntityRegistry.UPGRADE_STATION);
	}
	
	@Override
	public void tick() {
		holoRot++;
		if(holoRot > 359) {
			holoRot = 0;
		}
	}

	public float getHoloRot() {
		// TODO Auto-generated method stub
		return holoRot;
	}

}
