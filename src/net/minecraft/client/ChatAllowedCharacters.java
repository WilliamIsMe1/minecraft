package net.minecraft.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatAllowedCharacters {
	public static final String allowedCharacters = getAllowedCharacters();
	public static final char[] allowedCharactersArray = new char[]{'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};

	private static String getAllowedCharacters() {
		StringBuilder var0 = new StringBuilder();

		try {
			BufferedReader var1 = new BufferedReader(new InputStreamReader(ChatAllowedCharacters.class.getResourceAsStream("/font.txt"), "UTF-8"));
			String var2 = "";

			while(true) {
				var2 = var1.readLine();
				if(var2 == null) {
					var1.close();
					break;
				}

				if(!var2.startsWith("#")) {
					var0.append(var2);
				}
			}
		} catch (Exception ignored) {
		}

		return var0.toString();
	}
}
