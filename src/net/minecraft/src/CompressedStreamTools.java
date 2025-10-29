package net.minecraft.src;

import net.minecraft.util.nbt.NBTBase;
import net.minecraft.util.nbt.NBTTagCompound;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CompressedStreamTools {
	public static net.minecraft.util.nbt.NBTTagCompound func_1138_a(InputStream var0) throws IOException {
		DataInputStream var1 = new DataInputStream(new GZIPInputStream(var0));

		net.minecraft.util.nbt.NBTTagCompound var2;
		try {
			var2 = func_1141_a(var1);
		} finally {
			var1.close();
		}

		return var2;
	}

	public static void writeGzippedCompoundToOutputStream(net.minecraft.util.nbt.NBTTagCompound var0, OutputStream var1) throws IOException {
		DataOutputStream var2 = new DataOutputStream(new GZIPOutputStream(var1));

		try {
			func_1139_a(var0, var2);
		} finally {
			var2.close();
		}

	}

	public static net.minecraft.util.nbt.NBTTagCompound func_1141_a(DataInput var0) throws IOException {
		net.minecraft.util.nbt.NBTBase var1 = net.minecraft.util.nbt.NBTBase.readTag(var0);
		if(var1 instanceof net.minecraft.util.nbt.NBTTagCompound) {
			return (net.minecraft.util.nbt.NBTTagCompound)var1;
		} else {
			throw new IOException("Root tag must be a named compound tag");
		}
	}

	public static void func_1139_a(NBTTagCompound var0, DataOutput var1) throws IOException {
		NBTBase.writeTag(var0, var1);
	}
}
