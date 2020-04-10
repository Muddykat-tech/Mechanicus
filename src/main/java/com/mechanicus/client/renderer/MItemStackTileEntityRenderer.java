package com.mechanicus.client.renderer;

import com.mechanicus.common.block.MUpgradeStation;
import com.mechanicus.common.tileentities.MTEUpgradeStation;

import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MItemStackTileEntityRenderer extends ItemStackTileEntityRenderer {

	MTEUpgradeStation upgrade_station = new MTEUpgradeStation();
	
	@Override
	public void renderByItem(ItemStack itemStackIn) {
		Item item = itemStackIn.getItem();
		if(item instanceof BlockItem && ((BlockItem)item).getBlock() instanceof MUpgradeStation) {
			TileEntityRendererDispatcher.instance.renderAsItem(this.upgrade_station);
		}
		//super.renderByItem(itemStackIn);
	}
	
}
