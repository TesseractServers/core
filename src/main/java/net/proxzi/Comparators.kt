package net.proxzi

/**
 * Provides utility for [Comparator]s.
 * @since Core 1.1
 * @author Tassilo
 */
object Comparators {

	/**
	 * Negates/Inverts the comparator.
	 * @param comparator the comparator to negate
	 * @param <T> the type
	 * @return a comparator that behaves the opposite way
	 */
	fun <T> negate(comparator: Comparator<T>): Comparator<T> {
		return Comparator { o1, o2 -> -comparator.compare(o1, o2) }
	}

}
