package com.mechanicus.registry;

import java.util.ArrayList;
import java.util.function.Supplier;

import com.mechanicus.common.block.MUpgradeStation;
import com.mechanicus.common.tileentities.MTEUpgradeStation;
import com.mechanicus.lib.MLib;
import com.mechanicus.registry.helper.TileEntityNames;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

public class TileEntityRegistry {
	@ObjectHolder(TileEntityNames.UPGRADE_STATION)
    public static TileEntityType<?> UPGRADE_STATION;

	public static void parseTileEntityRegistry(RegistryEvent.Register<TileEntityType<?>> e) {

		e.getRegistry().registerAll(
                TileEntityType.Builder.create((Supplier<TileEntity>) MTEUpgradeStation::new, BlockRegistry.UPGRADE_STATION).build(null).setRegistryName(TileEntityNames.UPGRADE_STATION));
		
	}

}
