package com.problem.trip;

import org.junit.Test;

import static com.problem.trip.Trip.solution;
import static org.junit.Assert.assertEquals;

public class TripTest {
	@Test
	public void test1() {
		assertEquals(1, solution(3, 3, 3, 3));
	}
	
	@Test
	public void test5() {
		assertEquals(5, solution(7, 3, 7, 3, 1, 3, 4, 1));
	}
	
	@Test
	public void test9() {
		assertEquals(9, solution(8, 3, 7, 3, 1, 3, 4, 1, 0, 4, 7, 7));
	}
}
