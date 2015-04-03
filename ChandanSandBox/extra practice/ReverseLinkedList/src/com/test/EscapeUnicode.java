package com.test;
/*
 * this class has a method escapeUnicode this method takes a String as an argument and 
 * if the strign has any unicode character change this as a code eg: /u221A so it can 
 * be writen as a simple sting on text files
 * */
public class EscapeUnicode {

	final static char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
	final static int[] ESCAPE_CODES = CharTypes.get7BitOutputEscapes();

	private static void writeUnicodeEscape(StringBuffer sb, char c) {
		sb.append('\\');
		sb.append('u');
		sb.append(HEX_CHARS[(c >> 12) & 0xF]);
		sb.append(HEX_CHARS[(c >> 8) & 0xF]);
		sb.append(HEX_CHARS[(c >> 4) & 0xF]);
		sb.append(HEX_CHARS[c & 0xF]);
	}

	private static void writeShortEscape(StringBuffer sb, char c) {
		// gen.writeRaw('\\');
		sb.append(c);
	}

	public static String escapeUnicode(String str) {
		StringBuffer rv = new StringBuffer();
		// gen.writeRaw('"');
		for (char c : str.toCharArray()) {
			if (c >= 0x80)
				writeUnicodeEscape(rv, c); // use generic
											// escaping for all
											// non US-ASCII
											// characters
			else {
				// use escape table for first 128 characters
				int code = (c < ESCAPE_CODES.length ? ESCAPE_CODES[c] : 0);
				if (code == 0)
					rv.append(c); // no escaping
				else if (code < 0)
					writeUnicodeEscape(rv, (char) (-code - 1)); // generic
																// escaping
				else
					writeShortEscape(rv, (char) code); // short
														// escaping
														// (\n
														// \t
														// ...)
			}
		}
		// gen.writeRaw('"');
		return rv.toString();
	}

}
