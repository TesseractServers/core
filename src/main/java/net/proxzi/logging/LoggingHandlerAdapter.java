package net.proxzi.logging;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * This class acts as a bridge between {@link java.util.logging.Logger}
 * and {@link Logger}.
 * @since Core 1.0
 * @author Tassilo
 * @see java.util.logging.Logger
 * @see Logger
 */
public class LoggingHandlerAdapter extends Handler {

	private final Logger logger;

	/**
	 * Creates a new LoggingHandlerAdapter with the underlying {@link Logger}.
	 * @param logger the logger
	 */
	public LoggingHandlerAdapter(Logger logger) {
		this.logger = logger;
	}

	@Override
	public void publish(LogRecord record) {
		if (record.getLevel() == Level.INFO) {
			logger.info(record.getMessage(), record.getThrown());
		} else if (record.getLevel() == Level.FINE || record.getLevel() == Level.FINER || record.getLevel() == Level.FINEST) {
			logger.debug(record.getMessage(), record.getThrown());
		} else if (record.getLevel() == Level.WARNING) {
			logger.warn(record.getMessage(), record.getThrown());
		} else if (record.getLevel() == Level.SEVERE) {
			logger.severe(record.getMessage(), record.getThrown());
		}
	}

	@Override
	public void flush() {
		// Do nothing
	}

	@Override
	public void close() throws SecurityException {
		// Do nothing
	}

}
