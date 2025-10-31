package net.minecraft.world.chunk;

import net.minecraft.core.save.RegionFileCache;
import net.minecraft.core.CompressedStreamTools;
import net.minecraft.util.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldInfo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class McRegionChunkLoader implements IChunkLoader {
	private final File worldDir;

	public McRegionChunkLoader(File var1) {
		this.worldDir = var1;
	}

	public Chunk loadChunk(net.minecraft.world.World var1, int var2, int var3) throws IOException {
		DataInputStream var4 = net.minecraft.core.save.RegionFileCache.getChunkInputStream(this.worldDir, var2, var3);
		if(var4 != null) {
			net.minecraft.util.nbt.NBTTagCompound var5 = CompressedStreamTools.func_1141_a(var4);
			if(!var5.hasKey("Level")) {
				System.out.println("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
				return null;
			} else if(!var5.getCompoundTag("Level").hasKey("Blocks")) {
				System.out.println("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
				return null;
			} else {
				Chunk var6 = ChunkLoader.loadChunkIntoWorldFromCompound(var1, var5.getCompoundTag("Level"));
				if(!var6.isAtLocation(var2, var3)) {
					System.out.println("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var6.xPosition + ", " + var6.zPosition + ")");
					var5.setInteger("xPos", var2);
					var5.setInteger("zPos", var3);
					var6 = ChunkLoader.loadChunkIntoWorldFromCompound(var1, var5.getCompoundTag("Level"));
				}

				var6.func_25124_i();
				return var6;
			}
		} else {
			return null;
		}
	}

	public void saveChunk(net.minecraft.world.World var1, Chunk var2) throws IOException {
		var1.checkSessionLock();

		try {
			DataOutputStream var3 = net.minecraft.core.save.RegionFileCache.getChunkOutputStream(this.worldDir, var2.xPosition, var2.zPosition);
			net.minecraft.util.nbt.NBTTagCompound var4 = new net.minecraft.util.nbt.NBTTagCompound();
			net.minecraft.util.nbt.NBTTagCompound var5 = new NBTTagCompound();
			var4.setTag("Level", var5);
			ChunkLoader.storeChunkInCompound(var2, var1, var5);
			CompressedStreamTools.func_1139_a(var4, var3);
			var3.close();
			WorldInfo var6 = var1.getWorldInfo();
			var6.setSizeOnDisk(var6.getSizeOnDisk() + (long) RegionFileCache.getSizeDelta(this.worldDir, var2.xPosition, var2.zPosition));
		} catch (Exception var7) {
			var7.printStackTrace();
		}

	}

	public void saveExtraChunkData(World var1, Chunk var2) throws IOException {
	}

	public void func_814_a() {
	}

	public void saveExtraData() {
	}
}
