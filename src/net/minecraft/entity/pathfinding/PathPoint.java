package net.minecraft.entity.pathfinding;

import net.minecraft.util.MathHelper;

public class PathPoint {
	public final int xCoord;
	public final int yCoord;
	public final int zCoord;
	private final int hash;
	int index = -1;
	float totalPathDistance;
	float distanceToNext;
	float distanceToTarget;
	PathPoint previous;
	public boolean isFirst = false;

	public PathPoint(int x, int y, int z) {
		this.xCoord = x;
		this.yCoord = y;
		this.zCoord = z;
		this.hash = hash(x, y, z);
	}

	public static int hash(int x, int y, int z) {
		return y & 255 | (x & Short.MAX_VALUE) << 8 | (z & Short.MAX_VALUE) << 24 | (x < 0 ? Integer.MIN_VALUE : 0) | (z < 0 ? -Short.MIN_VALUE : 0);
	}

	public float distanceTo(PathPoint other) {
		float var2 = (float)(other.xCoord - this.xCoord);
		float var3 = (float)(other.yCoord - this.yCoord);
		float var4 = (float)(other.zCoord - this.zCoord);
		return MathHelper.sqrt_float(var2 * var2 + var3 * var3 + var4 * var4);
	}

	public boolean equals(Object other) {
		if(!(other instanceof PathPoint)) {
			return false;
		} else {
			PathPoint var2 = (PathPoint)other;
			return this.hash == var2.hash && this.xCoord == var2.xCoord && this.yCoord == var2.yCoord && this.zCoord == var2.zCoord;
		}
	}

	public int hashCode() {
		return this.hash;
	}

	public boolean isAssigned() {
		return this.index >= 0;
	}

	public String toString() {
		return this.xCoord + ", " + this.yCoord + ", " + this.zCoord;
	}
}
