package net.minecraft.block.natural;

import net.minecraft.block.core.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.core.Item;

import java.util.Random;

public class BlockOre extends Block {
	public BlockOre(int var1, int var2) {
		super(var1, var2, Material.rock);
	}

	public int idDropped(int var1, Random var2) {
		if (this.getBlockID() == Block.oreCoal.getBlockID()) {
			return Item.coal.shiftedIndex;
		} else if (this.getBlockID() == Block.oreDiamond.getBlockID()) {
			return Item.diamond.shiftedIndex;
		} else if (this.getBlockID() == Block.oreLapis.getBlockID()) {
			return Item.dyePowder.shiftedIndex;
		} else {
			return this.getBlockID();
		}
	}

	public int quantityDropped(Random var1) {
		return this.getBlockID() == Block.oreLapis.getBlockID() ? 4 + var1.nextInt(5) : 1;
	}

	protected int damageDropped(int var1) {
		return this.getBlockID() == Block.oreLapis.getBlockID() ? 4 : 0;
	}
}
