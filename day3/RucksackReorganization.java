package day3;


import java.util.*;
import java.io.*;

public class RucksackReorganization {

	public static void main(String[] args) throws FileNotFoundException {
		
		File in = new File("day3/input.txt");
		
		System.out.println("Part 1: " + prioritySum(in, false));
		System.out.println("Part 2: " + prioritySum(in, true));

	}
	
	
	static int prioritySum(File input, boolean part2) throws FileNotFoundException{
		
		String[] letters = new String[] {"a", "b", "c", "d", "e",
										 "f", "g", "h", "i", "j",
										 "k", "l", "m", "n", "o",
										 "p", "q", "r", "s", "t",
										 "u", "v", "w", "x", "y",
										 "z"};
		
		HashMap<String, Integer> values = new HashMap<String, Integer>();
		for (int i = 0; i < 26; i++) {
			values.put(letters[i], i+1);
		}
		
		int count = 0; int count2 = 0;
		
		Scanner scan = new Scanner(input);
		
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			count += rep1(line, letters, values);
		}
		
		scan.close();
		scan = new Scanner(input);
		
		while(scan.hasNextLine()) {
			String first = scan.nextLine();
			String second = scan.nextLine();
			String third = scan.nextLine();
			count2 += rep2(first, second, third, letters, values);
		}
		scan.close();
		
		if (part2) {
			return count2;
		}
		
		return count;
	}

	
	public static int rep1(String a, String[] letters, Map<String, Integer> values) {
		int count = 0;
		String first = a.substring(0, a.length()/2);
		String last = a.substring(a.length()/2, a.length());
		for (int i = 0; i < letters.length; i++) {
			if (first.contains(letters[i]) && last.contains(letters[i])) {
				count += values.get(letters[i]);
				break;
			}
			
			if (first.contains(letters[i].toUpperCase()) && last.contains(letters[i].toUpperCase())) {
				count += values.get(letters[i]) + 26;
				break;
			}
		}
		return count;
	}
	
	
	public static int rep2(String first, String second, String third, String[]letters, Map<String, Integer> values) {
		int count2 = 0;
		for (int i = 0; i < letters.length; i++) {
			if (first.contains(letters[i]) && second.contains(letters[i]) && third.contains(letters[i])) {
				count2 += values.get(letters[i]);
				break;
			}
			if (first.contains(letters[i].toUpperCase()) && second.contains(letters[i].toUpperCase()) && third.contains(letters[i].toUpperCase())) {
				count2 += values.get(letters[i]) + 26;
				break;
			}
		}
		return count2;
	}

}








