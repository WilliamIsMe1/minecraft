package net.minecraft.entity;

import net.minecraft.block.Block;
import net.minecraft.core.MathHelper;
import net.minecraft.core.Vec3D;
import net.minecraft.misc.AxisAlignedBB;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Explosion {
	public boolean isFlaming = false;
	private final Random ExplosionRNG = new Random();
	private final net.minecraft.world.World worldObj;
	public double explosionX;
	public double explosionY;
	public double explosionZ;
	public net.minecraft.entity.Entity exploder;
	public float explosionSize;
	public Set<net.minecraft.world.ChunkPosition> destroyedBlockPositions = new HashSet<>();

	public Explosion(World var1, net.minecraft.entity.Entity var2, double var3, double var5, double var7, float var9) {
		this.worldObj = var1;
		this.exploder = var2;
		this.explosionSize = var9;
		this.explosionX = var3;
		this.explosionY = var5;
		this.explosionZ = var7;
	}

	public void doExplosionA() {
		float var1 = this.explosionSize;
		byte var2 = 16;

		int var3;
		int var4;
		int var5;
		double var15;
		double var17;
		double var19;
		for(var3 = 0; var3 < var2; ++var3) {
			for(var4 = 0; var4 < var2; ++var4) {
				for(var5 = 0; var5 < var2; ++var5) {
					if(var3 == 0 || var3 == var2 - 1 || var4 == 0 || var4 == var2 - 1 || var5 == 0 || var5 == var2 - 1) {
						double var6 = (double)((float)var3 / ((float)var2 - 1.0F) * 2.0F - 1.0F);
						double var8 = (double)((float)var4 / ((float)var2 - 1.0F) * 2.0F - 1.0F);
						double var10 = (double)((float)var5 / ((float)var2 - 1.0F) * 2.0F - 1.0F);
						double var12 = Math.sqrt(var6 * var6 + var8 * var8 + var10 * var10);
						var6 /= var12;
						var8 /= var12;
						var10 /= var12;
						float var14 = this.explosionSize * (0.7F + this.worldObj.rand.nextFloat() * 0.6F);
						var15 = this.explosionX;
						var17 = this.explosionY;
						var19 = this.explosionZ;

						for(float var21 = 0.3F; var14 > 0.0F; var14 -= var21 * (12.0F / 16.0F)) {
							int var22 = net.minecraft.core.MathHelper.floor_double(var15);
							int var23 = net.minecraft.core.MathHelper.floor_double(var17);
							int var24 = net.minecraft.core.MathHelper.floor_double(var19);
							int var25 = this.worldObj.getBlockId(var22, var23, var24);
							if(var25 > 0) {
								var14 -= (net.minecraft.block.Block.blocksList[var25].getExplosionResistance(this.exploder) + 0.3F) * var21;
							}

							if(var14 > 0.0F) {
								this.destroyedBlockPositions.add(new net.minecraft.world.ChunkPosition(var22, var23, var24));
							}

							var15 += var6 * (double)var21;
							var17 += var8 * (double)var21;
							var19 += var10 * (double)var21;
						}
					}
				}
			}
		}

		this.explosionSize *= 2.0F;
		var3 = net.minecraft.core.MathHelper.floor_double(this.explosionX - (double)this.explosionSize - 1.0D);
		var4 = net.minecraft.core.MathHelper.floor_double(this.explosionX + (double)this.explosionSize + 1.0D);
		var5 = net.minecraft.core.MathHelper.floor_double(this.explosionY - (double)this.explosionSize - 1.0D);
		int var29 = net.minecraft.core.MathHelper.floor_double(this.explosionY + (double)this.explosionSize + 1.0D);
		int var7 = net.minecraft.core.MathHelper.floor_double(this.explosionZ - (double)this.explosionSize - 1.0D);
		int var30 = net.minecraft.core.MathHelper.floor_double(this.explosionZ + (double)this.explosionSize + 1.0D);
		List<Entity> var9 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this.exploder, AxisAlignedBB.getBoundingBoxFromPool((double)var3, (double)var5, (double)var7, (double)var4, (double)var29, (double)var30));
		net.minecraft.core.Vec3D var31 = Vec3D.createVector(this.explosionX, this.explosionY, this.explosionZ);

		for (Entity o : var9) {
			double var13 = o.getDistance(this.explosionX, this.explosionY, this.explosionZ) / (double) this.explosionSize;
			if (var13 <= 1.0D) {
				var15 = o.posX - this.explosionX;
				var17 = o.posY - this.explosionY;
				var19 = o.posZ - this.explosionZ;
				double var39 = net.minecraft.core.MathHelper.sqrt_double(var15 * var15 + var17 * var17 + var19 * var19);
				var15 /= var39;
				var17 /= var39;
				var19 /= var39;
				double var40 = (double) this.worldObj.func_675_a(var31, o.boundingBox);
				double var41 = (1.0D - var13) * var40;
				o.attackEntityFrom(this.exploder, (int) ((var41 * var41 + var41) / 2.0D * 8.0D * (double) this.explosionSize + 1.0D));
				o.motionX += var15 * var41;
				o.motionY += var17 * var41;
				o.motionZ += var19 * var41;
			}
		}

		this.explosionSize = var1;
		ArrayList var32 = new ArrayList();
		var32.addAll(this.destroyedBlockPositions);
		if(this.isFlaming) {
			for(int var34 = var32.size() - 1; var34 >= 0; --var34) {
				net.minecraft.world.ChunkPosition var35 = (net.minecraft.world.ChunkPosition)var32.get(var34);
				int var36 = var35.x;
				int var37 = var35.y;
				int var16 = var35.z;
				int var38 = this.worldObj.getBlockId(var36, var37, var16);
				int var18 = this.worldObj.getBlockId(var36, var37 - 1, var16);
				if(var38 == 0 && net.minecraft.block.Block.opaqueCubeLookup[var18] && this.ExplosionRNG.nextInt(3) == 0) {
					this.worldObj.setBlockWithNotify(var36, var37, var16, net.minecraft.block.Block.fire.blockID);
				}
			}
		}

	}

	public void doExplosionB(boolean var1) {
		this.worldObj.playSoundEffect(this.explosionX, this.explosionY, this.explosionZ, "random.explode", 4.0F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
		ArrayList var2 = new ArrayList();
		var2.addAll(this.destroyedBlockPositions);

		for(int var3 = var2.size() - 1; var3 >= 0; --var3) {
			net.minecraft.world.ChunkPosition var4 = (ChunkPosition)var2.get(var3);
			int var5 = var4.x;
			int var6 = var4.y;
			int var7 = var4.z;
			int var8 = this.worldObj.getBlockId(var5, var6, var7);
			if(var1) {
				double var9 = (double)((float)var5 + this.worldObj.rand.nextFloat());
				double var11 = (double)((float)var6 + this.worldObj.rand.nextFloat());
				double var13 = (double)((float)var7 + this.worldObj.rand.nextFloat());
				double var15 = var9 - this.explosionX;
				double var17 = var11 - this.explosionY;
				double var19 = var13 - this.explosionZ;
				double var21 = (double) MathHelper.sqrt_double(var15 * var15 + var17 * var17 + var19 * var19);
				var15 /= var21;
				var17 /= var21;
				var19 /= var21;
				double var23 = 0.5D / (var21 / (double)this.explosionSize + 0.1D);
				var23 *= (double)(this.worldObj.rand.nextFloat() * this.worldObj.rand.nextFloat() + 0.3F);
				var15 *= var23;
				var17 *= var23;
				var19 *= var23;
				this.worldObj.spawnParticle("explode", (var9 + this.explosionX * 1.0D) / 2.0D, (var11 + this.explosionY * 1.0D) / 2.0D, (var13 + this.explosionZ * 1.0D) / 2.0D, var15, var17, var19);
				this.worldObj.spawnParticle("smoke", var9, var11, var13, var15, var17, var19);
			}

			if(var8 > 0) {
				net.minecraft.block.Block.blocksList[var8].dropBlockAsItemWithChance(this.worldObj, var5, var6, var7, this.worldObj.getBlockMetadata(var5, var6, var7), 0.3F);
				this.worldObj.setBlockWithNotify(var5, var6, var7, 0);
				Block.blocksList[var8].onBlockDestroyedByExplosion(this.worldObj, var5, var6, var7);
			}
		}

	}
}
