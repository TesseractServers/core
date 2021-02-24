package net.proxzi.math.vector

/**
 * Represents a mathematical vector with 3 dimensions.
 *
 * @since Core 1.1
 * @author Tassilo
 */
abstract class Vector3<TYPE, THIS>: Vector<TYPE, THIS>() {

	/**
	 * Calculates the cross product of this vector and the given vector.
	 *
	 * @param with the other vector
	 * @return the result
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Cross_product">Cross product</a>
	 */
	abstract fun cross(with: THIS): THIS

}
