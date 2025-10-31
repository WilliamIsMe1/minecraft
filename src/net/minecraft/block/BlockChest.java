package net.minecraft.block;

import net.minecraft.block.core.Block;
import net.minecraft.block.core.BlockContainer;
import net.minecraft.block.core.IBlockAccess;
import net.minecraft.block.material.Material;
import net.minecraft.block.tileentity.TileEntity;
import net.minecraft.block.tileentity.TileEntityChest;
import net.minecraft.entity.EntityItem;
import net.minecraft.entity.living.EntityPlayer;
import net.minecraft.item.container.inventory.IInventory;
import net.minecraft.item.container.inventory.InventoryLargeChest;
import net.minecraft.item.core.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class BlockChest extends BlockContainer {
	private Random random = new Random();

	public BlockChest(int var1) {
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
			int var10;
			int var11;
			int var12;
			byte var13;
			if(var6 != this.getBlockID() && var7 != this.getBlockID()) {
				if(var8 != this.getBlockID() && var9 != this.getBlockID()) {
					byte var14 = 3;
					if(Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var7]) {
						var14 = 3;
					}

					if(Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var6]) {
						var14 = 2;
					}

					if(Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var9]) {
						var14 = 5;
					}

					if(Block.opaqueCubeLookup[var9] && !Block.opaqueCubeLookup[var8]) {
						var14 = 4;
					}

					return var5 == var14 ? this.getBlockIndexInTexture() + 1 : this.getBlockIndexInTexture();
				} else if(var5 != 4 && var5 != 5) {
					var10 = 0;
					if(var8 == this.getBlockID()) {
						var10 = -1;
					}

					var11 = var1.getBlockId(var8 == this.getBlockID() ? var2 - 1 : var2 + 1, var3, var4 - 1);
					var12 = var1.getBlockId(var8 == this.getBlockID() ? var2 - 1 : var2 + 1, var3, var4 + 1);
					if(var5 == 3) {
						var10 = -1 - var10;
					}

					var13 = 3;
					if((Block.opaqueCubeLookup[var6] || Block.opaqueCubeLookup[var11]) && !Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var12]) {
						var13 = 3;
					}

					if((Block.opaqueCubeLookup[var7] || Block.opaqueCubeLookup[var12]) && !Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var11]) {
						var13 = 2;
					}

					return (var5 == var13 ? this.getBlockIndexInTexture() + 16 : this.getBlockIndexInTexture() + 32) + var10;
				} else {
					return this.getBlockIndexInTexture();
				}
			} else if(var5 != 2 && var5 != 3) {
				var10 = 0;
				if(var6 == this.getBlockID()) {
					var10 = -1;
				}

				var11 = var1.getBlockId(var2 - 1, var3, var6 == this.getBlockID() ? var4 - 1 : var4 + 1);
				var12 = var1.getBlockId(var2 + 1, var3, var6 == this.getBlockID() ? var4 - 1 : var4 + 1);
				if(var5 == 4) {
					var10 = -1 - var10;
				}

				var13 = 5;
				if((Block.opaqueCubeLookup[var8] || Block.opaqueCubeLookup[var11]) && !Block.opaqueCubeLookup[var9] && !Block.opaqueCubeLookup[var12]) {
					var13 = 5;
				}

				if((Block.opaqueCubeLookup[var9] || Block.opaqueCubeLookup[var12]) && !Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var11]) {
					var13 = 4;
				}

				return (var5 == var13 ? this.getBlockIndexInTexture() + 16 : this.getBlockIndexInTexture() + 32) + var10;
			} else {
				return this.getBlockIndexInTexture();
			}
		}
	}

	public int getBlockTextureFromSide(int var1) {
		return var1 == 1 ? this.getBlockIndexInTexture() - 1 : (var1 == 0 ? this.getBlockIndexInTexture() - 1 : (var1 == 3 ? this.getBlockIndexInTexture() + 1 : this.getBlockIndexInTexture()));
	}

	public boolean canPlaceBlockAt(net.minecraft.world.World var1, int var2, int var3, int var4) {
		int var5 = 0;
		if(var1.getBlockId(var2 - 1, var3, var4) == this.getBlockID()) {
			++var5;
		}

		if(var1.getBlockId(var2 + 1, var3, var4) == this.getBlockID()) {
			++var5;
		}

		if(var1.getBlockId(var2, var3, var4 - 1) == this.getBlockID()) {
			++var5;
		}

		if(var1.getBlockId(var2, var3, var4 + 1) == this.getBlockID()) {
			++var5;
		}

		return var5 > 1 ? false : (this.isThereANeighborChest(var1, var2 - 1, var3, var4) ? false : (this.isThereANeighborChest(var1, var2 + 1, var3, var4) ? false : (this.isThereANeighborChest(var1, var2, var3, var4 - 1) ? false : !this.isThereANeighborChest(var1, var2, var3, var4 + 1))));
	}

	private boolean isThereANeighborChest(net.minecraft.world.World var1, int var2, int var3, int var4) {
		return var1.getBlockId(var2, var3, var4) != this.getBlockID() ? false : (var1.getBlockId(var2 - 1, var3, var4) == this.getBlockID() ? true : (var1.getBlockId(var2 + 1, var3, var4) == this.getBlockID() ? true : (var1.getBlockId(var2, var3, var4 - 1) == this.getBlockID() ? true : var1.getBlockId(var2, var3, var4 + 1) == this.getBlockID())));
	}

	public void onBlockRemoval(net.minecraft.world.World var1, int var2, int var3, int var4) {
		TileEntityChest var5 = (TileEntityChest)var1.getBlockTileEntity(var2, var3, var4);

		for(int var6 = 0; var6 < var5.getSizeInventory(); ++var6) {
			ItemStack var7 = var5.getStackInSlot(var6);
			if(var7 != null) {
				float var8 = this.random.nextFloat() * 0.8F + 0.1F;
				float var9 = this.random.nextFloat() * 0.8F + 0.1F;
				float var10 = this.random.nextFloat() * 0.8F + 0.1F;

				while(var7.stackSize > 0) {
					int var11 = this.random.nextInt(21) + 10;
					if(var11 > var7.stackSize) {
						var11 = var7.stackSize;
					}

					var7.stackSize -= var11;
					net.minecraft.entity.EntityItem var12 = new EntityItem(var1, (double)((float)var2 + var8), (double)((float)var3 + var9), (double)((float)var4 + var10), new ItemStack(var7.itemID, var11, var7.getItemDamage()));
					float var13 = 0.05F;
					var12.motionX = (double)((float)this.random.nextGaussian() * var13);
					var12.motionY = (double)((float)this.random.nextGaussian() * var13 + 0.2F);
					var12.motionZ = (double)((float)this.random.nextGaussian() * var13);
					var1.entityJoinedWorld(var12);
				}
			}
		}

		super.onBlockRemoval(var1, var2, var3, var4);
	}

	public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
		Object var6 = (TileEntityChest)var1.getBlockTileEntity(var2, var3, var4);
		if(var1.isBlockNormalCube(var2, var3 + 1, var4)) {
			return true;
		} else if(var1.getBlockId(var2 - 1, var3, var4) == this.getBlockID() && var1.isBlockNormalCube(var2 - 1, var3 + 1, var4)) {
			return true;
		} else if(var1.getBlockId(var2 + 1, var3, var4) == this.getBlockID() && var1.isBlockNormalCube(var2 + 1, var3 + 1, var4)) {
			return true;
		} else if(var1.getBlockId(var2, var3, var4 - 1) == this.getBlockID() && var1.isBlockNormalCube(var2, var3 + 1, var4 - 1)) {
			return true;
		} else if(var1.getBlockId(var2, var3, var4 + 1) == this.getBlockID() && var1.isBlockNormalCube(var2, var3 + 1, var4 + 1)) {
			return true;
		} else {
			if(var1.getBlockId(var2 - 1, var3, var4) == this.getBlockID()) {
				var6 = new InventoryLargeChest("Large chest", (TileEntityChest)var1.getBlockTileEntity(var2 - 1, var3, var4), (IInventory)var6);
			}

			if(var1.getBlockId(var2 + 1, var3, var4) == this.getBlockID()) {
				var6 = new InventoryLargeChest("Large chest", (IInventory)var6, (TileEntityChest)var1.getBlockTileEntity(var2 + 1, var3, var4));
			}

			if(var1.getBlockId(var2, var3, var4 - 1) == this.getBlockID()) {
				var6 = new InventoryLargeChest("Large chest", (TileEntityChest)var1.getBlockTileEntity(var2, var3, var4 - 1), (IInventory)var6);
			}

			if(var1.getBlockId(var2, var3, var4 + 1) == this.getBlockID()) {
				var6 = new InventoryLargeChest("Large chest", (IInventory)var6, (TileEntityChest)var1.getBlockTileEntity(var2, var3, var4 + 1));
			}

			if(var1.multiplayerWorld) {
				return true;
			} else {
				var5.displayGUIChest((IInventory)var6);
				return true;
			}
		}
	}

	protected TileEntity getBlockEntity() {
		return new TileEntityChest();
	}
}
