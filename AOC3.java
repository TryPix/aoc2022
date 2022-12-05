package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class AOC3 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println(prioritySum(new File("aoc3.txt")));

	}
	
	static int prioritySum(File input) throws FileNotFoundException{
		
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

		Scanner scan = new Scanner(input);
		
		int count = 0;
		
		while(scan.hasNextLine()) {
			String first = scan.nextLine();
			String second = scan.nextLine();
			String third = scan.nextLine();
			for (int i = 0; i < letters.length; i++) {
				if (first.contains(letters[i]) && second.contains(letters[i]) && third.contains(letters[i])) {
					count += values.get(letters[i]);
					break;
				}
				if (first.contains(letters[i].toUpperCase()) && second.contains(letters[i].toUpperCase()) && third.contains(letters[i].toUpperCase())) {
					count += values.get(letters[i]) + 26;
					break;
				}
			}
			
			
		}
		
		
// PART I
		
//		while (scan.hasNextLine()) {
//			String a = scan.nextLine();
//			String first = a.substring(0, a.length()/2);
//			String last = a.substring(a.length()/2, a.length());
//			for (int i = 0; i < letters.length; i++) {
//				if (first.contains(letters[i]) && last.contains(letters[i])) {
//					count += values.get(letters[i]);
//					break;
//				}
//				
//				if (first.contains(letters[i].toUpperCase()) && last.contains(letters[i].toUpperCase())) {
//					count += values.get(letters[i]) + 26;
//					break;
//				}
//			}
//			
//			
//			//System.out.println(count);
//		}
		
		scan.close();
		
		
		
		return count;
	}

}








