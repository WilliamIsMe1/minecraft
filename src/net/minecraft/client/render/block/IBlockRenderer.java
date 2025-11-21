package net.minecraft.client.render.block;

import net.minecraft.block.core.Block;

public interface IBlockRenderer {
	boolean render(Block block, int x, int y, int z, RenderContext ctx);
}
