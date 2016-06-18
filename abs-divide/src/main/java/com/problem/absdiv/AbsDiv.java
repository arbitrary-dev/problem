package com.problem.absdiv;

import static java.lang.Math.max;
import static java.lang.Math.abs;

public class AbsDiv {
	public static int solution(int... A) {
		int[] B = new int[A.length];
		
		int max = Integer.MIN_VALUE;
		for (int i = A.length - 1; i >= 0; --i)
			B[i] = max = max(max, A[i]);
		
		max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; ++i)
			A[i] = max = max(max, A[i]);
		
		max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length - 1; ++i)
			max = max(max, abs(A[i] - B[i + 1]));
		
		return max;
	}
}
