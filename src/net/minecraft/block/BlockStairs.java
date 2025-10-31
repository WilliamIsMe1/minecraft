package net.minecraft.block;

import net.minecraft.block.core.Block;
import net.minecraft.block.core.IBlockAccess;
import net.minecraft.core.MathHelper;
import net.minecraft.core.Vec3D;
import net.minecraft.entity.living.EntityPlayer;
import net.minecraft.entity.living.EntityLiving;
import net.minecraft.misc.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockStairs extends Block {
	private Block modelBlock;

	public BlockStairs(int var1, Block var2) {
		super(var1, var2.getBlockIndexInTexture(), var2.getBlockMaterial());
		this.modelBlock = var2;
		this.setHardness(var2.getBlockHardness());
		this.setResistance(var2.getBlockResistance() / 3.0F);
		this.setStepSound(var2.getStepSound());
		this.setLightOpacity(255);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public net.minecraft.misc.AxisAlignedBB getCollisionBoundingBoxFromPool(net.minecraft.world.World var1, int var2, int var3, int var4) {
		return super.getCollisionBoundingBoxFromPool(var1, var2, var3, var4);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 10;
	}

	public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5) {
		return super.shouldSideBeRendered(var1, var2, var3, var4, var5);
	}

	public void getCollidingBoundingBoxes(net.minecraft.world.World var1, int var2, int var3, int var4, net.minecraft.misc.AxisAlignedBB var5, ArrayList var6) {
		int var7 = var1.getBlockMetadata(var2, var3, var4);
		if(var7 == 0) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
			super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
			this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
		} else if(var7 == 1) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
			super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
			this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
		} else if(var7 == 2) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
			super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
			this.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
			super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
		} else if(var7 == 3) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
			super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
			this.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
			super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void randomDisplayTick(net.minecraft.world.World var1, int var2, int var3, int var4, Random var5) {
		this.modelBlock.randomDisplayTick(var1, var2, var3, var4, var5);
	}

	public void onBlockClicked(net.minecraft.world.World var1, int var2, int var3, int var4, EntityPlayer var5) {
		this.modelBlock.onBlockClicked(var1, var2, var3, var4, var5);
	}

	public void onBlockDestroyedByPlayer(net.minecraft.world.World var1, int var2, int var3, int var4, int var5) {
		this.modelBlock.onBlockDestroyedByPlayer(var1, var2, var3, var4, var5);
	}

	public float getBlockBrightness(IBlockAccess var1, int var2, int var3, int var4) {
		return this.modelBlock.getBlockBrightness(var1, var2, var3, var4);
	}

	public float getExplosionResistance(net.minecraft.entity.Entity var1) {
		return this.modelBlock.getExplosionResistance(var1);
	}

	public int getRenderBlockPass() {
		return this.modelBlock.getRenderBlockPass();
	}

	public int idDropped(int var1, Random var2) {
		return this.modelBlock.idDropped(var1, var2);
	}

	public int quantityDropped(Random var1) {
		return this.modelBlock.quantityDropped(var1);
	}

	public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
		return this.modelBlock.getBlockTextureFromSideAndMetadata(var1, var2);
	}

	public int getBlockTextureFromSide(int var1) {
		return this.modelBlock.getBlockTextureFromSide(var1);
	}

	public int getBlockTexture(IBlockAccess var1, int var2, int var3, int var4, int var5) {
		return this.modelBlock.getBlockTexture(var1, var2, var3, var4, var5);
	}

	public int tickRate() {
		return this.modelBlock.tickRate();
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(net.minecraft.world.World var1, int var2, int var3, int var4) {
		return this.modelBlock.getSelectedBoundingBoxFromPool(var1, var2, var3, var4);
	}

	public void velocityToAddToEntity(net.minecraft.world.World var1, int var2, int var3, int var4, net.minecraft.entity.Entity var5, Vec3D var6) {
		this.modelBlock.velocityToAddToEntity(var1, var2, var3, var4, var5, var6);
	}

	public boolean isCollidable() {
		return this.modelBlock.isCollidable();
	}

	public boolean canCollideCheck(int var1, boolean var2) {
		return this.modelBlock.canCollideCheck(var1, var2);
	}

	public boolean canPlaceBlockAt(net.minecraft.world.World var1, int var2, int var3, int var4) {
		return this.modelBlock.canPlaceBlockAt(var1, var2, var3, var4);
	}

	public void onBlockAdded(net.minecraft.world.World var1, int var2, int var3, int var4) {
		this.onNeighborBlockChange(var1, var2, var3, var4, 0);
		this.modelBlock.onBlockAdded(var1, var2, var3, var4);
	}

	public void onBlockRemoval(net.minecraft.world.World var1, int var2, int var3, int var4) {
		this.modelBlock.onBlockRemoval(var1, var2, var3, var4);
	}

	public void dropBlockAsItemWithChance(net.minecraft.world.World var1, int var2, int var3, int var4, int var5, float var6) {
		this.modelBlock.dropBlockAsItemWithChance(var1, var2, var3, var4, var5, var6);
	}

	public void onEntityWalking(net.minecraft.world.World var1, int var2, int var3, int var4, net.minecraft.entity.Entity var5) {
		this.modelBlock.onEntityWalking(var1, var2, var3, var4, var5);
	}

	public void updateTick(net.minecraft.world.World var1, int var2, int var3, int var4, Random var5) {
		this.modelBlock.updateTick(var1, var2, var3, var4, var5);
	}

	public boolean blockActivated(net.minecraft.world.World var1, int var2, int var3, int var4, EntityPlayer var5) {
		return this.modelBlock.blockActivated(var1, var2, var3, var4, var5);
	}

	public void onBlockDestroyedByExplosion(net.minecraft.world.World var1, int var2, int var3, int var4) {
		this.modelBlock.onBlockDestroyedByExplosion(var1, var2, var3, var4);
	}

	public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLiving var5) {
		int var6 = MathHelper.floor_double((double)(var5.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(var6 == 0) {
			var1.setBlockMetadataWithNotify(var2, var3, var4, 2);
		}

		if(var6 == 1) {
			var1.setBlockMetadataWithNotify(var2, var3, var4, 1);
		}

		if(var6 == 2) {
			var1.setBlockMetadataWithNotify(var2, var3, var4, 3);
		}

		if(var6 == 3) {
			var1.setBlockMetadataWithNotify(var2, var3, var4, 0);
		}

	}
}
