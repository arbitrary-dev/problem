package com.problem.lift;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static com.problem.lift.Lift.solution;

public class LiftTest {
	@Test
	public void test0() {
		assertEquals(
			0,
			solution(
				new int[] { },
				new int[] { },
				200
			)
		);
	}
	
	@Test
	public void test6() {
		assertEquals(
			6,
			solution(
				new int[] { 2, 2, 2, 2 },
				new int[] { 50, 50, 50, 70 },
				100
			)
		);
	}
	
	@Test
	public void test9() {
		assertEquals(
			9,
			solution(
				new int[] { 2, 1, 2, 3, 3, 3, 5 },
				new int[] { 50, 70, 80, 120, 120, 60, 30 },
				200
			)
		);
	}
	
	@Test
	public void test11() {
		assertEquals(
			11,
			solution(
				new int[] { 1, 2, 3, 4, 5, 6 },
				new int[] { 50, 70, 80, 90, 100, 120 },
				120
			)
		);
	}
}
