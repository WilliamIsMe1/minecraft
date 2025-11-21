package net.minecraft.util.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class NBTBase {
	private String key = null;

	public abstract void writeTagContents(DataOutput var1) throws IOException;

	public abstract void readTagContents(DataInput var1) throws IOException;

	public abstract byte getType();

	public String getKey() {
		return this.key == null ? "" : this.key;
	}

	public NBTBase setKey(String var1) {
		this.key = var1;
		return this;
	}

	public static NBTBase readTag(DataInput var0) throws IOException {
		byte var1 = var0.readByte();
		if(var1 == 0) {
			return new NBTTagEnd();
		} else {
			NBTBase var2 = createTagOfType(var1);
			var2.key = var0.readUTF();
			var2.readTagContents(var0);
			return var2;
		}
	}

	public static void writeTag(NBTBase var0, DataOutput var1) throws IOException {
		var1.writeByte(var0.getType());
		if(var0.getType() != 0) {
			var1.writeUTF(var0.getKey());
			var0.writeTagContents(var1);
		}
	}

	public static NBTBase createTagOfType(byte var0) {
		return switch (var0) {
			case 0 -> new NBTTagEnd();
			case 1 -> new NBTTagByte();
			case 2 -> new NBTTagShort();
			case 3 -> new NBTTagInt();
			case 4 -> new NBTTagLong();
			case 5 -> new NBTTagFloat();
			case 6 -> new NBTTagDouble();
			case 7 -> new NBTTagByteArray();
			case 8 -> new NBTTagString();
			case 9 -> new NBTTagList();
			case 10 -> new NBTTagCompound();
			default -> null;
		};
	}

	public static String getTagName(byte var0) {
		return switch (var0) {
			case 0 -> "TAG_End";
			case 1 -> "TAG_Byte";
			case 2 -> "TAG_Short";
			case 3 -> "TAG_Int";
			case 4 -> "TAG_Long";
			case 5 -> "TAG_Float";
			case 6 -> "TAG_Double";
			case 7 -> "TAG_Byte_Array";
			case 8 -> "TAG_String";
			case 9 -> "TAG_List";
			case 10 -> "TAG_Compound";
			default -> "UNKNOWN";
		};
	}
}
