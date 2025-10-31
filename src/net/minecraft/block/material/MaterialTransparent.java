package net.minecraft.block.material;

import net.minecraft.map.MapColor;

public class MaterialTransparent extends Material {
	public MaterialTransparent(MapColor var1) {
		super(var1);
		this.setIsGroundCover();
	}

	public boolean isSolid() {
		return false;
	}

	public boolean getCanBlockGrass() {
		return false;
	}

	public boolean getIsSolid() {
		return false;
	}
}
