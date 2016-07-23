package com.problem;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Delta {

	public static void solve(InputStream in, PrintStream out) {
		Scanner sc = new Scanner(in);

		try {
			if (!sc.hasNext()) return;

			int prev = sc.nextInt();
			out.printf("%d ", prev); // the first element reproduced as-is

			// Assume input numbers are all positive.
			for (int i = sc.nextInt(); ; prev = i, i = sc.nextInt()) {
				int delta = i - prev;

				if (Math.abs(delta) > 127)
					out.print("-128 ");

				out.printf("%d ", delta);

				if (!sc.hasNext()) break; // can't check in loop declaration
			}
		}
		finally {
			sc.close();
		}
	}

	public static void main(String[] args) {
		solve(System.in, System.out);
	}
}
