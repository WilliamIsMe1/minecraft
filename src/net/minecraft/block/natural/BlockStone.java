package net.minecraft.block.natural;

import net.minecraft.block.core.Block;
import net.minecraft.block.material.Material;

import java.util.Random;

public class BlockStone extends Block {
	public BlockStone(int var1, int var2) {
		super(var1, var2, Material.rock);
	}

	public int idDropped(int var1, Random var2) {
		return Block.cobblestone.getBlockID();
	}
}
