package net.minecraft.world.chunk;

import net.minecraft.world.Empty2;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChunkFolderPattern implements FileFilter {
	public static final Pattern field_22392_a = Pattern.compile("[0-9a-z]|([0-9a-z][0-9a-z])");

	private ChunkFolderPattern() {
	}

	public boolean accept(File var1) {
		if(var1.isDirectory()) {
			Matcher var2 = field_22392_a.matcher(var1.getName());
			return var2.matches();
		} else {
			return false;
		}
	}

	public ChunkFolderPattern(Empty2 var1) {
		this();
	}
}
