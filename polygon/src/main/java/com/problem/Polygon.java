package com.problem;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Polygon {

	private static final int
		// Type
		SQUARE	  = 0,
		RECTANGLE = 1,
		OTHER	  = 2,

		// Side
		A = 0,
		B = 1,
		C = 2,
		D = 3;

	public static void solve(InputStream in, PrintStream out) {
		Scanner sc = new Scanner(in);

		try {
			if (!sc.hasNext()) return;

			int[] res = new int[3];
			int[] side = new int[4];
			int i = 0;

			while (sc.hasNext()) {
				side[i] = sc.nextInt();

				if (i == 3) {
					if (	side[A] > 0 && side[B] > 0
							&& side[A] == side[C] && side[B] == side[D])
						++res[side[A] == side[B] ? SQUARE : RECTANGLE];
					else
						++res[OTHER];
				}

				i = (i + 1) % 4;
			}

			for (int cnt : res) out.printf("%d ", cnt);
		}
		finally {
			sc.close();
		}
	}

	public static void main(String[] args) {
		solve(System.in, System.out);
	}
}
