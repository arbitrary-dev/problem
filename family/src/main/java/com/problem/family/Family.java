package com.problem.family;

import java.util.Collections;
import java.util.PriorityQueue;

public class Family {
    public static int solution(int N) {
    	if (N == 0) return 0;
    	
        PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (char c : String.valueOf(N).toCharArray())
        	pq.add(c);
        
        StringBuilder sb = new StringBuilder();
        Character c = null;
        while ((c = pq.poll()) != null)
        	sb.append(c);
        
        return Integer.valueOf(sb.toString());
    }
}
