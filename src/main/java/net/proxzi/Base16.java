package net.proxzi;

/**
 * Allows to convert byte arrays to Base16 (hexadecimal).
 * @since Core 1.0
 * @author Tassilo
 */
public class Base16 {

	/**
	 * This array is solely used to encode.
	 */
	private static final char[] TABLE = {
		'0', '1', '2', '3', '4', '5', '6', '7',
		'8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
	};

	/**
	 * This method is used to decode a character into its integer value (range: 0-15)
	 * @param value the character to decode
	 * @return the integer value
	 */
	private static int decodeChar(char value) {
		if (value >= '0' && value <= '9') {
			return value - '0';
		} else if (value >= 'a' && value <= 'f') {
			return value - 'a' + 10;
		} else throw new IllegalArgumentException("Unknown character: " + value);
	}

	/**
	 * Encodes a byte array into a Base16 string.
	 * @param input the byte array to encode
	 * @return the encoded string
	 * @see #decode(String)
	 * @see #encode(byte[], int, int)
	 */
	public static String encode(byte[] input) {
		return encode(input, 0, input.length);
	}

	/**
	 * Encodes a byte array into a Base16 starting reading from the array at the given offset for the given length.
	 * @param input the byte array to encode
	 * @param offset the index of the input to start at
	 * @param length how many bytes to encode
	 * @return the encoded string
	 * @see #decode(String)
	 * @see #encode(byte[])
	 */
	public static String encode(byte[] input, int offset, int length) {
		char[] chars = new char[input.length * 2];
		for (int i = offset; i < offset + length; i++) {
			chars[i * 2] = TABLE[(input[i] >> 4) & 0xf];
			chars[i * 2 + 1] = TABLE[input[i] & 0xf];
		}
		return new String(chars);
	}

	/**
	 * Decodes an input Base16 string.
	 * @param input the string to decode
	 * @return the decoded byte array
	 * @see #encode(byte[])
	 */
	public static byte[] decode(String input) {
		char[] chars = input.toCharArray();
		if (chars.length % 2 != 0) throw new IllegalArgumentException("Strings length must be a multiple of 2.");
		byte[] bytes = new byte[chars.length / 2];
		for (int i = 0; i < bytes.length; i++) {
			int a = decodeChar(chars[i * 2]);
			int b = decodeChar(chars[i * 2 + 1]);
			bytes[i] = (byte) (((a << 4) & 0xf0) | (b & 0xf));
		}
		return bytes;
	}

	/**
	 * Static class.
	 */
	private Base16() {
	}

}
