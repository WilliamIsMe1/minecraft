package net.minecraft.client.render.gui;

import net.minecraft.achievement.AchievementList;
import net.minecraft.entity.EntityPlayer;
import net.minecraft.item.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotFurnace extends Slot {
	private net.minecraft.entity.EntityPlayer thePlayer;

	public SlotFurnace(EntityPlayer var1, IInventory var2, int var3, int var4, int var5) {
		super(var2, var3, var4, var5);
		this.thePlayer = var1;
	}

	public boolean isItemValid(net.minecraft.item.ItemStack var1) {
		return false;
	}

	public void onPickupFromSlot(ItemStack var1) {
		var1.onCrafting(this.thePlayer.worldObj, this.thePlayer);
		if(var1.itemID == net.minecraft.item.Item.ingotIron.shiftedIndex) {
			this.thePlayer.addStat(net.minecraft.achievement.AchievementList.acquireIron, 1);
		}

		if(var1.itemID == Item.fishCooked.shiftedIndex) {
			this.thePlayer.addStat(AchievementList.cookFish, 1);
		}

		super.onPickupFromSlot(var1);
	}
}
