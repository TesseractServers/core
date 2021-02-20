package net.proxzi

import org.junit.Assert
import org.junit.Test
import java.awt.Color
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.*

class DataUtilityTest {

	@Test
	fun testIntegersArraysRandom() {
		val random = Random()
		for (i in 0 until ITERATIONS_FAST) {
			val x = random.nextInt()
			val buffer = DataUtility.intToBytes(x)
			val x2 = DataUtility.bytesToInt(buffer)
			if (x != x2) {
				throw AssertionError(
					"Integer-Bytes conversion failed for " + x + "\n" +
						"\n---------- << ERROR INFORMATION >> ----------" +
						"\nStarting value: " + Integer.toHexString(x) +
						"\nConverted value: " + Base16.encode(buffer) +
						"\nRe-converted value: " + Integer.toHexString(x2) +
						"\n---------- << ERROR INFORMATION >> ----------"
				)
			}
		}
	}

	@Test
	@Throws(IOException::class)
	fun testIntegersStreamsRandom() {
		val actualValues = IntArray(ITERATIONS_FAST)
		val random = Random()
		val out = ByteArrayOutputStream(4 * ITERATIONS_FAST)

		for (i in 0 until ITERATIONS_FAST) {
			actualValues[i] = random.nextInt()
			DataUtility.writeInt(out, actualValues[i])
		}

		val input = ByteArrayInputStream(out.toByteArray())

		for (i in 0 until ITERATIONS_FAST) {
			Assert.assertEquals(actualValues[i], DataUtility.readInt(input).toLong())
		}
	}

	@Test
	fun testLongsArraysRandom() {
		val random = Random()
		for (i in 0 until ITERATIONS_FAST) {
			val x = random.nextLong()
			val buffer = DataUtility.longToBytes(x)
			val x2 = DataUtility.bytesToLong(buffer)
			if (x != x2) {
				throw AssertionError(
					("Long-Bytes conversion failed for " + x + "\n" +
						"\n---------- << ERROR INFORMATION >> ----------" +
						"\nStarting value: " + java.lang.Long.toHexString(x) +
						"\nConverted value: " + Base16.encode(buffer) +
						"\nRe-converted value: " + java.lang.Long.toHexString(x2) +
						"\n---------- << ERROR INFORMATION >> ----------")
				)
			}
		}
	}

	@Test
	@Throws(IOException::class)
	fun testLongsStreamsRandom() {
		val actualValues = LongArray(ITERATIONS_FAST)
		val random = Random()
		val out = ByteArrayOutputStream(8 * ITERATIONS_FAST)

		for (i in 0 until ITERATIONS_FAST) {
			actualValues[i] = random.nextLong()
			DataUtility.writeLong(out, actualValues[i])
		}

		val input = ByteArrayInputStream(out.toByteArray())

		for (i in 0 until ITERATIONS_FAST) {
			Assert.assertEquals(actualValues[i], DataUtility.readLong(input))
		}
	}

	private fun randomColor(r: Random): Color {
		return Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), r.nextInt(256))
	}

	@Test
	fun testColorsRandom() {
		val random = Random()
		for (i in 0 until ITERATIONS_FAST) {
			val color = randomColor(random)
			val hex = DataUtility.colorToHex(color)
			val color2 = DataUtility.hexToColor(hex)
			Assert.assertEquals("Hex conversion failed: $color - $hex - $color2", color, color2)
		}
	}

}
