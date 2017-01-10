package com.problem.phone;

import static java.lang.Character.isDigit;

public class Phone {
	public static String solution(String input) {
		StringBuilder sb = new StringBuilder();

		input.chars().forEach(c -> {
			if (!isDigit(c)) return;
			int L = sb.length();
			if (L > 3 && L % 4 == 0) sb.insert(L - 1, '-');
			sb.append((char) c);
		});

		int L = sb.length();
		if (L > 3 && L % 4 == 0) sb.insert(L - 2, '-');

        return sb.toString();
    }
}
