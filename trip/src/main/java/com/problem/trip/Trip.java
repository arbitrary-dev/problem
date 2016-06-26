package com.problem.trip;

public class Trip {
	public static int solution(int... A) {
		int[] B = new int [A.length];
		
		for (int i : A) ++B[i];
		
		int a = 0, b = A.length - 1;

		while (!(a == b || --B[A[a]] == 0)) ++a;
		while (!(a == b || --B[A[b]] == 0)) --b;
		
		return b - a + 1;
	}
}
