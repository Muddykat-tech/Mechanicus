package com.mechanicus.registry;

import java.util.ArrayList;

import com.mechanicus.common.item.MItemBase;
import com.mechanicus.common.item.MResourceItemBase;
import com.mechanicus.common.item.MUpgradeAttachement;
import com.mechanicus.lib.MLib;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.event.RegistryEvent.Register;

public class ItemRegistry {

	public static ArrayList<Item> registeredItems = new ArrayList<Item>();	
	public static MItemBase ADAMANTIUM_INGOT, PLASTEEL_INGOT, AURAMITE_INGOT, NOCTILITH_STONE, UNKNOWN_MACHINE_PART, DRILL_PART;
	public static MResourceItemBase EFFICIENCY_UPGRADE_PLASTEEL, EFFICIENCY_UPGRADE_AURAMITE, EFFICIENCY_UPGRADE_ADAMANTIUM, EFFICIENCY_UPGRADE_NOCTILITH;
	public static MResourceItemBase DRILL_PLASTEEL, DRILL_AURAMITE, DRILL_ADAMANTIUM, DRILL_NOCTILITH;
	public static MUpgradeAttachement UPGRADE_RIGHT_ARM_PLASTEEL, UPGRADE_LEFT_ARM_PLASTEEL;
	public static MResourceItemBase PLASTEEL_PLATING, AURAMITE_PLATING, ADAMANTIUM_PLATING, NOCTILITH_PLATING;
	
	public static void initialize() {
		registeredItems.add(PLASTEEL_INGOT = new MItemBase(new Properties().group(MLib.mechanicus), "plasteel_ingot"));
		registeredItems.add(AURAMITE_INGOT = new MItemBase(new Properties().group(MLib.mechanicus), "auramite_ingot"));
		registeredItems.add(NOCTILITH_STONE = new MItemBase(new Properties().group(MLib.mechanicus), "noctilith_stone"));
		registeredItems.add(ADAMANTIUM_INGOT = new MItemBase(new Properties().group(MLib.mechanicus), "adamantium_ingot"));
		registeredItems.add(UNKNOWN_MACHINE_PART = new MItemBase(new Properties().group(MLib.mechanicus).maxStackSize(16), "unknown_machine_part"));
		
		registeredItems.add(EFFICIENCY_UPGRADE_PLASTEEL = new MResourceItemBase(new Properties().group(MLib.mechanicus).maxStackSize(1),"efficiency_upgrade_plasteel"));
		registeredItems.add(EFFICIENCY_UPGRADE_AURAMITE = new MResourceItemBase(new Properties().group(MLib.mechanicus).maxStackSize(1),"efficiency_upgrade_auramite"));
		registeredItems.add(EFFICIENCY_UPGRADE_ADAMANTIUM = new MResourceItemBase(new Properties().group(MLib.mechanicus).maxStackSize(1),"efficiency_upgrade_adamantium"));
		registeredItems.add(EFFICIENCY_UPGRADE_NOCTILITH = new MResourceItemBase(new Properties().group(MLib.mechanicus).maxStackSize(1),"efficiency_upgrade_noctilith"));
		
		registeredItems.add(DRILL_PLASTEEL = new MResourceItemBase(new Properties().group(MLib.mechanicus).maxStackSize(1),"drill_plasteel"));
		registeredItems.add(DRILL_AURAMITE = new MResourceItemBase(new Properties().group(MLib.mechanicus).maxStackSize(1),"drill_auramite"));
		registeredItems.add(DRILL_ADAMANTIUM = new MResourceItemBase(new Properties().group(MLib.mechanicus).maxStackSize(1),"drill_adamantium"));
		registeredItems.add(DRILL_NOCTILITH = new MResourceItemBase(new Properties().group(MLib.mechanicus).maxStackSize(1),"drill_noctilith"));
		
		registeredItems.add(UPGRADE_RIGHT_ARM_PLASTEEL = new MUpgradeAttachement(new Properties().group(MLib.mechanicus).maxStackSize(1),"plasteel_right_arm"));
		registeredItems.add(UPGRADE_LEFT_ARM_PLASTEEL = new MUpgradeAttachement(new Properties().group(MLib.mechanicus).maxStackSize(1),"plasteel_left_arm"));
	
		registeredItems.add(PLASTEEL_PLATING = new MResourceItemBase(new Properties().group(MLib.mechanicus).maxStackSize(16),"plasteel_plating"));
		registeredItems.add(AURAMITE_PLATING = new MResourceItemBase(new Properties().group(MLib.mechanicus).maxStackSize(16),"auramite_plating"));
		registeredItems.add(ADAMANTIUM_PLATING = new MResourceItemBase(new Properties().group(MLib.mechanicus).maxStackSize(16),"adamantium_plating"));
		registeredItems.add(NOCTILITH_PLATING = new MResourceItemBase(new Properties().group(MLib.mechanicus).maxStackSize(16),"noctilith_plating"));

	}
	
	public static void parseItemRegistry(Register<Item> event) {
		initialize();
		for (Item i : registeredItems) {
			event.getRegistry().register(i);
		}
	}	
}
