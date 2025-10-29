package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;

public class ItemShears extends Item {
	public ItemShears(int var1) {
		super(var1);
		this.setMaxStackSize(1);
		this.setMaxDamage(238);
	}

	public boolean onBlockDestroyed(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
		if(var2 == net.minecraft.block.Block.leaves.blockID || var2 == net.minecraft.block.Block.web.blockID) {
			var1.damageItem(1, var6);
		}

		return super.onBlockDestroyed(var1, var2, var3, var4, var5, var6);
	}

	public boolean canHarvestBlock(net.minecraft.block.Block var1) {
		return var1.blockID == net.minecraft.block.Block.web.blockID;
	}

	public float getStrVsBlock(ItemStack var1, net.minecraft.block.Block var2) {
		return var2.blockID != net.minecraft.block.Block.web.blockID && var2.blockID != net.minecraft.block.Block.leaves.blockID ? (var2.blockID == Block.cloth.blockID ? 5.0F : super.getStrVsBlock(var1, var2)) : 15.0F;
	}
}
