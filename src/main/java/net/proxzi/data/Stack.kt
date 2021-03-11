package net.proxzi.data

/**
 * Represents a simple stack. Implemented in Kotlin.
 *
 * @since Core 1.1
 * @author Tassilo
 */
class Stack<T> {

	/**
	 * Holds a reference to the current head (top) of the stack.
	 */
	private var head: StackEntry<T>? = null



	/**
	 * Pushes a new value onto the stack.
	 *
	 * @param value the value
	 */
	fun push(value: T) {
		head = StackEntry(value, head)
	}

	/**
	 * Pops the top value from the stack and returns it.
	 *
	 * @return the value, or `null` if the stack was empty
	 */
	fun pop(): T? {
		val value = head?.value
		head = head?.next
		return value
	}



	/**
	 * Peeks at the top of the stack and returns the value.
	 *
	 * @return the value, or `null` if the stack is empty
	 */
	fun peek(): T? {
		return head?.value
	}

}
