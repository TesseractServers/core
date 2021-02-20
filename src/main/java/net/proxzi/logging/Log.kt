package net.proxzi.logging

/**
 * Represents a single log.
 * @since Core 1.1
 * @author Tassilo
 * @see Logger
 */
data class Log(

	/**
	 * The timestamp at which this log has been issued.
	 */
	val timestamp: Long,

	/**
	 * The level (or priority) of this log. Used for filtering.
	 */
	val level: Level,

	/**
	 * The message of this log. Can be null.
	 */
	val message: String?,

	/**
	 * The error associated with this log. Can be null.
	 */
	val error: Throwable?

)
