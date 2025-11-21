package net.minecraft.client.render.block;

import net.minecraft.block.core.Block;

public class StandardBlockRenderer implements IBlockRenderer {

	@Override
	public boolean render(Block block, int x, int y, int z, RenderContext ctx) {
		return false;
	}
}
