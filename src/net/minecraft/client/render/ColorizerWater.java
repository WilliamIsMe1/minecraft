package net.minecraft.client.render;

public class ColorizerWater {
	private static int[] waterBuffer = new int[65536];

	public static void setBuffer(int[] var0) {
		waterBuffer = var0;
	}
}
