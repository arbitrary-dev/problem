package com.problem;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import com.problem.Delta;

public class DeltaTest {
	
	private static void asrt(String file, String output) throws FileNotFoundException {
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		Delta.solve(is, ps);
		
		String res = new String(baos.toByteArray(), StandardCharsets.UTF_8);
		assertEquals(output, res.trim());
	}
	
	@Test public void test1() throws FileNotFoundException {
		asrt("sample-1.txt", "25626 -128 131 -128 -1390 -100 -128 -24251 84 "
			+ "-98 -128 7275");
	}
	
	@Test public void test2() throws FileNotFoundException {
		asrt("sample-2.txt", "25757 -128 -1390 -100");
	}
}
