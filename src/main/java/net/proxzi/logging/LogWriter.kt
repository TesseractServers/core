package net.proxzi.logging

/**
 * This functional interface is used to write logs to console, files or store them in databases.
 * @since Core 1.1
 * @author Tassilo
 */
@FunctionalInterface
interface LogWriter {

	/**
	 * Writes the given log to e.g. a console or a file.
	 * @param log the log to write
	 */
	fun writeLog(log: Log)

}
