package net.proxzi;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class Base16Test {

	@Test
	public void testRandoms() {
		Random r = new Random();
		byte[] buf = new byte[16];
		for (int i = 0; i < 512; i++) {
			r.nextBytes(buf);
			String hex = Base16.encode(buf);
			byte[] buf2 = Base16.decode(hex);
			String hex2 = Base16.encode(buf2);
			if (!Arrays.equals(buf, buf2)) {
				throw new AssertionError("Base16 error:\n- " + hex + "\n- " + hex2);
			}
		}
	}

}
