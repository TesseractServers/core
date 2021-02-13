package net.proxzi;

/**
 * Utility class for string manipulation.
 * @since Core 1.0
 * @author Tassilo
 */
public class Strings {

	/**
	 * Represents a string containing all digits (0-9).
	 */
	public static final String DIGITS_STRING = "0123456789";

	/**
	 * Represents a char array containing all digits (0-9).
	 */
	public static final char[] DIGITS = DIGITS_STRING.toCharArray();

	/**
	 * Represents a string containing all latin uppercase letters (A-Z).
	 */
	@SuppressWarnings("SpellCheckingInspection")
	public static final String LETTERS_UPPERCASE_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * Represents a char array containing all latin uppercase letters (A-Z).
	 */
	public static final char[] LETTERS_UPPERCASE = LETTERS_UPPERCASE_STRING.toCharArray();

	/**
	 * Represents a string containing all latin lowercase letters (a-z).
	 */
	@SuppressWarnings("SpellCheckingInspection")
	public static final String LETTERS_LOWERCASE_STRING = "abcdefghijklmnopqrstuvwxyz";

	/**
	 * Represents a char array containing all latin lowercase letters (a-z).
	 */
	public static final char[] LETTERS_LOWERCASE = LETTERS_LOWERCASE_STRING.toCharArray();

	/**
	 * Represents a string containing all latin letters (A-Z, a-z).
	 */
	public static final String LETTERS_STRING = LETTERS_UPPERCASE_STRING + LETTERS_LOWERCASE_STRING;

	/**
	 * Represents a char array containing all latin letters (A-Z, a-z).
	 */
	public static final char[] LETTERS = LETTERS_STRING.toCharArray();

	/**
	 * Represents a string containing all latin letters and digits (A-Z, a-z, 0-9).
	 */
	public static final String ALPHANUMERIC_STRING = LETTERS_STRING + DIGITS_STRING;

	/**
	 * Represents a char array containing all latin letters and digits (A-Z, a-z, 0-9).
	 */
	public static final char[] ALPHANUMERIC = ALPHANUMERIC_STRING.toCharArray();



	/**
	 * Generates an URL slug for the input string. The input string must be alphanumeric.
	 * @param input the input string
	 * @return the generated slug
	 * @throws IllegalArgumentException if input string is not alphanumeric
	 */
	public static String generateSlug(String input) {
		if (input == null) throw new IllegalArgumentException("Input cannot be null.");
		input = input.replace(' ', '-');
		StringBuilder sb = new StringBuilder();
		for (char character : input.toCharArray()) {
			if (Character.isLetterOrDigit(character)) {
				sb.append(Character.toLowerCase(character));
			} else if (character == '-' || character == '_') {
				if (sb.length() == 0) continue;
				char peek = sb.charAt(sb.length() - 1);
				if (peek == '-' || peek == '_') continue;
				sb.append(character);
			} else {
				throw new IllegalArgumentException("Input string is not alphanumeric. (Unknown character: " + character + ")");
			}
		}
		while (sb.length() > 0) {
			char peek = sb.charAt(sb.length() - 1);
			if (Character.isLetterOrDigit(peek)) break;
			sb.deleteCharAt(sb.length() - 1);
		}
		if (sb.length() == 0) {
			throw new IllegalArgumentException("Cannot generate slug for '" + input + "'.");
		}
		return sb.toString();
	}



	/**
	 * Static class.
	 */
	private Strings() {
	}

}
