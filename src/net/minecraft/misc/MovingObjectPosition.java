package net.minecraft.misc;

import net.minecraft.core.Vec3D;
import net.minecraft.entity.Entity;

public class MovingObjectPosition {
	public net.minecraft.misc.EnumMovingObjectType typeOfHit;
	public int blockX;
	public int blockY;
	public int blockZ;
	public int sideHit;
	public net.minecraft.core.Vec3D hitVec;
	public net.minecraft.entity.Entity entityHit;

	public MovingObjectPosition(int var1, int var2, int var3, int var4, net.minecraft.core.Vec3D var5) {
		this.typeOfHit = net.minecraft.misc.EnumMovingObjectType.TILE;
		this.blockX = var1;
		this.blockY = var2;
		this.blockZ = var3;
		this.sideHit = var4;
		this.hitVec = net.minecraft.core.Vec3D.createVector(var5.xCoord, var5.yCoord, var5.zCoord);
	}

	public MovingObjectPosition(Entity var1) {
		this.typeOfHit = EnumMovingObjectType.ENTITY;
		this.entityHit = var1;
		this.hitVec = Vec3D.createVector(var1.posX, var1.posY, var1.posZ);
	}
}
