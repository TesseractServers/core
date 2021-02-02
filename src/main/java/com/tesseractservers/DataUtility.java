package com.tesseractservers;

/**
 * Supplies utility for handling data (e.g. converting ints to bytes and vice versa).
 * @since Core 1.0
 * @author Tassilo
 */
public class DataUtility {

	/**
	 * Converts the given integer to 4 bytes.
	 * @param value the integer
	 * @return the bytes
	 */
	public static byte[] intToBytes(int value) {
		byte[] buffer = new byte[4];
		intToBytes(value, buffer, 0);
		return buffer;
	}

	/**
	 * Converts the given integer to 4 bytes and stores them in the buffer array.
	 * @param value the integer
	 * @param buffer the byte buffer
	 * @throws ArrayIndexOutOfBoundsException if array is too short
	 * @see #intToBytes(int)
	 * @see #intToBytes(int, byte[], int)
	 */
	public static void intToBytes(int value, byte[] buffer) {
		intToBytes(value, buffer, 0);
	}

	/**
	 * Converts the given integer to 4 bytes and stores them in the buffer array.
	 * @param value the integer
	 * @param buffer the byte buffer
	 * @param offset the offset
	 * @throws ArrayIndexOutOfBoundsException if array is too short or offset is invalid
	 * @see #intToBytes(int)
	 * @see #intToBytes(int, byte[])
	 */
	@SuppressWarnings({"PointlessArithmeticExpression", "PointlessBitwiseExpression"})
	public static void intToBytes(int value, byte[] buffer, int offset) {
		buffer[offset + 0] = (byte) ((value >> 24) & 0xFF);
		buffer[offset + 1] = (byte) ((value >> 16) & 0xFF);
		buffer[offset + 2] = (byte) ((value >>  8) & 0xFF);
		buffer[offset + 3] = (byte) ((value >>  0) & 0xFF);
	}

	/**
	 * Converts the next 4 bytes in the buffer array to an integer.
	 * @param buffer the byte buffer
	 * @return the integer
	 * @throws ArrayIndexOutOfBoundsException if array is too short
	 * @see #bytesToInt(byte[], int)
	 */
	public static int bytesToInt(byte[] buffer) {
		return bytesToInt(buffer, 0);
	}

	/**
	 * Converts the next 4 bytes in the buffer array to an integer.
	 * @param buffer the byte buffer
	 * @param offset the offset
	 * @return the integer
	 * @throws ArrayIndexOutOfBoundsException if array is too short or offset is invalid
	 * @see #bytesToInt(byte[])
	 */
	@SuppressWarnings("PointlessArithmeticExpression")
	public static int bytesToInt(byte[] buffer, int offset) {
		int value = 0;
		value |= buffer[offset + 0] & 0xFF;
		value <<= 8;
		value |= buffer[offset + 1] & 0xFF;
		value <<= 8;
		value |= buffer[offset + 2] & 0xFF;
		value <<= 8;
		value |= buffer[offset + 3] & 0xFF;
		return value;
	}



	/**
	 * Static class.
	 */
	private DataUtility() {
	}

}
