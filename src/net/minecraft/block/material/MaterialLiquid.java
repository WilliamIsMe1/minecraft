package net.minecraft.block.material;

import net.minecraft.map.MapColor;

public class MaterialLiquid extends Material {
	public MaterialLiquid(MapColor var1) {
		super(var1);
		this.setIsGroundCover();
		this.setNoPushMobility();
	}

	public boolean isLiquid() {
		return true;
	}

	public boolean getIsSolid() {
		return false;
	}

	public boolean isSolid() {
		return false;
	}
}
