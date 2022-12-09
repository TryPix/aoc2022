package day2;


import java.util.*;
import java.io.*;

public class RockPaperScissors {

	public static void main(String[] args)throws FileNotFoundException  {
		
		File in = new File("day2/aoc2.txt");
		System.out.println("Part 1: " + points(in, false));
		System.out.println("Part 2: " + points(in, true));

	}
	
	static int points(File input, boolean part2) throws FileNotFoundException {
		Scanner scan = new Scanner(input);
		int pts = 0;
		int pts2 = 0;
		Map<String, Integer> rps = new HashMap<>();
		rps.put("X", 1); rps.put("Y", 2); rps.put("Z", 3);
		
		Map<String, String> beats = new HashMap<>();
		beats.put("X", "C"); beats.put("Y", "A"); beats.put("Z", "B");  
		
		Map<String, String> draws = new HashMap<>();
		draws.put("X", "A"); draws.put("Y", "B"); draws.put("Z", "C");  
		
		while (scan.hasNextLine()) {
			String a = scan.nextLine();
			Scanner lineScan = new Scanner(a);
			String opp = lineScan.next();
			String yours = lineScan.next();
			pts += ptsRound(opp, yours,rps, beats, draws);
			pts2 += ptsRound2(opp, yours);
		lineScan.close();
		}
		scan.close();
		
		if (part2) {
			return pts2;
		}
		return pts;
	}
	
	
	public static int ptsRound(String opp, String yours, Map<String, Integer> rps, Map<String, String> beats, Map<String, String> draws) {
		int pts = 0;
		pts += rps.get(yours);
		if (beats.get(yours).equals(opp)) {
			pts += 6;
		} if (draws.get(yours).equals(opp)) {
			pts += 3;
		}
		return pts;
			
	}


	public static int ptsRound2(String opp, String yours) {
		int pts2 = 0;
		if (opp.equals("A")) {
			if (yours.equals("X")) {
				pts2 += 3;
				pts2 += 0;
			} else if (yours.equals("Y")) {
				pts2 += 1;
				pts2 += 3;
			} else {
				pts2 += 2;
				pts2 += 6;
			}
		} else if (opp.equals("B")) {
			if (yours.equals("X")) {
				pts2 += 1;
				pts2 += 0;
			} else if (yours.equals("Y")) {
				pts2 += 2;
				pts2 += 3;
			} else {
				pts2 += 3;
				pts2 += 6;
			}
		} else {
			if (yours.equals("X")) {
				pts2 += 2;
				pts2 += 0;
			} else if (yours.equals("Y")) {
				pts2 += 3;
				pts2 += 3;
			} else {
				pts2 += 1;
				pts2 += 6;
			}
		}
		return pts2;
	}

}
