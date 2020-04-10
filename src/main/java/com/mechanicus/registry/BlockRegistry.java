package com.mechanicus.registry;

import java.util.ArrayList;

import com.mechanicus.common.block.MBaseBlock;
import com.mechanicus.common.block.MBlockFastMove;
import com.mechanicus.common.block.MUpgradeStation;
import com.mechanicus.common.block.helper.IMItem;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent.Register;

public class BlockRegistry {

	public static ArrayList<Block> registeredBlock = new ArrayList<Block>();
	
	
	public static Block UPGRADE_STATION;
	
	public static void initializeBlocks() {
		registeredBlock.add(new MBaseBlock(Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(10f, 10f), "ore_adamantium"));
		registeredBlock.add(new MBaseBlock(Properties.create(Material.IRON), "adamantium_block"));
		registeredBlock.add(new MBaseBlock(Properties.create(Material.IRON), "plasteel_block"));
		registeredBlock.add(new MBaseBlock(Properties.create(Material.ROCK), "ore_auramite"));
		registeredBlock.add(new MBaseBlock(Properties.create(Material.IRON), "auramite_block"));
		registeredBlock.add(new MBaseBlock(Properties.create(Material.ROCK), "ore_noctilith"));
		registeredBlock.add(new MBaseBlock(Properties.create(Material.ROCK), "noctilith_block"));
		registeredBlock.add(new MBaseBlock(Properties.create(Material.ROCK), "ouslite_block"));
		registeredBlock.add(new MBlockFastMove(Properties.create(Material.ROCK), "processed_ouslite"));
		registeredBlock.add(UPGRADE_STATION = new MUpgradeStation(Properties.create(Material.IRON), "upgrade_station"));
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
