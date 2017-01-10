package com.problem.phone;

import static java.lang.Character.isDigit;

public class Phone {
	public static String solution(String input) {
		StringBuilder sb = input
			.chars()
			.filter(c -> isDigit(c))
			.collect(
				() -> new StringBuilder(),
				(acc, i) -> {
					int L = acc.length();
					if (L > 3 && L % 4 == 0) acc.insert(L - 1, '-');
					acc.append((char) i);
				},
				null);

		int L = sb.length();
		if (L > 3 && L % 4 == 0) sb.insert(L - 2, '-');

        return sb.toString();
    }
}
