package net.minecraft.block;

import net.minecraft.block.core.Block;
import net.minecraft.block.material.Material;

public class BlockOreStorage extends Block {
	public BlockOreStorage(int var1, int var2) {
		super(var1, Material.iron);
		this.setBlockIndexInTexture(var2);
	}
}
