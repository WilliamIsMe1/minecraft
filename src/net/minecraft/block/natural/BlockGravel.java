package net.minecraft.block.natural;

import net.minecraft.item.core.Item;

import java.util.Random;

public class BlockGravel extends BlockSand {
	public BlockGravel(int var1, int var2) {
		super(var1, var2);
	}

	public int idDropped(int var1, Random var2) {
		if (var2.nextInt(10) == 0) {
			return Item.flint.shiftedIndex;
		} else {
			return blockID;
		}
	}
}
