package com.problem.intstreamiter;

import static org.junit.Assert.assertArrayEquals;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class IntStreamTest {

    private static void asrt(int[] exp, String input) {
        Reader reader = new StringReader(input);
        IntStream is = new IntStream(reader);
        List<Integer> list = new ArrayList<Integer>();

        for (Integer i : is)
            list.add(i);

        int[] act = list.stream().mapToInt(i -> i).toArray();

        assertArrayEquals(exp, act);
    }

    private static int[] c(int... arr) {
        return arr;
    }

    @Test
    public void test1() {
        asrt(
            c(137, -104, 0, 1, 0, -1),
            "137\n-104\n2 58\n  +0\n++3\n  +1   \n 23.9\n2000000000\n-0\nfive\n -1"
        );
    }

    @Test
    public void test2() {
        asrt(
            c(0, 2, -4),
            "0\n01\n +2\n 003  \n  -4 "
        );
    }
}
