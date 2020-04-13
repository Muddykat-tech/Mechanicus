package com.mechanicus.client;

import com.mechanicus.client.renderer.RenderPlayerMechanicus;
import com.mechanicus.common.entity.MEntityServoSkull;
import com.mechanicus.common.inventory.AttachmentInventory;
import com.mechanicus.lib.MLib;
import com.mechanicus.registry.EntityRegistry;
import com.mechanicus.registry.ItemRegistry;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientHandler {

	@SubscribeEvent
	public void handlePostRenderPlayer_High(RenderPlayerEvent.Pre event) {
		//TODO this is really inefficient, constantly making a new Inventory on tick, find a better way!
		// could use a void event to make the new inventory on container close?
		AttachmentInventory attachmentInventory = new AttachmentInventory();
		float ptick = event.getPartialRenderTick();
		PlayerEntity player = event.getPlayer();
		if(player.getPersistentData().contains(MLib.MODID + "_attachment")) {
			INBT items = player.getPersistentData().get(MLib.MODID + "_attachment");
			if(items instanceof ListNBT) {
				attachmentInventory.read((ListNBT) items);
			}
		}
		
		//TODO test if I can access the players skin via these commands below!
		//GlStateManager.setProfile(GlStateManager.Profile.PLAYER_SKIN);
        //GlStateManager.unsetProfile(GlStateManager.Profile.PLAYER_SKIN);
        
		//TODO Renderer doesn't work correctly, perhaps make an unused entity to parse as it's model holder? or bind textures to the current players model?
		//TODO Allow Upgrades/Attachments to have 'upgrades' or modules such as claws or drills!
		if(event.getRenderer().getRenderManager() != null) {
			RenderPlayerMechanicus renderer = new RenderPlayerMechanicus(event.getRenderer().getRenderManager());
			
			if(attachmentInventory.getStackInSlot(0).getItem() == ItemRegistry.UPGRADE_RIGHT_ARM_PLASTEEL) {
				
					renderer.renderRightArm(Minecraft.getInstance().player);
					
			}
		}
		
		if(attachmentInventory.getStackInSlot(1).getItem() == ItemRegistry.UPGRADE_LEFT_ARM_PLASTEEL) {
			
		}
		event.setCanceled(true);
	}

	@SubscribeEvent
	public void handlerSpecialModelRender(RenderHandEvent event) {

	}
}
