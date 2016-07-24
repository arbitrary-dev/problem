package com.problem;

import static java.text.BreakIterator.DONE;

import java.io.InputStream;
import java.io.PrintStream;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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

			TreeMap<HotelScore,HotelScore> scores = new TreeMap<>(); // sorted map
			for (int i = 0; i < M; ++i) {
				HotelScore hs = retrieve(scores, sc.nextInt()); // remove from map or create new
				sc.nextLine(); // skip to the next line
				hs.scoreReview(sc.nextLine(), words); // update
				scores.put(hs, hs); // put it back
			}

			for (HotelScore h : scores.keySet()) out.printf("%s ", h);
		}
		finally {
			sc.close();
		}
	}

	public static void main(String[] args) {
		solve(System.in, System.out);
	}

	private static HotelScore retrieve(Map<HotelScore,HotelScore> map, int id) {
		HotelScore neu = new HotelScore(id);
		HotelScore old = map.remove(neu);
		return old == null ? neu : old;
	}

	private static class HotelScore implements Comparable<HotelScore> {

		final Integer id;
		int score = -1;

		public HotelScore(Integer id) {
			if (id == null)
				throw new NullPointerException();
			this.id = id;
		}

		public void scoreReview(String r, Set<String> words) {
			if (score == -1) score = 0;

			List<String> rwords = new ArrayList<String>();
			readWords(r, rwords);
			for (String rw : rwords)
				if (words.contains(rw))
					++score;
		}

		@Override
		public String toString() {
			return id.toString();
		}

		@Override
		public int compareTo(HotelScore o) {
			return (score != -1 && o.score != -1 && o.score != score)
				? o.score - score : id - o.id;
		}

		@Override
		public int hashCode() {
			return id.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || !(obj instanceof HotelScore))
				return false;
			return id.equals(((HotelScore) obj).id);
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
