package net.minecraft.block.natural;

import net.minecraft.block.core.Block;
import net.minecraft.entity.EntityItem;
import net.minecraft.item.core.Item;
import net.minecraft.item.core.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCrops extends BlockFlower {
	public BlockCrops(int var1, int var2) {
		super(var1, var2);
		this.blockIndexInTexture = var2;
		this.setTickOnLoad(true);
		float var3 = 0.5F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
	}

	protected boolean canThisPlantGrowOnThisBlockID(int var1) {
		return var1 == Block.tilledField.blockID;
	}

	public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
		super.updateTick(var1, var2, var3, var4, var5);
		if(var1.getBlockLightValue(var2, var3 + 1, var4) >= 9) {
			int var6 = var1.getBlockMetadata(var2, var3, var4);
			if(var6 < 7) {
				float var7 = this.getGrowthRate(var1, var2, var3, var4);
				if(var5.nextInt((int)(100.0F / var7)) == 0) {
					++var6;
					var1.setBlockMetadataWithNotify(var2, var3, var4, var6);
				}
			}
		}

	}

	public void fertilize(World var1, int var2, int var3, int var4) {
		var1.setBlockMetadataWithNotify(var2, var3, var4, 7);
	}

	private float getGrowthRate(World world, int x, int y, int z) {
		float growthRate = 1.0F;
		int northBlock = world.getBlockId(x, y, z - 1);
		int southBlock = world.getBlockId(x, y, z + 1);
		int westBlock = world.getBlockId(x - 1, y, z);
		int eastBlock = world.getBlockId(x + 1, y, z);
		int northWestBlock = world.getBlockId(x - 1, y, z - 1);
		int northEastBlock = world.getBlockId(x + 1, y, z - 1);
		int southEastBlock = world.getBlockId(x + 1, y, z + 1);
		int southWestBlock = world.getBlockId(x - 1, y, z + 1);
		boolean areAnyEastWestCropsEqual = westBlock == blockID || eastBlock == blockID;
		boolean areAnyNorthSouthCropsEqual = northBlock == blockID || southBlock == blockID;
		boolean areAnyDiagonalCropsEqual = northWestBlock == blockID || northEastBlock == blockID || southEastBlock == blockID || southWestBlock == blockID;

		for(int currentX = x - 1; currentX <= x + 1; currentX++) {
			for(int currentZ = z - 1; currentZ <= z + 1; currentZ++) {
				int checkedBlockID = world.getBlockId(currentX, y - 1, currentZ);
				float checkedBlockModifier = 0.0F;
				if(checkedBlockID == Block.tilledField.blockID) {
					checkedBlockModifier = 1.0F;
					if(world.getBlockMetadata(currentX, y - 1, currentZ) > 0) {
						checkedBlockModifier = 3.0F;
					}
				}

				if(currentX != x || currentZ != z) {
					checkedBlockModifier /= 4.0F;
				}

				growthRate += checkedBlockModifier;
			}
		}

		if(areAnyDiagonalCropsEqual || areAnyEastWestCropsEqual && areAnyNorthSouthCropsEqual) {
			growthRate /= 2.0F;
		}

		return growthRate;
	}

	public int getBlockTextureFromSideAndMetadata(int whichSide, int metadata) {
		if(metadata < 0) {
			metadata = 7;
		}

		return blockIndexInTexture + metadata;
	}

	public int getRenderType() {
		return 6;
	}

	public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6) {
		super.dropBlockAsItemWithChance(var1, var2, var3, var4, var5, var6);
		if(!var1.multiplayerWorld) {
			for(int var7 = 0; var7 < 3; ++var7) {
				if(var1.rand.nextInt(15) <= var5) {
					float var8 = 0.7F;
					float var9 = var1.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
					float var10 = var1.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
					float var11 = var1.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
					EntityItem var12 = new EntityItem(var1, (double)((float)var2 + var9), (double)((float)var3 + var10), (double)((float)var4 + var11), new ItemStack(Item.seeds));
					var12.delayBeforeCanPickup = 10;
					var1.entityJoinedWorld(var12);
				}
			}

		}
	}

	public int idDropped(int var1, Random var2) {
		return var1 == 7 ? Item.wheat.shiftedIndex : -1;
	}

	public int quantityDropped(Random var1) {
		return 1;
	}
}
