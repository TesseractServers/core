package net.proxzi.logging

/**
 * Creates a new logger with the given writers.
 * This class is used to publish logs.
 *
 * @param writers default writers
 *
 * @since Core 1.1
 * @author Tassilo
 */
class Logger(val writers: Set<LogWriter> = setOf()) {

	/**
	 * Publishes a log.
	 * @param log the log
	 */
	fun publish(log: Log) {
		for (writer in writers) {
			writer.writeLog(log)
		}
	}

	/**
	 * Creates a new log with the specified level.
	 * @param level the level
	 * @param message the message
	 * @param error the error
	 * @return the generated log
	 */
	fun log(level: Level, message: String? = null, error: Throwable? = null): Log {
		Log(System.currentTimeMillis(), level, message, error).also {
			publish(it)
			return it
		}
	}

	/**
	 * Creates a new log with the `INFO` level.
	 * @param message the message
	 * @param error the error
	 * @return the generated log
	 */
	fun info(message: String? = null, error: Throwable? = null): Log {
		return log(Level.INFO, message, error)
	}

	/**
	 * Creates a new log with the `DEBUG` level.
	 * @param message the message
	 * @param error the error
	 * @return the generated log
	 */
	fun debug(message: String? = null, error: Throwable? = null): Log {
		return log(Level.DEBUG, message, error)
	}

	/**
	 * Creates a new log with the `WARNING` level.
	 * @param message the message
	 * @param error the error
	 * @return the generated log
	 */
	fun warn(message: String? = null, error: Throwable? = null): Log {
		return log(Level.WARNING, message, error)
	}

	/**
	 * Creates a new log with the `SEVERE` level.
	 * @param message the message
	 * @param error the error
	 * @return the generated log
	 */
	fun severe(message: String? = null, error: Throwable? = null): Log {
		return log(Level.SEVERE, message, error)
	}

}
