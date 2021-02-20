package net.proxzi

/**
 * Generates an URL slug for the this string. This string must be alphanumeric.
 * @return the generated slug
 * @throws IllegalArgumentException if this string is not alphanumeric
 * @see Strings.generateSlug
 */
fun String.generateSlug(): String {
	return Strings.generateSlug(this)
}
