package com.problem.family;

import org.junit.Test;

import static com.problem.family.Family.solution;
import static org.junit.Assert.assertEquals;

public class FamilyTest {
	@Test
	public void test0() {
		assertEquals(0, solution(0));
	}
	
	@Test
	public void test321() {
		assertEquals(321, solution(213));
	}

	@Test
	public void test553() {
		assertEquals(553, solution(553));
	}
	
	@Test
	public void test9999() {
		assertEquals(9999, solution(9999));
	}
	
	@Test
	public void test10000() {
		assertEquals(10000, solution(10000));
	}
}
