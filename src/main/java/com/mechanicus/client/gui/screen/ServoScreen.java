package com.mechanicus.client.gui.screen;

import com.mechanicus.common.gui.container.ServoSkullContainer;
import com.mechanicus.lib.MLib;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ServoScreen extends ContainerScreen<ServoSkullContainer> {
	
	private float mousePosx;
	private float mousePosY;
	public static final ResourceLocation guiTextures1 = new ResourceLocation(MLib.MODID, "textures/gui/servo_skull_screen.png");

	public ServoScreen(ServoSkullContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.xSize = 256;
		this.ySize = 256;
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
	{
		// TODO Auto-generated method stub
		this.renderBackground();
		this.mousePosx = (float)mouseX;
		this.mousePosY = (float)mouseY;
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
		GlStateManager.color3f(1.0F, 1.0F, 1.0F);
		getMinecraft().getTextureManager().bindTexture(guiTextures1);
		this.blit(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
