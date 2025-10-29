package net.minecraft.client;

public class EnumOSMappingHelper {
	public static final int[] enumOSMappingArray = new int[net.minecraft.client.EnumOS2.values().length];

	static {
		try {
			enumOSMappingArray[net.minecraft.client.EnumOS2.linux.ordinal()] = 1;
		} catch (NoSuchFieldError var4) {
		}

		try {
			enumOSMappingArray[net.minecraft.client.EnumOS2.solaris.ordinal()] = 2;
		} catch (NoSuchFieldError var3) {
		}

		try {
			enumOSMappingArray[net.minecraft.client.EnumOS2.windows.ordinal()] = 3;
		} catch (NoSuchFieldError var2) {
		}

		try {
			enumOSMappingArray[EnumOS2.macos.ordinal()] = 4;
		} catch (NoSuchFieldError var1) {
		}

	}
}
