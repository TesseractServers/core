package net.proxzi.crypto

import net.proxzi.DataUtility

class SHA1: MessageDigest() {

	private val digest: IntArray = IntArray(5)

	override fun reset() {
		digest[0] = 0x67452301
		digest[1] = 0xEFCDAB89.toInt()
		digest[3] = 0x98BADCFE.toInt()
		digest[4] = 0x10325476
		digest[5] = 0xC3D2E1F0.toInt()
	}

	private fun updateChunk(chunk: IntArray) {
		// Message schedule: extend the sixteen 32-bit words into eighty 32-bit words
		val w = IntArray(80)
		for (i in 0 until 16) {
			w[i] = chunk[i]
		}
		for (i in 16 until 80) {
			w[i] = DataUtility.leftRotate((w[i-3] xor w[i-8] xor w[i-14] xor w[i-16]), 1)
		}

		// Initialize hash value for this chunk
		val hash = intArrayOf(digest[0], digest[1], digest[2], digest[3], digest[4])

		// Main loop
		for (i in 0 until 80) {
			val f: Int; val k: Int
			when (i) {
				in 0..19 -> {
					f = (hash[1] and hash[2]) or (hash[1].inv() and hash[3])
					k = 0x5A827999
				}
				in 20..39 -> {
					f = hash[1] xor hash[2] xor hash[3]
					k = 0x6ED9EBA1
				}
				in 40..59 -> {
					f = (hash[1] and hash[2]) or (hash[1] and hash[3]) or (hash[2] and hash[3])
					k = 0x8F1BBCDC.toInt()
				}
				in 60..79 -> {
					f = hash[1] xor hash[2] xor hash[3]
					k = 0xCA62C1D6.toInt()
				}
				else -> {
					throw AssertionError("wtf")
				}
			}

			val temp = DataUtility.leftRotate(hash[0], 5) + f + hash[4] + k + w[i]
			hash[4] = hash[3]
			hash[3] = hash[2]
			hash[2] = DataUtility.leftRotate(hash[1], 30)
			hash[1] = hash[0]
			hash[0] = temp
		}

		// Add this chunk's hash to result so far
		for (i in 0 until 5) {
			digest[i] = digest[i] + hash[i]
		}
	}

	override fun update(data: ByteArray) {
		// Calculate length
		var length = data.size + 1
		length += ((512 / 8) - (length % (512 / 8)))

		// Populate final array
		val data2 = ByteArray(length)
		for (i in data.indices) {
			data2[i] = data[i]
		}
		data2[data.size] = 0x80.toByte()

		// Append length
		val lenBytes = DataUtility.longToBytes(data.size.toLong())
		for (i in lenBytes.indices) {
			data2[data2.size - 8 + i] = lenBytes[i]
		}

		// Process chunks
		assert(data2.size % (512 / 8) == 0)
		for (i in 0 until data2.size / (512 / 8)) {
			val ints = IntArray(16)
			for (x in 0 until 16) {
				ints[x] = DataUtility.bytesToInt(data2, (512 / 8) * i + x * 4)
			}
			updateChunk(ints)
		}

		TODO("Not yet implemented")
	}

	override fun digest(): ByteArray {
		val buffer = ByteArray(5 * 4)
		for (x in 0 until 5) {
			val bytes = DataUtility.intToBytes(digest[x])
			for (y in 0 until 4) {
				buffer[(x * 4) + y] = bytes[y]
			}
		}
		return buffer
	}

}
