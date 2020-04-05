package com.mechanicus.common.block;

import com.mechanicus.common.block.helper.IMItem;
import com.mechanicus.lib.MLib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.state.IProperty;
import net.minecraft.util.ResourceLocation;

public class MBaseBlock extends Block implements IMItem {
	public final String name;
	public Item itemBlock;
	
	public MBaseBlock(Properties properties, String registryName) {
		super(properties);
		this.name = registryName;
		this.setRegistryName(createRegistryName());
		this.itemBlock = new MBlockItem(this, new net.minecraft.item.Item.Properties().group(MLib.mechanicus)).setRegistryName(registryName);
	}

	public ResourceLocation createRegistryName()
	{
		return new ResourceLocation(MLib.MODID, name);
	}
	
	@Override
	public Item getItemBlock() {
		// TODO Auto-generated method stub
		return itemBlock;
	}
}
