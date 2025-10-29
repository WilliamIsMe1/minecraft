package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.src.EnumToolMaterial;

public class ItemSpade extends ItemTool {
	private static net.minecraft.block.Block[] blocksEffectiveAgainst = new net.minecraft.block.Block[]{net.minecraft.block.Block.grass, net.minecraft.block.Block.dirt, net.minecraft.block.Block.sand, net.minecraft.block.Block.gravel, net.minecraft.block.Block.snow, net.minecraft.block.Block.blockSnow, net.minecraft.block.Block.blockClay, net.minecraft.block.Block.tilledField};

	public ItemSpade(int var1, EnumToolMaterial var2) {
		super(var1, 1, var2, blocksEffectiveAgainst);
	}

	public boolean canHarvestBlock(net.minecraft.block.Block var1) {
		return var1 == net.minecraft.block.Block.snow ? true : var1 == Block.blockSnow;
	}
}
