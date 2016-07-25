package com.problem;

import static java.text.BreakIterator.DONE;

import java.io.InputStream;
import java.io.PrintStream;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Hotel {

	static void solve(InputStream in, PrintStream out) {
		Scanner sc = new Scanner(in);

		try {
			if (!sc.hasNext()) return;

			Set<String> words = new HashSet<>();
			readWords(sc.nextLine(), words);
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

		private final Map<Score, Score> scores = new TreeMap<>();
		private final Set<String> words;

		public Reviewer(Set<String> words) {
			this.words = words;
		}

		public void review(int id, String review) {
			Score neu = new Score(id);
			Score old = scores.remove(neu);
			Score score = (old == null) ? neu : old; // try to get old score or create new otherwise

			// init score
			if (score.val == -1) score.val = 0;

			// update score
			List<String> rwords = new ArrayList<>();
			readWords(review, rwords);
			for (String rw : rwords)
				if (words.contains(rw))
					++score.val;

			scores.put(score, score); // put it back
		}

		@Override
		public Iterator<Score> iterator() {
			return scores.keySet().iterator();
		}
	}

	private static class Score implements Comparable<Score> {

		private final int id;
		private int val = -1;

		public Score(int id) {
			this.id = id;
		}

		@Override
		public int compareTo(Score o) {
			// val = -1 is used to be able to search score by id in a TreeSet
			return (val != -1 && o.val != -1 && o.val != val)
				? o.val - val : id - o.id;
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

	static void readWords(String from, Collection<String> to) {
		BreakIterator bi = BreakIterator.getWordInstance(Locale.US);
		bi.setText(from);

		if (bi.first() == DONE) return;

		for (int first = bi.first(), last = bi.next(); last != DONE; first = last, last = bi.next())
			if (Character.isLetter(from.charAt(first)))
				to.add(from.substring(first, last).toLowerCase(Locale.US));
	}
}
