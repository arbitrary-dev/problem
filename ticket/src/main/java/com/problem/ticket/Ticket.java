package com.problem.ticket;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Ticket {
	public static void main(String[] args) {
		System.out.printf(
			"Answer should be 11: %d%n",
			solution(1, 2, 4, 5, 7, 29, 30)
		);
	}
	
	private static final int M = 31;
	
	private static final int
		T1 = 2,
		T7 = 7,
		T30 = 25;
	
	public static int solution(int... ds) {
		int[] ts = new int[M]; // trips
		int[] r = new int[M]; // result
		int j = 0;
		
		for (int i = 1; i < M; ++i) {
			ts[i] = ts[i - 1];
			r[i] = r[i - 1];
			
			if (j < ds.length && ds[j] == i) {
				ts[i] += 1;
				++j;
				
				int p = r[i] + T1; // ordinary ticket price increase
				r[i] = getTrips(ts, i - 7, i) > 3 ? min(r[max(0, i - 7)] + T7, p) : p;
			}
		}
		
		return min(T30, r[M - 1]);
	}
	
	/**
	 * Get trips count using prefix sum.
	 */
	private static int getTrips(int[] ts, int l, int r) {
		return ts[r] - ts[max(l, 0)];
	}
}
