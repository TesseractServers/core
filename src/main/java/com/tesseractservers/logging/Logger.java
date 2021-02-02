package com.tesseractservers.logging;

/**
 * This class is used to publish logs.
 * @since Core 1.0
 * @author Tassilo
 */
public class Logger {

	private LogWriter[] writers;

	/**
	 * Creates a new logger with the given writers.
	 * @param writers the writers
	 */
	public Logger(LogWriter...writers) {
		this.writers = writers;
	}

	/**
	 * Adds more writers.
	 * @param add writers to add
	 */
	public void addWriters(LogWriter...add) {
		LogWriter[] temp = new LogWriter[writers.length + add.length];
		System.arraycopy(writers, 0, temp, 0, writers.length);
		System.arraycopy(add, 0, temp, writers.length, add.length);
		this.writers = temp;
	}

	/**
	 * Publishes a log.
	 * @param log the log
	 */
	public void publish(Log log) {
		for (LogWriter writer : writers) {
			writer.writeLog(log);
		}
	}



	public void log(Level level, String message, Throwable error) {
		publish(new Log(System.currentTimeMillis(), level, message, error));
	}

	public void log(Level level, String message) {
		log(level, message, null);
	}

	public void log(Level level, Throwable error) {
		log(level, null, error);
	}



	public void info(String message, Throwable error) {
		log(Level.INFO, message, error);
	}

	public void info(String message) {
		log(Level.INFO, message);
	}

	public void info(Throwable error) {
		log(Level.INFO, error);
	}



	public void debug(String message, Throwable error) {
		log(Level.DEBUG, message, error);
	}

	public void debug(String message) {
		log(Level.DEBUG, message);
	}

	public void debug(Throwable error) {
		log(Level.DEBUG, error);
	}



	public void warn(String message, Throwable error) {
		log(Level.WARNING, message, error);
	}

	public void warn(String message) {
		log(Level.WARNING, message);
	}

	public void warn(Throwable error) {
		log(Level.WARNING, error);
	}



	public void severe(String message, Throwable error) {
		log(Level.SEVERE, message, error);
	}

	public void severe(String message) {
		log(Level.SEVERE, message);
	}

	public void severe(Throwable error) {
		log(Level.SEVERE, error);
	}

}
