package net.minecraft.entity;

import net.minecraft.block.Material;

public enum EnumCreatureType {
	monster(IMob.class, 70, net.minecraft.block.Material.air, false),
	creature(EntityAnimal.class, 15, net.minecraft.block.Material.air, true),
	waterCreature(EntityWaterMob.class, 5, net.minecraft.block.Material.water, true);

	private final Class creatureClass;
	private final int maxNumberOfCreature;
	private final net.minecraft.block.Material creatureMaterial;
	private final boolean isPeacefulCreature;

	EnumCreatureType(Class var3, int var4, net.minecraft.block.Material var5, boolean var6) {
		this.creatureClass = var3;
		this.maxNumberOfCreature = var4;
		this.creatureMaterial = var5;
		this.isPeacefulCreature = var6;
	}

	public Class getCreatureClass() {
		return this.creatureClass;
	}

	public int getMaxNumberOfCreature() {
		return this.maxNumberOfCreature;
	}

	public Material getCreatureMaterial() {
		return this.creatureMaterial;
	}

	public boolean getPeacefulCreature() {
		return this.isPeacefulCreature;
	}
}
