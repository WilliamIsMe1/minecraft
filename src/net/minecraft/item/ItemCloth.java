package net.minecraft.item;

import net.minecraft.block.core.Block;
import net.minecraft.block.BlockCloth;
import net.minecraft.item.core.ItemBlock;
import net.minecraft.item.core.ItemStack;

public class ItemCloth extends ItemBlock {
	public ItemCloth(int var1) {
		super(var1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public int getIconFromDamage(int var1) {
		return Block.cloth.getBlockTextureFromSideAndMetadata(2, net.minecraft.block.BlockCloth.func_21034_c(var1));
	}

	public int getPlacedBlockMetadata(int var1) {
		return var1;
	}

	public String getItemNameIS(ItemStack var1) {
		return super.getItemName() + "." + ItemDye.dyeColors[BlockCloth.func_21034_c(var1.getItemDamage())];
	}
}
