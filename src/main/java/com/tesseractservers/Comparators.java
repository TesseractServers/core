package com.tesseractservers;

import java.util.Comparator;

/**
 * Provides utility for {@link Comparator}s.
 * @since Core 1.0
 * @author Tassilo
 */
public class Comparators {

	/**
	 * Negates/Inverts the given comparator.
	 * @param source the comparator to invert
	 * @param <T> the type
	 * @return a comparator that behaves the opposite way
	 */
	public static <T> Comparator<T> negate(Comparator<T> source) {
		return (e1, e2) -> -source.compare(e1, e2);
	}



	/**
	 * Static class.
	 */
	private Comparators() {
	}

}
