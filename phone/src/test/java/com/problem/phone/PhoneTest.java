package com.problem.phone;

import org.junit.Test;

import static com.problem.phone.Phone.solution;
import static org.junit.Assert.assertEquals;

public class PhoneTest {
	private static void asrt(String exp, String act) {
		assertEquals(exp, solution(act));
	}
	
	@Test
	public void test1() {
		asrt("004-448-555-583-61", "00-44  48 5555 8361");
	}
	
	@Test
	public void test2() {
		asrt("022-198-53-24", "0 - 22 1985--324");
	}
	
	@Test
	public void test3() {
		asrt("22", " - 22 --");
	}
	
	@Test
	public void test4() {
		asrt("23-32", " - 23 --32");
	}
	
	@Test
	public void test5() {
		asrt("555-372-654", "555372654");
	}
}
