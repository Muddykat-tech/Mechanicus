package com.mechanicus.registry;

import java.util.ArrayList;

import com.mechanicus.common.block.MUpgradeStation;
import com.mechanicus.common.tileentities.MTEUpgradeStation;
import com.mechanicus.lib.MLib;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;

public class TileEntityRegistry {
	public static ArrayList<TileEntityType<?>> registeredTileEntities = new ArrayList<TileEntityType<?>>();
	
	public static TileEntityType<MTEUpgradeStation> UPGRADE_STATION;
	
	
	public static void prepareTileEntities() {
		registeredTileEntities.add(UPGRADE_STATION);
	}
	
	public static void parseTileEntityRegistry(RegistryEvent.Register<TileEntityType<?>> evt) {
		for(TileEntityType<?> type : registeredTileEntities) {
		  type = TileEntityType.Builder.create(MTEUpgradeStation::new).build(null);
		  type.setRegistryName(MLib.MODID, "tile_" + MUpgradeStation.getName());
		  evt.getRegistry().register(type);
		}
	}

}
