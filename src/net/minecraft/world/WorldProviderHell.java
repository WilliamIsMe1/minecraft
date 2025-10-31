package net.minecraft.world;

import net.minecraft.block.core.Block;
import net.minecraft.core.Vec3D;
import net.minecraft.world.chunk.ChunkProviderHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.BiomeGenBase;

public class WorldProviderHell extends WorldProvider {
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.hell, 1.0D, 0.0D);
		this.isNether = true;
		this.isHellWorld = true;
		this.hasNoSky = true;
		this.worldType = -1;
	}

	public net.minecraft.core.Vec3D func_4096_a(float var1, float var2) {
		return Vec3D.createVector((double)0.2F, (double)0.03F, (double)0.03F);
	}

	protected void generateLightBrightnessTable() {
		float var1 = 0.1F;

		for(int var2 = 0; var2 <= 15; ++var2) {
			float var3 = 1.0F - (float)var2 / 15.0F;
			this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
		}

	}

	public IChunkProvider getChunkProvider() {
		return new ChunkProviderHell(this.worldObj, this.worldObj.getRandomSeed());
	}

	public boolean canCoordinateBeSpawn(int var1, int var2) {
		int var3 = this.worldObj.getFirstUncoveredBlock(var1, var2);
		return var3 == Block.bedrock.getBlockID() ? false : (var3 == 0 ? false : Block.opaqueCubeLookup[var3]);
	}

	public float calculateCelestialAngle(long var1, float var3) {
		return 0.5F;
	}

	public boolean canRespawnHere() {
		return false;
	}
}
