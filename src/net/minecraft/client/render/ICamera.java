package net.minecraft.client.render;

import net.minecraft.misc.AxisAlignedBB;

public interface ICamera {
	boolean isBoundingBoxInFrustum(AxisAlignedBB var1);

	void setPosition(double var1, double var3, double var5);
}
