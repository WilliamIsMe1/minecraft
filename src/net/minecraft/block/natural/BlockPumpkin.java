package net.minecraft.block.natural;

import net.minecraft.block.core.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.living.EntityLiving;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockPumpkin extends Block {
	private boolean blockType;

	public BlockPumpkin(int var1, int var2, boolean var3) {
		super(var1, Material.pumpkin);
		this.setBlockIndexInTexture(var2);
		this.setTickOnLoad(true);
		this.blockType = var3;
	}

	public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
		if(var1 == 1) {
			return this.getBlockIndexInTexture();
		} else if(var1 == 0) {
			return this.getBlockIndexInTexture();
		} else {
			int var3 = this.getBlockIndexInTexture() + 1 + 16;
			if(this.blockType) {
				++var3;
			}

			return var2 == 2 && var1 == 2 ? var3 : (var2 == 3 && var1 == 5 ? var3 : (var2 == 0 && var1 == 3 ? var3 : (var2 == 1 && var1 == 4 ? var3 : this.getBlockIndexInTexture() + 16)));
		}
	}

	public int getBlockTextureFromSide(int var1) {
		return var1 == 1 ? this.getBlockIndexInTexture() : (var1 == 0 ? this.getBlockIndexInTexture() : (var1 == 3 ? this.getBlockIndexInTexture() + 1 + 16 : this.getBlockIndexInTexture() + 16));
	}

	public void onBlockAdded(World var1, int var2, int var3, int var4) {
		super.onBlockAdded(var1, var2, var3, var4);
	}

	public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
		int var5 = var1.getBlockId(var2, var3, var4);
		return (var5 == 0 || Block.blocksList[var5].getBlockMaterial().getIsGroundCover()) && var1.isBlockNormalCube(var2, var3 - 1, var4);
	}

	public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLiving var5) {
		int var6 = MathHelper.floor_double((double)(var5.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		var1.setBlockMetadataWithNotify(var2, var3, var4, var6);
	}
}
