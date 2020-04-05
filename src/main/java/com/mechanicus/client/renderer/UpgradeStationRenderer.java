package com.mechanicus.client.renderer;

import com.mechanicus.common.tileentities.MTEUpgradeStation;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class UpgradeStationRenderer extends TileEntityRenderer<MTEUpgradeStation>
{
	  @Override
	  public void render (MTEUpgradeStation tile, double x, double y, double z, float partialTickTime, int destroyStage) {
		  if (tile == null)
	            return;

	        World world = tile.getWorld();
	        if (world == null)
	            return;
	  }

}
