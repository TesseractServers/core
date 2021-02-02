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
	public static void intToBytes(int value, byte[] buffer, int offset) {
		for (int i = 0; i < 4; i++) {
			int shift = (7 - i) * 8;
			buffer[offset + i] = (byte) ((value >> shift) & 0xFF);
		}
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
	public static int bytesToInt(byte[] buffer, int offset) {
		int value = buffer[offset] & 0xFF;
		for (int i = 1; i < 4; i++) {
			value <<= 8;
			value |= buffer[offset + i] & 0xFF;
		}
		return value;
	}



	/**
	 * Converts the given long to 8 bytes.
	 * @param value the long
	 * @return the bytes
	 * @see #longToBytes(long, byte[])
	 * @see #longToBytes(long, byte[], int)
	 */
	public static byte[] longToBytes(long value) {
		byte[] buffer = new byte[8];
		longToBytes(value, buffer, 0);
		return buffer;
	}

	/**
	 * Converts the given long to 8 bytes and stores them in the buffer array.
	 * @param value the integer
	 * @param buffer the byte buffer
	 * @throws ArrayIndexOutOfBoundsException if array is too short
	 * @see #longToBytes(long)
	 * @see #longToBytes(long, byte[], int)
	 */
	public static void longToBytes(long value, byte[] buffer) {
		longToBytes(value, buffer, 0);
	}

	/**
	 * Converts the given long to 8 bytes and stores them in the buffer array.
	 * @param value the integer
	 * @param buffer the byte buffer
	 * @param offset the offset
	 * @throws ArrayIndexOutOfBoundsException if array is too short or offset is invalid
	 * @see #longToBytes(long)
	 * @see #longToBytes(long, byte[])
	 */
	public static void longToBytes(long value, byte[] buffer, int offset) {
		for (int i = 0; i < 8; i++) {
			int shift = (7 - i) * 8;
			buffer[offset + i] = (byte) ((value >> shift) & 0xFF);
		}
	}

	/**
	 * Converts the next 8 bytes in the buffer array to a long.
	 * @param buffer the byte buffer
	 * @return the long
	 * @throws ArrayIndexOutOfBoundsException if array is too short
	 * @see #bytesToLong(byte[], int)
	 */
	public static long bytesToLong(byte[] buffer) {
		return bytesToLong(buffer, 0);
	}

	/**
	 * Converts the next 8 bytes in the buffer array to a long.
	 * @param buffer the byte buffer
	 * @param offset the offset
	 * @return the long
	 * @throws ArrayIndexOutOfBoundsException if array is too short or offset is invalid
	 * @see #bytesToLong(byte[])
	 */
	public static long bytesToLong(byte[] buffer, int offset) {
		long value = buffer[offset] & 0xFF;
		for (int i = 1; i < 8; i++) {
			value <<= 8;
			value |= buffer[offset + i] & 0xFF;
		}
		return value;
	}



	/**
	 * Static class.
	 */
	private DataUtility() {
	}

}
