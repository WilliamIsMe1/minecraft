package net.minecraft.world.chunk;

import net.minecraft.world.World;

import java.io.IOException;

public interface IChunkLoader {
	Chunk loadChunk(net.minecraft.world.World var1, int var2, int var3) throws IOException;

	void saveChunk(net.minecraft.world.World var1, Chunk var2) throws IOException;

	void saveExtraChunkData(World var1, Chunk var2) throws IOException;

	void func_814_a();

	void saveExtraData();
}
