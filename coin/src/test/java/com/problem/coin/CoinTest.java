package com.problem.coin;

import org.junit.Test;

import static com.problem.coin.Coin.solution;
import static org.junit.Assert.assertEquals;

public class CoinTest {
	@Test
	public void test0_1() {
		assertEquals(0, solution(1));
	}
	
	@Test
	public void test0_2() {
		assertEquals(0, solution(0));
	}
	
	@Test
	public void test0_3() {
		assertEquals(0, solution(0, 0));
	}
	
	@Test
	public void test0_4() {
		assertEquals(0, solution(1, 1));
	}
	
	@Test
	public void test1_2() {
		assertEquals(1, solution(0, 1));
	}

	@Test
	public void test2_1() {
		assertEquals(2, solution(1, 0, 1, 0, 1));
	}

	@Test
	public void test2_2() {
		assertEquals(2, solution(0, 1, 0, 1, 0));
	}
	
	@Test
	public void test3_1() {
		assertEquals(3, solution(0, 0, 0, 1, 1));
	}
	
	@Test
	public void test3_2() {
		assertEquals(3, solution(1, 1, 1, 1, 1));
	}
	
	@Test
	public void test3_3() {
		assertEquals(3, solution(0, 0, 0, 0, 0));
	}
	
	@Test
	public void test4_1() {
		assertEquals(4, solution(1, 1, 0, 1, 0, 0));
	}
	
	@Test
	public void test4_4() {
		assertEquals(4, solution(0, 0, 0, 0, 1));
	}
	
	@Test
	public void test4_5() {
		assertEquals(4, solution(0, 0, 0, 0, 1, 1));
	}
	
	@Test
	public void test4_6() {
		assertEquals(4, solution(0, 0, 1, 0, 0));
	}
	
	@Test
	public void test4_7() {
		assertEquals(4, solution(1, 0, 0, 0, 0));
	}
	
	@Test
	public void test6() {
		assertEquals(6, solution(0, 0, 0, 0, 1, 1, 1, 1));
	}
}
