package com.mechanicus.common.gui.container;

import com.mechanicus.common.entity.MEntityServoSkull;
import com.mechanicus.registry.ContainerRegistry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ServoSkullContainer extends Container {
	private IItemHandler skull_inventory;
	private IItemHandler playerInventory;
		
	private MEntityServoSkull skull;
	
	public ServoSkullContainer(int windowId, PlayerInventory playerInventory, int entityID ) {
		super(ContainerRegistry.SERVO_SKULL, windowId);
		Entity ent = playerInventory.player.world.getEntityByID(entityID);
		skull = (MEntityServoSkull) ent;
		this.playerInventory = new InvWrapper(playerInventory);
		layoutPlayerInventorySlots(6, 176);
		this.skull_inventory = new InvWrapper(skull.getInventory());
		
		
		addSlotBox(skull_inventory, 0, 10, 18, 1, 18, 5, 18);
		
		addSlot(new ServoSlot(skull_inventory, 5, 81, 54));
		addSlot(new ServoSlot(skull_inventory, 6, 101, 54));
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		// TODO Auto-generated method stub
		return true;
	}

	protected int getInventorySize() {
		return 7;
	}	
	
	private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
		for(int i = 0; i < amount; i++) {
			addSlot(new SlotItemHandler(handler, index, x, y));
			x+= dx;
			index++;
		}
		return index;
	}
	
	public int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
		for(int j = 0; j < verAmount; j++) {
			index = addSlotRange(handler,index,x,y,horAmount,dx);
			y += dy;
		}
		return index;
	}
	
	protected void layoutPlayerInventorySlots(int leftCol, int topRow) {
		addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);
		
		//hotbar
		topRow += 58;
		addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
	}
	
	public class ServoSlot extends SlotItemHandler {
		public ServoSlot(IItemHandler inventoryIn, int index, int xPosition, int yPosition) {
			super(inventoryIn, index, xPosition, yPosition);
			
		}
		@Override
		public boolean isItemValid(ItemStack stack) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
}
