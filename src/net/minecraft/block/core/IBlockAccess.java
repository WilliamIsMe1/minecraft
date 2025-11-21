package net.minecraft.block.core;

import net.minecraft.block.tileentity.TileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.world.WorldChunkManager;

public interface IBlockAccess {
	int getBlockId(int var1, int var2, int var3);

	TileEntity getBlockTileEntity(int var1, int var2, int var3);

	float getBrightness(int var1, int var2, int var3, int var4);

	int getBlockMetadata(int var1, int var2, int var3);

	boolean isBlockNormalCube(int var1, int var2, int var3);

	float getLightBrightness(int var1, int var2, int var3);

	Material getBlockMaterial(int var1, int var2, int var3);

	boolean isBlockOpaqueCube(int var1, int var2, int var3);

	WorldChunkManager getWorldChunkManager();
}
