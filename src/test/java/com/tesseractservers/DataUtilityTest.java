package com.tesseractservers;

import org.junit.Test;

import java.util.Random;

public class DataUtilityTest {

	@Test
	public void testIntegersRandom() {
		Random random = new Random();

		for (int i = 0; i < 4096 * 4096; i++) {
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

}
