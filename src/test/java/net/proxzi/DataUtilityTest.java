package net.proxzi;

import org.junit.Test;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.*;

public class DataUtilityTest {

	public static final int ITERATIONS = 4096 * 4096;

	@Test
	public void testIntegersArraysRandom() {
		Random random = new Random();
		for (int i = 0; i < ITERATIONS; i++) {
			int x = random.nextInt();
			byte[] buffer = DataUtility.intToBytes(x);
			int x2 = DataUtility.bytesToInt(buffer);
			if (x != x2) {
				throw new AssertionError("Integer-Bytes conversion failed for " + x + "\n" +
					"\n---------- << ERROR INFORMATION >> ----------" +
					"\nStarting value: " + Integer.toHexString(x) +
					"\nConverted value: " + Base16.encode(buffer) +
					"\nRe-converted value: " + Integer.toHexString(x2) +
					"\n---------- << ERROR INFORMATION >> ----------");
			}
		}
	}

	@Test
	public void testIntegersStreamsRandom() throws IOException {
		final int[] actualValues = new int[ITERATIONS];
		Random random = new Random();

		ByteArrayOutputStream out = new ByteArrayOutputStream(4 * ITERATIONS);
		for (int i = 0; i < ITERATIONS; i++) {
			actualValues[i] = random.nextInt();
			DataUtility.writeInt(out, actualValues[i]);
		}

		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		for (int i = 0; i < ITERATIONS; i++) {
			assertEquals(actualValues[i], DataUtility.readInt(in));
		}
	}

	@Test
	public void testLongsArraysRandom() {
		Random random = new Random();
		for (int i = 0; i < ITERATIONS; i++) {
			long x = random.nextLong();
			byte[] buffer = DataUtility.longToBytes(x);
			long x2 = DataUtility.bytesToLong(buffer);
			if (x != x2) {
				throw new AssertionError("Long-Bytes conversion failed for " + x + "\n" +
					"\n---------- << ERROR INFORMATION >> ----------" +
					"\nStarting value: " + Long.toHexString(x) +
					"\nConverted value: " + Base16.encode(buffer) +
					"\nRe-converted value: " + Long.toHexString(x2) +
					"\n---------- << ERROR INFORMATION >> ----------");
			}
		}
	}

	@Test
	public void testLongsStreamsRandom() throws IOException {
		final long[] actualValues = new long[ITERATIONS];
		Random random = new Random();

		ByteArrayOutputStream out = new ByteArrayOutputStream(8 * ITERATIONS);
		for (int i = 0; i < ITERATIONS; i++) {
			actualValues[i] = random.nextLong();
			DataUtility.writeLong(out, actualValues[i]);
		}

		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		for (int i = 0; i < ITERATIONS; i++) {
			assertEquals(actualValues[i], DataUtility.readLong(in));
		}
	}

	private Color randomColor(Random r) {
		return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), r.nextInt(256));
	}

	@Test
	public void testColorsRandom() {
		Random random = new Random();
		for (int i = 0; i < ITERATIONS; i++) {
			Color color = randomColor(random);
			String hex = DataUtility.colorToHex(color);
			Color color2 = DataUtility.hexToColor(hex);
			assertEquals("Hex conversion failed: " + color.toString() + " - " + hex + color2.toString(), color, color2);
		}
	}

}
