package com.problem.ticket;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static com.problem.ticket.Ticket.solution;

public class TicketTest {
	@Test
	public void test0() {
		assertEquals(0, solution());
	}
	
	@Test
	public void test11_1() {
		assertEquals(11, solution(1, 2, 4, 5, 7, 29, 30));
	}

	@Test
	public void test11_2() {
		assertEquals(11, solution(1, 2, 24, 26, 27, 29, 30));
	}

	@Test
	public void test25() {
		assertEquals(
			25,
			solution(1, 3, 5, 7, 9, 11, 13, 15,
					 17, 19, 21, 23, 25, 27, 29)
		);
	}

	@Test
	public void test24() {
		assertEquals(
			24,
			solution(1, 3, 5, 9, 10, 13, 14, 15,
					 17, 19, 21, 23, 24, 27)
		);
	}
}
