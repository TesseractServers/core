package net.proxzi.math.vector

import kotlin.math.sqrt

/**
 * Represents a mathematical 3-dimensional vector using [Double]s.
 *
 * @since Core 1.1
 * @author Tassilo
 */
data class Vector3D(var x: Double, var y: Double, var z: Double): Vector3<Double, Vector3D>() {

	override fun plus(with: Vector3D): Vector3D {
		return Vector3D(x + with.x, y + with.y, z + with.z)
	}

	override fun minus(with: Vector3D): Vector3D {
		return Vector3D(x - with.x, y - with.y, z - with.z)
	}

	override fun times(with: Vector3D): Vector3D {
		return Vector3D(x * with.x, y * with.y, z * with.z)
	}

	override fun div(with: Vector3D): Vector3D {
		return Vector3D(x / with.x, y / with.y, z / with.z)
	}



	override fun unaryMinus(): Vector3D {
		return Vector3D(-x, -y, -z)
	}

	override fun unaryPlus(): Vector3D {
		return Vector3D(x, y, z)
	}



	override fun length(): Double {
		return sqrt(lengthSquared())
	}

	override fun lengthSquared(): Double {
		return (x * x) + (y * y) + (z * z)
	}



	override fun distance(other: Vector3D): Double {
		return sqrt(distanceSquared(other))
	}

	override fun distanceSquared(other: Vector3D): Double {
		return (other - this).lengthSquared()
	}



	override fun dot(with: Vector3D): Double {
		return (x * with.x) + (y * with.y) + (z * with.z)
	}

	override fun cross(with: Vector3D): Vector3D {
		return Vector3D(
			(y * with.z) - (z * with.y),
			(z * with.x) - (x * with.z),
			(x * with.y) - (y * with.x)
		)
	}

}
