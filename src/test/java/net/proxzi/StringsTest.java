package net.proxzi;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringsTest {

	@Test
	public void testGenerateSlug() {
		assertEquals("hello", Strings.generateSlug("Hello"));
		assertEquals("hello-world", Strings.generateSlug("Hello-World"));
		assertEquals("hello-world", Strings.generateSlug("Hello World"));
		assertEquals("hello-world", Strings.generateSlug("Hello---World"));
		assertEquals("hello-world", Strings.generateSlug("Hello-_-World"));
		assertEquals("hello_world", Strings.generateSlug("Hello_--World"));
	}

}
