package com.problem;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class PairTest {

	private static void asrt(String file, String output) throws FileNotFoundException {
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		Pair.solve(is, ps);

		String res = new String(baos.toByteArray(), StandardCharsets.UTF_8);
		assertEquals(output, res.trim());
	}

	@Test public void test1() throws FileNotFoundException {
		asrt("sample-1.txt", "1");
	}

	@Test public void test2() throws FileNotFoundException {
		asrt("sample-2.txt", "0");
	}
}
