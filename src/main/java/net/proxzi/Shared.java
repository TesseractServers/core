package net.proxzi;

import net.proxzi.database.Database;
import net.tassia.event.EventManager;

/**
 * This class contains static fields which can be accessed by other systems for cleaner code.
 * @since Core 1.0
 * @author Tassilo
 */
public class Shared {

	/**
	 * This static field holds a reference to a shared {@link EventManager}.
	 */
	public static final EventManager EVENTS = new EventManager();

	/**
	 * This static field holds a reference to a shared global database connection.
	 */
	public static Database DATABASE = null;



	/**
	 * Static class.
	 */
	private Shared() {
	}

}
