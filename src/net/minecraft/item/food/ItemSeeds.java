package net.minecraft.item.food;

import net.minecraft.block.core.Block;
import net.minecraft.entity.living.EntityPlayer;
import net.minecraft.item.core.Item;
import net.minecraft.item.core.ItemStack;
import net.minecraft.world.World;

public class ItemSeeds extends Item {
	private int field_318_a;

	public ItemSeeds(int var1, int var2) {
		super(var1);
		this.field_318_a = var2;
	}

	public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
		if(var7 != 1) {
			return false;
		} else {
			int var8 = var3.getBlockId(var4, var5, var6);
			if(var8 == Block.tilledField.getBlockID() && var3.isAirBlock(var4, var5 + 1, var6)) {
				var3.setBlockWithNotify(var4, var5 + 1, var6, this.field_318_a);
				--var1.stackSize;
				return true;
			} else {
				return false;
			}
		}
	}
}
