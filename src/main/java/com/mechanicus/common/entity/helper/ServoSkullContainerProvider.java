package com.mechanicus.common.entity.helper;

import com.mechanicus.common.gui.container.ServoSkullContainer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.TextComponentMessageFormatHandler;
import net.minecraftforge.fml.network.IContainerFactory;

public class ServoSkullContainerProvider implements INamedContainerProvider {

	int id;
	
	public ServoSkullContainerProvider(int entityId) {
		this.id = entityId;
	}

	@Override
	public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity p_createMenu_3_) {
		// TODO Auto-generated method stub
		return new ServoSkullContainer(windowId, playerInventory, id);
	}

	@Override
	public ITextComponent getDisplayName() {
		// TODO Auto-generated method stub
		return new TranslationTextComponent("servo_skull_container");
	}

}