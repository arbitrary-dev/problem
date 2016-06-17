package com.problem.lift;

import java.util.HashSet;

public class Lift {
	public static int solution(int[] F, int[] W, int L) {
		if (F.length == 0)
			return 0;
		
		int r = 0;
		int l = L;
		
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i <= F.length; ++i) {
			if (i == F.length || l - W[i] < 0) {
				r += set.size() + 1;
				set.clear();
				l = L;
				
				if (i == F.length)
					break;
			}
			
			set.add(F[i]);
			l -= W[i];
		}
		
		return r;
	}
}
