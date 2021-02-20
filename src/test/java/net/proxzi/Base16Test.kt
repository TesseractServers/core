package net.proxzi

import org.junit.Test
import java.util.*

class Base16Test {

	@Test
	fun testRandoms() {
		val r = Random()
		val buf = ByteArray(16)
		for (i in 0 until ITERATIONS_FAST) {
			r.nextBytes(buf)
			val hex = Base16.encode(buf)
			val buf2 = Base16.decode(hex)
			val hex2 = Base16.encode(buf2)
			if (!Arrays.equals(buf, buf2)) {
				throw AssertionError("Base16 error:\n- $hex\n- $hex2")
			}
		}
	}

}
