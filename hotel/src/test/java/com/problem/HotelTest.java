package com.problem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

public class HotelTest {

	private static void asrt(String file, String output) throws FileNotFoundException {
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		Hotel.solve(is, ps);

		String res = new String(baos.toByteArray(), StandardCharsets.UTF_8);
		assertEquals(output, res.trim());
	}

	@Test public void test1() throws FileNotFoundException {
		asrt("sample-1.txt", "2 1");
	}

	@Test public void test2() throws FileNotFoundException {
		asrt("sample-2.txt", "2 3 1");
	}

	private static void asrtWords(String s, String... words) {
		List<String> list = new ArrayList<>();
		Hotel.forWords(s, w -> list.add(w));
		assertThat(list, IsIterableContainingInOrder.contains(words));
	}

	@Test public void testReadWords() {
		asrtWords("breakfast beach citycenter location metro view staff price",
			"breakfast", "beach", "citycenter", "location", "metro", "view", "staff", "price");
		asrtWords("One two three", "one", "two", "three");
		asrtWords("One", "one");
		asrtWords(" tWo!", "two");
		asrtWords("Three, three ,three! four", "three", "three", "three", "four");
	}
}
