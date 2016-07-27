package com.problem.phone;

public class Phone {
    public static String solution(String input) {
    	StringBuilder sb = new StringBuilder();

    	for (char c : input.toCharArray())
	    	if (Character.isDigit(c))
	    		sb.append(c);

    	int size = 0; // block size
    	for (int i = 0; i < sb.length() - 1; ++i)
    		if (++size == 3) {
    			if (sb.length() - 1 - i == 1) {
	    			sb.insert(i, '-');
	    			break;
    			} else {
	    			sb.insert(++i, '-');
	    			size = 0;
    			}
    		}

        return sb.toString();
    }
}
