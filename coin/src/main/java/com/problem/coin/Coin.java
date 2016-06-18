package com.problem.coin;

import static java.lang.Math.max;

public class Coin {
    public static int solution(int... A) {
        int n = A.length;
        int res = 0;

        for (int i = 0; i < n - 1; i++)
            if (A[i] == A[i + 1])
                ++res;

        int r = -1;
        for (int i = 0; i < n; i++) {
            int c = 0;

            if (i > 0)
                c += A[i] == A[i - 1] ? -1 : 1;
            if (i < n - 1)
                c += A[i] == A[i + 1] ? -1 : 1;

            r = max(r, c);
        }

        return res + r;
    }
}
