package net.minecraft.block.natural;

import net.minecraft.block.core.Block;
import net.minecraft.block.material.Material;
import net.minecraft.misc.AxisAlignedBB;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockSoulSand extends Block {
	public BlockSoulSand(int var1, int var2) {
		super(var1, var2, Material.sand);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
		float var5 = 2.0F / 16.0F;
		return AxisAlignedBB.getBoundingBoxFromPool(var2, var3, var4, var2 + 1, (float)(var3 + 1) - var5, var4 + 1);
	}

	public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5) {
		var5.motionX *= 0.4D;
		var5.motionZ *= 0.4D;
	}
}
