package com.problem.absdiv;

import static com.problem.absdiv.AbsDiv.solution;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AbsDivTest {
	@Test
	public void test0() {
		assertEquals(0, solution(6, 6));
	}

	@Test
	public void test4() {
		assertEquals(4, solution(4, 3, 2, 5, 1, 1));
	}

	@Test
	public void test6() {
		assertEquals(6, solution(1, 3, -3));
	}

	@Test
	public void test12() {
		assertEquals(12, solution(-6, 6));
	}
}
