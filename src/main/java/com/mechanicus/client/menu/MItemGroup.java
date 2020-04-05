package com.mechanicus.client.menu;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class MItemGroup extends ItemGroup {

	public MItemGroup(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack createIcon() {
		// TODO Auto-generated method stub
		return new ItemStack(Items.SKELETON_SKULL);
	}

}
