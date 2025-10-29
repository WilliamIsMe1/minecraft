package net.minecraft.client;

public class EnumOptionsMappingHelper {
	public static final int[] enumOptionsMappingHelperArray = new int[net.minecraft.client.EnumOptions.values().length];

	static {
		try {
			enumOptionsMappingHelperArray[net.minecraft.client.EnumOptions.INVERT_MOUSE.ordinal()] = 1;
		} catch (NoSuchFieldError var5) {
		}

		try {
			enumOptionsMappingHelperArray[net.minecraft.client.EnumOptions.VIEW_BOBBING.ordinal()] = 2;
		} catch (NoSuchFieldError var4) {
		}

		try {
			enumOptionsMappingHelperArray[net.minecraft.client.EnumOptions.ANAGLYPH.ordinal()] = 3;
		} catch (NoSuchFieldError var3) {
		}

		try {
			enumOptionsMappingHelperArray[net.minecraft.client.EnumOptions.ADVANCED_OPENGL.ordinal()] = 4;
		} catch (NoSuchFieldError var2) {
		}

		try {
			enumOptionsMappingHelperArray[EnumOptions.AMBIENT_OCCLUSION.ordinal()] = 5;
		} catch (NoSuchFieldError var1) {
		}

	}
}
