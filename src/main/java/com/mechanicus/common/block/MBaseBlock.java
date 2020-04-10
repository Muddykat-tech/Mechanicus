package com.mechanicus.common.block;

import java.io.IOException;

import com.mechanicus.common.block.helper.IMItem;
import com.mechanicus.lib.MLib;
import com.mechanicus.util.JsonGenerator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MBaseBlock extends Block implements IMItem {
	public final String name;
	public Item itemBlock;
	
	public MBaseBlock(Properties properties, String registryName) {
		super(properties);
		this.name = registryName;
		this.setRegistryName(createRegistryName());
		
		if(itemBlock == null)
		this.itemBlock = new MBlockItem(this, new net.minecraft.item.Item.Properties().group(MLib.mechanicus)).setRegistryName(registryName);
		
		JsonGenerator generation = new JsonGenerator();
		
		try {
			generation.generateDefaultBlock(registryName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResourceLocation createRegistryName()
	{
		return new ResourceLocation(MLib.MODID, name);
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

		worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ()));
		
		super.onBlockHarvested(worldIn, pos, state, player);
	}
	
	@Override
	public Item getItemBlock() {
		// TODO Auto-generated method stub
		return itemBlock;
	}
}
