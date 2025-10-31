package net.minecraft.item.gear;

import net.minecraft.block.core.Block;
import net.minecraft.entity.living.EntityLiving;
import net.minecraft.item.core.ItemStack;
import net.minecraft.item.core.Item;

public class ItemShears extends Item {
	public ItemShears(int var1) {
		super(var1);
		this.setMaxStackSize(1);
		this.setMaxDamage(238);
	}

	public boolean onBlockDestroyed(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
		if(var2 == Block.leaves.getBlockID() || var2 == Block.web.getBlockID()) {
			var1.damageItem(1, var6);
		}

		return super.onBlockDestroyed(var1, var2, var3, var4, var5, var6);
	}

	public boolean canHarvestBlock(Block var1) {
		return var1.getBlockID() == Block.web.getBlockID();
	}

	public float getStrVsBlock(ItemStack var1, Block var2) {
		return var2.getBlockID() != Block.web.getBlockID() && var2.getBlockID() != Block.leaves.getBlockID() ? (var2.getBlockID() == Block.cloth.getBlockID() ? 5.0F : super.getStrVsBlock(var1, var2)) : 15.0F;
	}
}
