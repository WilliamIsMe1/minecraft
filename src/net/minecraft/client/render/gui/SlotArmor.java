package net.minecraft.client.render.gui;

import net.minecraft.block.Block;
import net.minecraft.item.IInventory;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ContainerPlayer;

public class SlotArmor extends Slot {
	final int armorType;
	final ContainerPlayer inventory;

	SlotArmor(ContainerPlayer var1, IInventory var2, int var3, int var4, int var5, int var6) {
		super(var2, var3, var4, var5);
		this.inventory = var1;
		this.armorType = var6;
	}

	public int getSlotStackLimit() {
		return 1;
	}

	public boolean isItemValid(ItemStack var1) {
		return var1.getItem() instanceof net.minecraft.item.ItemArmor ? ((ItemArmor)var1.getItem()).armorType == this.armorType : (var1.getItem().shiftedIndex == Block.pumpkin.blockID ? this.armorType == 0 : false);
	}
}
