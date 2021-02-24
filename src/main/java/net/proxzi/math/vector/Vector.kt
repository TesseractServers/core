package net.proxzi.math.vector

/**
 * Represents a mathematical vector with n-dimensions.
 *
 * @since Core 1.1
 * @author Tassilo
 */
abstract class Vector<TYPE, THIS> {

	/**
	 * Defines how many dimensions this vector has.
	 */
	abstract val dimensions: Int



	/**
	 * Adds the given vector to this vector and returns the result.
	 *
	 * @param with the other vector
	 * @return the result
	 */
	abstract operator fun plus(with: THIS): THIS

	/**
	 * Subtracts the given vector from this vector and returns the result.
	 *
	 * @param with the other vector
	 * @return the result
	 */
	abstract operator fun minus(with: THIS): THIS

	/**
	 * Multiplies the given vector with this vector and returns the result.
	 *
	 * @param with the other vector
	 * @return the result
	 */
	abstract operator fun times(with: THIS): THIS

	/**
	 * Divides the given vector form this vector and returns the result.
	 *
	 * @param with the other vector
	 * @return the result
	 */
	abstract operator fun div(with: THIS): THIS



	/**
	 * Negates the vector.
	 *
	 * @return the resulting vector
	 */
	abstract operator fun unaryMinus(): THIS

	/**
	 * Literally does nothing with this vector apart from creating a copy.
	 *
	 * @return a copy
	 */
	abstract operator fun unaryPlus(): THIS



	/**
	 * Returns the length of this vector.
	 *
	 * @return the length
	 */
	abstract fun length(): TYPE

	/**
	 * Returns the squared length of this vector. This is faster
	 * than [length], as no square root needs to be calculated.
	 *
	 * @return the length (squared)
	 */
	abstract fun lengthSquared(): TYPE



	/**
	 * Returns the distance between this vector and the given vector.
	 *
	 * @param other the other vector
	 * @return the distance
	 */
	abstract fun distance(other: THIS): TYPE

	/**
	 * Returns the squared distance between this vector and the given vector.
	 * This is faster than [distance], as no square root needs to be calculated.
	 *
	 * @param other the other vector
	 * @return the distance (squared)
	 */
	abstract fun distanceSquared(other: THIS): TYPE



	/**
	 * Calculates the dot product of this vector and the given vector.
	 *
	 * @param with the other vector
	 * @return the result
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Dot_product">Dot product</a>
	 */
	abstract fun dot(with: THIS): TYPE

}
