package com.tesseractservers.logging;

/**
 * Represents a single log.
 * @since Core 1.0
 * @author Tassilo
 * @see Logger
 */
public class Log {

	private final long timestamp;
	private final Level level;
	private final String message;
	private final Throwable error;

	/**
	 * Constructs a new log with the given timestamp, level, message and error.
	 * @param timestamp the timestamp (see {@link System#currentTimeMillis()})
	 * @param level the level
	 * @param message the message, can be <code>null</code>
	 * @param error the error, can be <code>null</code>
	 */
	public Log(long timestamp, Level level, String message, Throwable error) {
		this.timestamp = timestamp;
		this.level = level;
		this.message = message;
		this.error = error;
	}

	/**
	 * Returns the timestamp at which this log has been issued.
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * Returns the level (or priority) of this log. Used for filtering.
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Returns the message of this log. Can be <code>null</code>.
	 * @return the message or <code>null</code>
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Returns the error associated with this log. Can be <code>null</code>.
	 * @return the error or <code>null</code>
	 */
	public Throwable getError() {
		return error;
	}

}
