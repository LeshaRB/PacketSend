package by.gwttest.client.utils;

import java.util.Random;

public class RandomString {

	private static final char[] symbols;
	private final Random random = new Random();
	private char[] buf;

	static {
		StringBuilder tmp = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch)
			tmp.append(ch);
		for (char ch = 'A'; ch <= 'Z'; ++ch)
			tmp.append(ch);
		for (char ch = 'a'; ch <= 'z'; ++ch)
			tmp.append(ch);
		symbols = tmp.toString().toCharArray();
	}

	RandomString() {
	}

	private static class RandomStringHolder {
		private final static RandomString instance = new RandomString();
	}

	public static RandomString getInstance() {
		return RandomStringHolder.instance;
	}

	public void setLength(int length) {
		if (length < 1)
			throw new IllegalArgumentException("length < 1: " + length);
		buf = new char[length];
	}

	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbols[random.nextInt(symbols.length)];
		return new String(buf);
	}
}
