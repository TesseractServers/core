package net.proxzi

import java.security.SecureRandom

/**
 * Utility class for string manipulation.
 * @since Core 1.1
 * @author Tassilo
 */
object Strings {

	/**
	 * Generates an URL slug for the input string. The input string must be alphanumeric.
	 * @param input the input string
	 * @return the generated slug
	 * @throws IllegalArgumentException if input string is not alphanumeric
	 */
	@Throws(IllegalArgumentException::class)
	fun generateSlug(input: String): String {
		val str = input.replace(' ', '-')
		val sb = StringBuilder()
		for (character in str.toCharArray()) {
			if (Character.isLetterOrDigit(character)) {
				sb.append(Character.toLowerCase(character))
			} else if (character == '-' || character == '_') {
				if (sb.isEmpty()) continue
				val peek = sb[sb.length - 1]
				if (peek == '-' || peek == '_') continue
				sb.append(character)
			} else {
				throw IllegalArgumentException("Input string is not alphanumeric. (Unknown character: $character)")
			}
		}
		while (sb.isNotEmpty()) {
			val peek = sb[sb.length - 1]
			if (Character.isLetterOrDigit(peek)) break
			sb.deleteCharAt(sb.length - 1)
		}
		require(sb.isNotEmpty()) { "Cannot generate slug for '$input'." }
		return sb.toString()
	}

	/**
	 * Generates a new random string of the given chars with the given length.
	 * @param chars the characters
	 * @param length the length
	 * @return the generated string
	 */
	fun randomString(chars: CharArray, length: Int): String {
		val random = SecureRandom()
		val sb = StringBuilder()
		for (i in 0 until length) {
			sb.append(chars[random.nextInt(chars.size)])
		}
		return sb.toString()
	}

}
