package net.minecraft.block.redstone;

import net.minecraft.block.core.Block;
import net.minecraft.block.core.IBlockAccess;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import java.util.Random;

public class BlockLockedChest extends Block {
	public BlockLockedChest(int var1) {
		super(var1, Material.wood);
		this.setBlockIndexInTexture(26);
	}

	public int getBlockTexture(IBlockAccess var1, int var2, int var3, int var4, int var5) {
		if(var5 == 1) {
			return this.getBlockIndexInTexture() - 1;
		} else if(var5 == 0) {
			return this.getBlockIndexInTexture() - 1;
		} else {
			int var6 = var1.getBlockId(var2, var3, var4 - 1);
			int var7 = var1.getBlockId(var2, var3, var4 + 1);
			int var8 = var1.getBlockId(var2 - 1, var3, var4);
			int var9 = var1.getBlockId(var2 + 1, var3, var4);
			byte var10 = 3;
			if(Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var7]) {
				var10 = 3;
			}

			if(Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var6]) {
				var10 = 2;
			}

			if(Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var9]) {
				var10 = 5;
			}

			if(Block.opaqueCubeLookup[var9] && !Block.opaqueCubeLookup[var8]) {
				var10 = 4;
			}

			return var5 == var10 ? this.getBlockIndexInTexture() + 1 : this.getBlockIndexInTexture();
		}
	}

	public int getBlockTextureFromSide(int var1) {
		return var1 == 1 ? this.getBlockIndexInTexture() - 1 : (var1 == 0 ? this.getBlockIndexInTexture() - 1 : (var1 == 3 ? this.getBlockIndexInTexture() + 1 : this.getBlockIndexInTexture()));
	}

	public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
		return true;
	}

	public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
		var1.setBlockWithNotify(var2, var3, var4, 0);
	}
}
