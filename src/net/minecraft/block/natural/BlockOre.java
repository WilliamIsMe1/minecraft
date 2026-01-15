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
		if (blockID == Block.oreCoal.blockID) {
			return Item.coal.shiftedIndex;
		} else {
			if (blockID == Block.oreDiamond.blockID) {
				return Item.diamond.shiftedIndex;
			} else {
				if (blockID == Block.oreLapis.blockID) {
					return Item.dyePowder.shiftedIndex;
				} else {
					return blockID;
				}
			}
		}
	}

	public int quantityDropped(Random var1) {
		return blockID == Block.oreLapis.blockID ? 4 + var1.nextInt(5) : 1;
	}

	protected int damageDropped(int var1) {
		return blockID == Block.oreLapis.blockID ? 4 : 0;
	}
}
