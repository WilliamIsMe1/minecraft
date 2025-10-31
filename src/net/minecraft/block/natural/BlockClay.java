package net.minecraft.block.natural;

import net.minecraft.block.core.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.core.Item;

import java.util.Random;

public class BlockClay extends Block {
	public BlockClay(int var1, int var2) {
		super(var1, var2, Material.clay);
	}

	public int idDropped(int var1, Random var2) {
		return Item.clay.shiftedIndex;
	}

	public int quantityDropped(Random var1) {
		return 4;
	}
}
