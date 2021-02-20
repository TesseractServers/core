package net.proxzi

import net.proxzi.BitFlags.hasFlag
import net.proxzi.BitFlags.setFlag
import net.proxzi.BitFlags.unsetFlag
import org.junit.Test
import java.util.*
import kotlin.math.pow

class BitFlagsTest {

	private fun randomFlag(random: Random): Long {
		return 2.0.pow(random.nextInt(63).toDouble()).toLong()
	}

	@Test
	fun testFlagSetting() {
		val random = Random()
		var flags: Long = 0
		for (i in 0 until ITERATIONS_FAST) {
			val flag = randomFlag(random)
			flags = setFlag(flags, flag)
			assert(hasFlag(flags, flag))
			if (random.nextBoolean()) {
				flags = unsetFlag(flags, flag)
				assert(!hasFlag(flags, flag))
			}
		}
	}

}
