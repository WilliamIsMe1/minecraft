package net.minecraft.util.json;

public class EnumJsonNodeTypeMappingHelper {
	public static final int[] field_27341_a = new int[net.minecraft.util.json.EnumJsonNodeType.values().length];

	static {
		try {
			field_27341_a[net.minecraft.util.json.EnumJsonNodeType.ARRAY.ordinal()] = 1;
		} catch (NoSuchFieldError ignored) {
		}

		try {
			field_27341_a[net.minecraft.util.json.EnumJsonNodeType.OBJECT.ordinal()] = 2;
		} catch (NoSuchFieldError ignored) {
		}

		try {
			field_27341_a[net.minecraft.util.json.EnumJsonNodeType.STRING.ordinal()] = 3;
		} catch (NoSuchFieldError ignored) {
		}

		try {
			field_27341_a[net.minecraft.util.json.EnumJsonNodeType.NUMBER.ordinal()] = 4;
		} catch (NoSuchFieldError ignored) {
		}

		try {
			field_27341_a[net.minecraft.util.json.EnumJsonNodeType.FALSE.ordinal()] = 5;
		} catch (NoSuchFieldError ignored) {
		}

		try {
			field_27341_a[net.minecraft.util.json.EnumJsonNodeType.TRUE.ordinal()] = 6;
		} catch (NoSuchFieldError ignored) {
		}

		try {
			field_27341_a[EnumJsonNodeType.NULL.ordinal()] = 7;
		} catch (NoSuchFieldError ignored) {
		}

	}
}
