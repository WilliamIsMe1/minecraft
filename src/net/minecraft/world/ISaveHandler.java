package net.minecraft.world;

import net.minecraft.world.chunk.IChunkLoader;

import java.io.File;
import java.util.List;

public interface ISaveHandler {
	net.minecraft.world.WorldInfo loadWorldInfo();

	void func_22150_b();

	IChunkLoader getChunkLoader(WorldProvider var1);

	void saveWorldInfoAndPlayer(net.minecraft.world.WorldInfo var1, List var2);

	void saveWorldInfo(WorldInfo var1);

	File func_28113_a(String var1);
}
