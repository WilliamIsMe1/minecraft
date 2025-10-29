package net.minecraft.world;

import java.util.Random;

public class BiomeGenRainforest extends BiomeGenBase {
	public net.minecraft.world.WorldGenerator getRandomWorldGenForTrees(Random var1) {
		return (WorldGenerator)(var1.nextInt(3) == 0 ? new WorldGenBigTree() : new WorldGenTrees());
	}
}
