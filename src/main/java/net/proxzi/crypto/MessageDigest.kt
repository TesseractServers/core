package net.proxzi.crypto

/**
 * A message digest.
 *
 * @since Core 1.1
 * @author Tassilo
 */
abstract class MessageDigest {

	/**
	 * Resets the current digest. This function should be called before invoking [update].
	 */
	abstract fun reset()

	/**
	 * Updates the digest with the given data.
	 * @param data the data
	 */
	abstract fun update(data: ByteArray)

	/**
	 * Returns the digest as a byte array.
	 * @return the digest
	 */
	abstract fun digest(): ByteArray

}
