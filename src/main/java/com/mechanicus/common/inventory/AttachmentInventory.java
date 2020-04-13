package com.mechanicus.common.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;

public class AttachmentInventory extends Inventory {
	
	public AttachmentInventory() {
		super(4);
	}
	
	public void read(ListNBT p_70486_1_) {
	      for(int i = 0; i < this.getSizeInventory(); ++i) {
	         this.setInventorySlotContents(i, ItemStack.EMPTY);
	      }

	      for(int k = 0; k < p_70486_1_.size(); ++k) {
	         CompoundNBT compoundnbt = p_70486_1_.getCompound(k);
	         int j = compoundnbt.getByte("Slot") & 255;
	         if (j >= 0 && j < this.getSizeInventory()) {
	            this.setInventorySlotContents(j, ItemStack.read(compoundnbt));
	         }
	      }

	   }

	   public ListNBT write() {
	      ListNBT listnbt = new ListNBT();

	      for(int i = 0; i < this.getSizeInventory(); ++i) {
	         ItemStack itemstack = this.getStackInSlot(i);
	         if (!itemstack.isEmpty()) {
	            CompoundNBT compoundnbt = new CompoundNBT();
	            compoundnbt.putByte("Slot", (byte)i);
	            itemstack.write(compoundnbt);
	            listnbt.add(compoundnbt);
	         }
	      }

	      return listnbt;	      
	   }
}
