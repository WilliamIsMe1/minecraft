package net.minecraft.block.natural;

import net.minecraft.block.core.Block;
import net.minecraft.block.material.Material;

public class BlockSandStone extends Block {
	public BlockSandStone(int var1) {
		super(var1, 192, Material.rock);
	}

	public int getBlockTextureFromSide(int var1) {
		return var1 == 1 ? this.getBlockIndexInTexture() - 16 : (var1 == 0 ? this.getBlockIndexInTexture() + 16 : this.getBlockIndexInTexture());
	}
}
