package com.tesseractservers;

/**
 * Supplies utility for handling data (e.g. converting ints to bytes and vice versa).
 * @since Core 1.0
 * @author Tassilo
 */
public class DataUtility {

	public static byte[] toBytes(int value) {
		byte[] buffer = new byte[4];
		toBytes(value, buffer, 0);
		return buffer;
	}

	public static void toBytes(int value, byte[] buffer) {
		toBytes(value, buffer, 0);
	}

	@SuppressWarnings({"PointlessArithmeticExpression", "PointlessBitwiseExpression"})
	public static void toBytes(int value, byte[] buffer, int offset) {
		buffer[offset + 0] = (byte) ((value >> 24) & 0xFF);
		buffer[offset + 1] = (byte) ((value >> 16) & 0xFF);
		buffer[offset + 2] = (byte) ((value >>  8) & 0xFF);
		buffer[offset + 3] = (byte) ((value >>  0) & 0xFF);
	}

	public static int fromBytes(byte[] buffer) {
		return fromBytes(buffer, 0);
	}

	@SuppressWarnings("PointlessArithmeticExpression")
	public static int fromBytes(byte[] buffer, int offset) {
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
