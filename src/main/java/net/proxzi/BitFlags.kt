package net.proxzi

/**
 * This is a utility class for setting/getting flag statuses within a long.
 * @author Tassilo
 * @since Core 1.1
 */
object BitFlags {

	/**
	 * Returns whether a given flag is set in the given flag set.
	 * @param flags the flag set
	 * @param flag the flag to check for
	 * @return is set
	 */
	fun hasFlag(flags: Long, flag: Long): Boolean {
		return (flags and flag) == flag
	}

	/**
	 * Sets the given flag in the flag set.
	 * @param flags the flag set
	 * @param flag the flag to set
	 */
	fun setFlag(flags: Long, flag: Long): Long {
		return flags or flag
	}

	/**
	 * Unsets the given flag in the flag set.
	 * @param flags the flag set
	 * @param flag the flag to unset
	 */
	fun unsetFlag(flags: Long, flag: Long): Long {
		return flags and flag.inv()
	}

}
