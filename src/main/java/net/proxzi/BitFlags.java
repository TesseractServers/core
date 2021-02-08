package net.proxzi;

/**
 * This is a utility class for setting/getting flag statuses within a long.
 * @author Tassilo
 * @since Core 1.0
 */
public class BitFlags {

	/**
	 * Returns whether a given flag is set in the given flag set.
	 * @param flags the flag set
	 * @param flag the flag to check for
	 * @return is set
	 */
	public static boolean hasFlag(long flags, long flag) {
		return (flags & flag) == flag;
	}

	/**
	 * Sets the given flag in the flag set.
	 * @param flags the flag set
	 * @param flag the flag to set
	 */
	public static long setFlag(long flags, long flag) {
		return flags | flag;
	}

	/**
	 * Unsets the given flag in the flag set.
	 * @param flags the flag set
	 * @param flag the flag to unset
	 */
	public static long unsetFlag(long flags, long flag) {
		return flags & ~flag;
	}

	/**
	 * Static class.
	 */
	private BitFlags() {
	}

}
