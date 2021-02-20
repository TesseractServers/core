package net.proxzi.logging

import java.util.logging.Handler
import java.util.logging.LogRecord

/**
 * Creates a new LoggingHandlerAdapter with the underlying [Logger].
 * This class acts as a bridge between [java.util.logging.Logger] and [Logger].
 * @param logger the logger
 * @since Core 1.1
 * @author Tassilo
 */
class LoggingHandlerAdapter(private val logger: Logger): Handler() {

	override fun publish(record: LogRecord?) {
		if (record == null) return
		logger.log(when (record.level) {
			java.util.logging.Level.INFO -> Level.INFO
			java.util.logging.Level.FINE, java.util.logging.Level.FINER, java.util.logging.Level.FINEST -> Level.DEBUG
			java.util.logging.Level.WARNING -> Level.WARNING
			java.util.logging.Level.SEVERE -> Level.SEVERE
			else -> return
		}, record.message, record.thrown)
	}

	override fun flush() {
		// Do nothing
	}

	override fun close() {
		// Do nothing
	}

}
