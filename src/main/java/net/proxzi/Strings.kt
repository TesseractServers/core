package net.proxzi

import java.security.SecureRandom

/**
 * Utility class for string manipulation.
 * @since Core 1.1
 * @author Tassilo
 */
object Strings {

	/**
	 * Represents a string containing all hexadecimal characters (0-9, a-f).
	 */
	@Suppress("SpellCheckingInspection")
	const val HEXADECIMAL = "0123456789abcdef"

	/**
	 * Represents a string containing all digits (0-9).
	 */
	const val DIGITS = "0123456789"

	/**
	 * Represents a string containing all latin uppercase letters (A-Z).
	 */
	@Suppress("SpellCheckingInspection")
	const val LETTERS_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

	/**
	 * Represents a string containing all latin lowercase letters (a-z).
	 */
	@Suppress("SpellCheckingInspection")
	const val LETTERS_LOWERCASE = "abcdefghijklmnopqrstuvwxyz"

	/**
	 * Represents a string containing all latin letters (A-Z, a-z).
	 */
	const val LETTERS = LETTERS_UPPERCASE + LETTERS_LOWERCASE

	/**
	 * Represents a string containing all latin letters and digits (A-Z, a-z, 0-9).
	 */
	const val ALPHANUMERIC = LETTERS + DIGITS



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
	fun randomString(chars: String, length: Int): String {
		val realChars = chars.toCharArray()
		val random = SecureRandom()
		val sb = StringBuilder(length)
		for (i in 0 until length) {
			sb.append(realChars[random.nextInt(realChars.size)])
		}
		return sb.toString()
	}

}
