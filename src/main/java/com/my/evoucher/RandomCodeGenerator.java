package com.my.evoucher;

import java.security.SecureRandom;

public class RandomCodeGenerator {

	private static final char[] CHAR_LIST = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z' };

	private static final int length = 8;

	public static String getRandomCode() {

		SecureRandom secRandom = new SecureRandom();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++) {

			char temp = CHAR_LIST[secRandom.nextInt(CHAR_LIST.length)];
			sb.append(temp);

		}

		return sb.toString();
	}
}
