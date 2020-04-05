package com.mechanicus.common.item;

import net.minecraft.item.Item;

public class MItemBase extends Item {

	public MItemBase(Properties properties, String registryName) {
		super(properties);
		this.setRegistryName(registryName);
	}

}
