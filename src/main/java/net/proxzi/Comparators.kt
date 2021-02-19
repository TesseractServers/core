package net.proxzi

/**
 * Provides utility for {@link Comparator}s.
 * @since Core 1.1
 * @author Tassilo
 */
object Comparators {

	/**
	 * Negates/Inverts the comparator.
	 * @param <T> the type
	 * @return a comparator that behaves the opposite way
	 */
	fun <T> Comparator<T>.negate(): Comparator<T> {
		return Comparator { o1, o2 -> -this.compare(o1, o2) }
	}

}
