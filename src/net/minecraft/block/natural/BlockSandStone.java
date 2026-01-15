package net.minecraft.block.natural;

import net.minecraft.block.core.Block;
import net.minecraft.block.material.Material;

public class BlockSandStone extends Block {
	public BlockSandStone(int var1) {
		super(var1, 192, Material.rock);
	}

	public int getBlockTextureFromSide(int var1) {
		if (var1 == 1) {
			return blockIndexInTexture - 16;
		} else {
			if (var1 == 0) {
				return (blockIndexInTexture + 16);
			} else {
				return blockIndexInTexture;
			}
		}
	}
}
