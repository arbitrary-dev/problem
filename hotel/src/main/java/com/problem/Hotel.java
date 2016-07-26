package com.problem;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Hotel {

	static void solve(InputStream in, PrintStream out) {
		Scanner sc = new Scanner(in);

		try {
			if (!sc.hasNext()) return;

			Set<String> words = new HashSet<>();
			forWords(sc.nextLine(), w -> words.add(w));
			int M = sc.nextInt();

			Reviewer revr = new Reviewer(words);
			for (int i = 0; i < M; ++i) {
				int id = sc.nextInt();
				sc.nextLine(); // skip to the next line
				String rev = sc.nextLine();
				revr.review(id, rev);
			}

			for (Score s : revr) out.printf("%s ", s);
		}
		finally {
			sc.close();
		}
	}

	public static void main(String[] args) {
		solve(System.in, System.out);
	}

	private static class Reviewer implements Iterable<Score> {

		private final Map<Integer, Score> h2s = new TreeMap<>();
		private final Set<Score> scores = new TreeSet<>();
		private final Set<String> words;

		public Reviewer(Set<String> words) {
			this.words = words;
		}

		public void review(int id, String review) {
			Score old = h2s.get(id);
			if (old == null)
				h2s.put(id, old = new Score(id));
			else
				scores.remove(old);
			final Score score = old;

			forWords(review, w -> { if (words.contains(w)) ++score.val; }); // update
			scores.add(score); // put it back
		}

		@Override
		public Iterator<Score> iterator() {
			return scores.iterator();
		}
	}

	private static class Score implements Comparable<Score> {

		private final int id;
		private int val;

		public Score(int id) {
			this.id = id;
		}

		@Override
		public int compareTo(Score o) {
			return o.val != val ? o.val - val : id - o.id;
		}

		@Override
		public int hashCode() {
			return Integer.hashCode(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || !(obj instanceof Score))
				return false;
			return id == ((Score) obj).id;
		}

		@Override
		public String toString() {
			return String.valueOf(id);
		}
	}

	private static final Pattern DELIMITER = Pattern.compile("[\\s,.!?'\"]+");

	static interface Func {
		public void apply(String s);
	}

	static void forWords(String from, Func func) {
		Scanner sc = new Scanner(from);
		sc.useDelimiter(DELIMITER);

		try {
			while (sc.hasNext())
				func.apply(sc.next().toLowerCase());
		}
		finally {
			sc.close();
		}
	}
}
