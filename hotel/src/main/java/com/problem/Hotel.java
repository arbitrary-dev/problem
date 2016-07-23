package com.problem;

import static java.text.BreakIterator.DONE;

import java.io.InputStream;
import java.io.PrintStream;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Hotel {
    private static class HotelScore implements Comparable<HotelScore> {
    	final Integer id;
    	int score;
    	
    	public HotelScore(Integer id) {
    		this.id = id;
    	}
    	
		public void scoreReview(String r, Set<String> words) {
			List<String> rwords = new ArrayList<String>();
			readWords(r, rwords);
    		for (String rw : rwords)
    			if (words.contains(rw))
    				++score;
    	}

		@Override
		public String toString() {
			return String.valueOf(id);
		}

		@Override
		public int compareTo(HotelScore o) {
			int res = o.score - score;
			if (res != 0) return res;
			return id - o.id;
		}
    }

	private static void readWords(String from, Collection<String> to) {
    	BreakIterator bi = BreakIterator.getWordInstance(Locale.US);
    	bi.setText(from);
    	
    	if (bi.first() == DONE) return;

    	for (int first = bi.first(), last = bi.next(); last != DONE; first = last, last = bi.next())
    		if (Character.isLetter(from.charAt(first)))
    			to.add(from.substring(first, last).toLowerCase(Locale.US));
	}
    
    public static void solve(InputStream in, PrintStream out) {
    	Scanner sc = new Scanner(in);
    	
    	try {
	    	if (!sc.hasNext()) return;
	    	
	    	Set<String> words = new HashSet<>();
	    	readWords(sc.nextLine(), words);
	    	int M = sc.nextInt();
	    	
	    	Map<Integer, HotelScore> hotels = new HashMap<>();
	    	for (int i = 0; i < M; ++i) {
	    		Integer id = sc.nextInt();
	    		sc.nextLine(); // skip to next line
	    		
	    		HotelScore h = hotels.get(id);
	    		if (h == null) hotels.put(id, h = new HotelScore(id));
	    		
	    		h.scoreReview(sc.nextLine(), words);
	    	}

	    	Set<HotelScore> res = new TreeSet<>();
	    	for (HotelScore h : hotels.values()) res.add(h);
	    	for (HotelScore h : res) out.printf("%s ", h);
    	}
    	finally {
	    	sc.close();
    	}
    }
    
    public static void main(String[] args) {
    	solve(System.in, System.out);
	}
}
