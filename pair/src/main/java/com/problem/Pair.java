package com.problem;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Pair {

	public static void solve(InputStream in, PrintStream out) {
		Scanner sc = new Scanner(in);

		try {
			if (!sc.hasNext()) return;

			int N = sc.nextInt();
			Set<Integer> missing = new TreeSet<>();

			for (Integer i = sc.nextInt(); ; i = sc.nextInt()) {
				if (missing.contains(i)) {
					out.print(1);
					return;
				}

				missing.add(N - i);

				if (!sc.hasNext()) break; // can't check in loop declaration
			}

			out.print(0);
		}
		finally {
			sc.close();
		}
	}

	public static void main(String[] args) {
		solve(System.in, System.out);
	}
}
