package net.proxzi

import net.proxzi.logging.Logger
import net.tassia.event.EventManager

/**
 * This class stores some global values, accessible for everyone.
 * @since Core 1.1
 * @author Tassilo
 */
object Global {

	/**
	 * Holds a global [EventManager].
	 */
	val EVENTS: EventManager = EventManager()

	/**
	 * Holds a global [Logger].
	 */
	val LOGGER: Logger = Logger()

}
