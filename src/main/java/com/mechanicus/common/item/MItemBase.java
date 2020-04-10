package com.mechanicus.common.item;

import com.mechanicus.util.JsonGenerator;

import net.minecraft.item.Item;

public class MItemBase extends Item {

	public MItemBase(Properties properties, String registryName) {
		super(properties);
		this.setRegistryName(registryName);
		JsonGenerator generator = new JsonGenerator();
		generator.generateDefaultItem(registryName);
	}

}
