package com.tesseractservers;

import org.junit.Test;

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
	public void testLongsRandom() {
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

}
