package net.minecraft.world.gen;

import net.minecraft.entity.living.creature.mob.EntityGhast;
import net.minecraft.entity.living.creature.mob.EntityPigZombie;
import net.minecraft.entity.SpawnListEntry;

public class BiomeGenHell extends BiomeGenBase {
	public BiomeGenHell() {
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityGhast.class, 10));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityPigZombie.class, 10));
	}
}
