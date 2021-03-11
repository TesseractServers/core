package net.proxzi.data

/**
 * Represents a single entry of a stack.
 *
 * @since Core 1.1
 * @author Tassilo
 */
data class StackEntry<T>(

	/**
	 * The actual value linked to the stack.
	 */
	val value: T,

	/**
	 * The stack entry that comes after this one.
	 */
	val next: StackEntry<T>?

)
