package net.proxzi

import org.junit.Test
import kotlin.test.assertEquals

class StringsTest {

	@Test
	fun testGenerateSlug() {
		assertEquals("hello", "Hello".generateSlug())
		assertEquals("hello-world", "Hello-World".generateSlug())
		assertEquals("hello-world", "Hello World".generateSlug())
		assertEquals("hello-world", "Hello---World".generateSlug())
		assertEquals("hello-world", "Hello-_-World".generateSlug())
		assertEquals("hello_world", "Hello_--World".generateSlug())
	}

}
