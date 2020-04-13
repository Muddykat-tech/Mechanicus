package com.mechanicus.client.renderer;

import com.mechanicus.lib.MLib;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderPlayerMechanicus extends PlayerRenderer {

	public RenderPlayerMechanicus(EntityRendererManager renderManager) {
		super(renderManager);
		// TODO Auto-generated constructor stub
	}
	
	private static final ResourceLocation robo = new ResourceLocation(MLib.MODID,"textures/entity/player/default.png");
	
	@Override
	public void renderRightArm(AbstractClientPlayerEntity clientPlayer)
	{
		
		Minecraft.getInstance().getTextureManager().bindTexture(robo);
		super.renderRightArm(clientPlayer);
	}
}
