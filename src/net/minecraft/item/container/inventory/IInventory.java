package net.minecraft.item.container.inventory;

import net.minecraft.entity.living.EntityPlayer;
import net.minecraft.item.core.ItemStack;

public interface IInventory {
	int getSizeInventory();

	ItemStack getStackInSlot(int var1);

	ItemStack decrStackSize(int var1, int var2);

	void setInventorySlotContents(int var1, ItemStack var2);

	String getInvName();

	int getInventoryStackLimit();

	void onInventoryChanged();

	boolean canInteractWith(EntityPlayer var1);
}
