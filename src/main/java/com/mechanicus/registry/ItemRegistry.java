package com.mechanicus.registry;

import java.util.ArrayList;

import com.mechanicus.common.item.MItemBase;
import com.mechanicus.lib.MLib;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.event.RegistryEvent.Register;

public class ItemRegistry {

	public static ArrayList<Item> registeredItems = new ArrayList<Item>();
	
	static Properties defaultProperties = new Properties();
	
	public static MItemBase SERVO_SKULL;
	
	public static void initialize() {
		
	}

	public static void parseItemRegistry(Register<Item> event) {
		initialize();
		for (Item i : registeredItems) {
			event.getRegistry().register(i);
		}
	}	
}
