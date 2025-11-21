package net.minecraft.item.container.inventory;

import net.minecraft.item.core.ItemStack;
import net.minecraft.item.container.Container;
import net.minecraft.entity.living.EntityPlayer;

public class InventoryCrafting implements IInventory {
	private final ItemStack[] stackList;
	private final int height;
	private final Container eventHandler;

	public InventoryCrafting(Container var1, int height, int width) {
		int var4 = height * width;
		this.stackList = new ItemStack[var4];
		this.eventHandler = var1;
		this.height = height;
	}

	public int getSizeInventory() {
		return this.stackList.length;
	}

	public ItemStack getStackInSlot(int var1) {
		return var1 >= this.getSizeInventory() ? null : this.stackList[var1];
	}

	public ItemStack func_21103_b(int var1, int var2) {
		if(var1 >= 0 && var1 < this.height) {
			int var3 = var1 + var2 * this.height;
			return this.getStackInSlot(var3);
		} else {
			return null;
		}
	}

	public String getInvName() {
		return "Crafting";
	}

	public ItemStack decrStackSize(int var1, int var2) {
		if(this.stackList[var1] != null) {
			ItemStack var3;
			if(this.stackList[var1].stackSize <= var2) {
				var3 = this.stackList[var1];
				this.stackList[var1] = null;
			} else {
				var3 = this.stackList[var1].splitStack(var2);
				if(this.stackList[var1].stackSize == 0) {
					this.stackList[var1] = null;
				}

			}
			this.eventHandler.onCraftMatrixChanged(this);
			return var3;
		} else {
			return null;
		}
	}

	public void setInventorySlotContents(int var1, ItemStack var2) {
		this.stackList[var1] = var2;
		this.eventHandler.onCraftMatrixChanged(this);
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public void onInventoryChanged() {
	}

	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}
}
