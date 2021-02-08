package net.proxzi.logging;

/**
 * Represents the level of a log entry. Used for filtering logs.
 * @since Core 1.0
 * @author Tassilo
 */
public enum Level {

	/**
	 * Used to log generic information.
	 */
	INFO	(" INFO"),

	/**
	 * Used to log debug information. Spammy.
	 */
	DEBUG	("DEBUG"),

	/**
	 * Used to log a warning or an error of which the application can recover without any side effects.
	 */
	WARNING	(" WARN"),

	/**
	 * Used to log a severe error of which the application can't properly recover.
	 */
	SEVERE	("ERROR"),

	/**
	 * Used to log the success of an action.
	 */
	SUCCESS	("SUCCESS"),

	/**
	 * Used to log the failure of an action.
	 */
	FAILURE	("FAILURE");

	private final String displayName;

	Level(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Returns the display name of this log level. Note, that this display name contains indentation,
	 * which assures that all display names are the same length. The display name of {@link #SUCCESS}
	 * and {@link #FAILURE} are an exception to this by being 2 chars longer than the rest.
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

}
