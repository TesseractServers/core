package com.tesseractservers;

import org.junit.Test;

import java.util.Random;

public class BitFlagsTest {

	public static final int ITERATIONS = 4096;

	private long randomFlag(Random random) {
		return (long) Math.pow(2, random.nextInt(63));
	}

	@Test
	public void testFlagSetting() {
		Random random = new Random();
		long flags = 0;

		for (int i = 0; i < ITERATIONS; i++) {

			long flag = randomFlag(random);
			flags = BitFlags.setFlag(flags, flag);
			assert BitFlags.hasFlag(flags, flag);

			if (random.nextBoolean()) {
				flags = BitFlags.unsetFlag(flags, flag);
				assert !BitFlags.hasFlag(flags, flag);
			}

		}
	}

}
