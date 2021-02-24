package net.proxzi.math.vector

import kotlin.math.sqrt

/**
 * Represents a mathematical 3-dimensional vector using [Float]s.
 *
 * @since Core 1.1
 * @author Tassilo
 */
data class Vector3F(var x: Float, var y: Float, var z: Float): Vector3<Float, Vector3F>() {

	override fun plus(with: Vector3F): Vector3F {
		return Vector3F(x + with.x, y + with.y, z + with.z)
	}

	override fun minus(with: Vector3F): Vector3F {
		return Vector3F(x - with.x, y - with.y, z - with.z)
	}

	override fun times(with: Vector3F): Vector3F {
		return Vector3F(x * with.x, y * with.y, z * with.z)
	}

	override fun div(with: Vector3F): Vector3F {
		return Vector3F(x / with.x, y / with.y, z / with.z)
	}



	override fun unaryMinus(): Vector3F {
		return Vector3F(-x, -y, -z)
	}

	override fun unaryPlus(): Vector3F {
		return Vector3F(x, y, z)
	}



	override fun length(): Float {
		return sqrt(lengthSquared())
	}

	override fun lengthSquared(): Float {
		return (x * x) + (y * y) + (z * z)
	}



	override fun distance(other: Vector3F): Float {
		return sqrt(distanceSquared(other))
	}

	override fun distanceSquared(other: Vector3F): Float {
		return (other - this).lengthSquared()
	}



	override fun dot(with: Vector3F): Float {
		return (x * with.x) + (y * with.y) + (z * with.z)
	}

	override fun cross(with: Vector3F): Vector3F {
		return Vector3F(
			(y * with.z) - (z * with.y),
			(z * with.x) - (x * with.z),
			(x * with.y) - (y * with.x)
		)
	}

}
