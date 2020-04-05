package com.mechanicus.registry;

import java.util.ArrayList;

import com.mechanicus.common.block.MBaseBlock;
import com.mechanicus.common.block.MUpgradeStation;
import com.mechanicus.common.block.helper.IMItem;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;

public class BlockRegistry {

	public static ArrayList<Block> registeredBlock = new ArrayList<Block>();
	public static Properties defaultProperties = Properties.create(Material.ROCK);
	
	public static Block UPGRADE_STATION;
	
	public static void initializeBlocks() {
		registeredBlock.add(new MBaseBlock(defaultProperties, "ore_adamantium"));
		registeredBlock.add(new MBaseBlock(defaultProperties, "adamantium_block"));
		registeredBlock.add(new MBaseBlock(defaultProperties, "plasteel_block"));
		registeredBlock.add(new MBaseBlock(defaultProperties, "ore_auramite"));
		registeredBlock.add(new MBaseBlock(defaultProperties, "auramite_block"));
		registeredBlock.add(new MBaseBlock(defaultProperties, "noctilith_ore"));
		registeredBlock.add(new MBaseBlock(defaultProperties, "noctilith_block"));
		registeredBlock.add(new MBaseBlock(defaultProperties, "ouslite_block"));
		registeredBlock.add(new MBaseBlock(defaultProperties, "processed_ouslite"));
		registeredBlock.add(UPGRADE_STATION = new MUpgradeStation(defaultProperties, "upgrade_station"));
	}
	
	public static void parseBlockRegistry(Register<Block> event) {
		initializeBlocks();
		for(Block b : registeredBlock) {
			event.getRegistry().register(b);
		}
	}
	
	public static void parseItemRegistry(Register<Item> event) {
		for(Block b : registeredBlock) {
			if(b instanceof IMItem) {
				event.getRegistry().register(((IMItem) b).getItemBlock());
			}
		}
	}
}
