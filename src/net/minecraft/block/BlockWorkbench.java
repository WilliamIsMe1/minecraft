package net.minecraft.block;

import net.minecraft.block.core.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.living.EntityPlayer;
import net.minecraft.world.World;

public class BlockWorkbench extends Block {
	public BlockWorkbench(int var1) {
		super(var1, Material.wood);
		this.setBlockIndexInTexture(59);
	}

	@Override
	public int getBlockTextureFromSide(int var1) {
		return var1 == 1 ? this.getBlockIndexInTexture() - 16 : (var1 == 0 ? Block.planks.getBlockTextureFromSide(0) : (var1 != 2 && var1 != 4 ? this.getBlockIndexInTexture() : this.getBlockIndexInTexture() + 1));
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
