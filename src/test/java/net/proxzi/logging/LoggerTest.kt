package net.proxzi.logging

import java.lang.Exception
import kotlin.test.Test

class LoggerTest {

	@Test
	fun test() {
		val logger = Logger()
		logger.writers.add(PrintStreamLogWriter())

		logger.info("Hello World!")
		logger.debug("Hello Debug!")
		logger.warn("Hello Warning!")
		logger.severe("Hello Error!")
		logger.log(Level.SUCCESS, "Hello Success!")
		logger.log(Level.FAILURE, "Hello Failure!")

		logger.severe(error = Exception("Not a real error. Just for testing :)"))
	}

}
