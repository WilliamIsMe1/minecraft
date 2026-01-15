package net.minecraft.block;

import net.minecraft.block.core.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.living.EntityPlayer;
import net.minecraft.world.World;

public class BlockWorkbench extends Block {
	public BlockWorkbench(int var1) {
		super(var1, Material.wood);
		this.blockIndexInTexture = 59;
	}

	@Override
	public int getBlockTextureFromSide(int var1) {
		if (var1 == 1) {
			return blockIndexInTexture - 16;
		} else {
			if (var1 == 0) {
				return (Block.planks.getBlockTextureFromSide(0));
			} else {
				if (var1 != 2 && var1 != 4) {
					return blockIndexInTexture;
				} else {
					return ((blockIndexInTexture + 1));
				}
			}
		}
	}

	@Override
	public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
		if(var1.multiplayerWorld) {
			return true;
		} else {
			var5.displayWorkbenchGUI(var2, var3, var4);
			return true;
		}
	}
}
