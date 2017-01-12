package com.problem.intstreamiter;

import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntStream implements Iterable<Integer> {

    private final Reader reader;

    public IntStream(Reader reader) {
        this.reader = reader;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StreamIterator();
    }

    private static final Pattern INT_PATTERN = Pattern.compile("^\\s*([+-]?(0|10{9}|[1-9]\\d{0,8}))\\s*$");

    private class StreamIterator implements Iterator<Integer> {

        private Scanner sc   = new Scanner(reader);
        private Integer curr = null;

        @Override
        public boolean hasNext() {
            if (curr == null)
                curr = lookAhead();
            return curr != null;
        }

        @Override
        public Integer next() {
            Integer next = hasNext() ? curr : null;
            if (next == null)
                throw new NoSuchElementException();
            curr = null;
            return next;
        }

        private Integer lookAhead() {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Matcher m = INT_PATTERN.matcher(line);

                if (m.find()) {
                    // System.out.println(line);
                    return Integer.valueOf(m.group(1));
                }
            }

            return null;
        }
    }
}
