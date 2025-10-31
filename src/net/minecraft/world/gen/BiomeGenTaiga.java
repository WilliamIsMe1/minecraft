package net.minecraft.world.gen;

import net.minecraft.entity.living.creature.mob.EntityWolf;
import net.minecraft.core.SpawnListEntry;

import java.util.Random;

public class BiomeGenTaiga extends BiomeGenBase {
	public BiomeGenTaiga() {
		this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 2));
	}

	public WorldGenerator getRandomWorldGenForTrees(Random var1) {
		return (WorldGenerator)(var1.nextInt(3) == 0 ? new WorldGenTaiga1() : new WorldGenTaiga2());
	}
}
