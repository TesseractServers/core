package net.proxzi.logging

/**
 * Represents the level of a log entry. Used for filtering logs.
 * @param displayName the display name for this level
 * @since Core 1.1
 * @author Tassilo
 */
enum class Level(val displayName: String) {

	/**
	 * Used to log generic information.
	 */
	INFO(" INFO"),

	/**
	 * Used to log debug information. Spammy.
	 */
	DEBUG("DEBUG"),

	/**
	 * Used to log a warning or an error of which the application can recover without any side effects.
	 */
	WARNING(" WARN"),

	/**
	 * Used to log a severe error of which the application can't properly recover.
	 */
	SEVERE("ERROR"),

	/**
	 * Used to log the success of an action.
	 */
	SUCCESS("SUCCESS"),

	/**
	 * Used to log the failure of an action.
	 */
	FAILURE("FAILURE");

}
