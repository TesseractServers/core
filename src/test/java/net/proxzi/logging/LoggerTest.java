package net.proxzi.logging;

import org.junit.Test;

public class LoggerTest {

	@Test
	public void test() {
		Logger logger = new Logger();
		logger.addWriters(new PrintStreamLogWriter());

		logger.info("Hello World!");
		logger.debug("Hello Debug!");
		logger.warn("Hello Warning!");
		logger.severe("Hello Error!");
		logger.log(Level.SUCCESS, "Hello Success!");
		logger.log(Level.FAILURE, "Hello Failure!");

		logger.severe(new Exception("Not a real error. Just for testing :)"));
	}

}
