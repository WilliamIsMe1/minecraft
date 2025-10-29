package net.minecraft.util.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagLong extends NBTBase {
	public long longValue;

	public NBTTagLong() {
	}

	public NBTTagLong(long var1) {
		this.longValue = var1;
	}

	public void writeTagContents(DataOutput var1) throws IOException {
		var1.writeLong(this.longValue);
	}

	public void readTagContents(DataInput var1) throws IOException {
		this.longValue = var1.readLong();
	}

	public byte getType() {
		return (byte)4;
	}

	public String toString() {
		return "" + this.longValue;
	}
}
