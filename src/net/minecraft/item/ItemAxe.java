package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.src.EnumToolMaterial;

public class ItemAxe extends ItemTool {
	private static net.minecraft.block.Block[] blocksEffectiveAgainst = new net.minecraft.block.Block[]{net.minecraft.block.Block.planks, net.minecraft.block.Block.bookShelf, net.minecraft.block.Block.wood, Block.chest};

	protected ItemAxe(int var1, EnumToolMaterial var2) {
		super(var1, 3, var2, blocksEffectiveAgainst);
	}
}
