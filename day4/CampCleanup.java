package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CampCleanup {
	
	public static void main(String args[]) throws FileNotFoundException {
		
		File in = new File("day4/input.txt");
		
		System.out.println("Part 1: " + overlap(in, false));
		System.out.println("Part 2: " + overlap(in, true));
		
	}
	
	static int overlap(File input, boolean part2) throws FileNotFoundException {
		
		Scanner scan = new Scanner(input);
		int count = 0; int count2 = 0;
		while (scan.hasNext()) {
			String a = scan.nextLine();
			
			int l = 0;
			String s1 = parse(a, '-', 0);
			l += s1.length() + 1;			// +1 to skip "-"
			
			String e1 = parse(a, ',', l);
			l += e1.length() + 1;
			
			String s2 = parse(a, '-', l);
			l += s2.length() + 1;
			
			String e2 = a.substring(l);
			
			int start1 = Integer.parseInt(s1);
			int end1 = Integer.parseInt(e1);
			int start2 = Integer.parseInt(s2);
			int end2 = Integer.parseInt(e2); // end parsing
			
			if (start1 <= start2 && end1 >= end2) { // Part I
				count++;
			} else if (start2 <= start1 && end2 >= end1) {
				count++;
			}
			
			
			if (start1 <= end2 && start2 <= end1) { // Part II
				count2++;
			}
		}
		
		scan.close();
		
		
		if (part2) {
			return count2;
		}
		
		return count;
	}
	
	public static String parse(String line, char stop, int i) {
		String s1 = "";
		while (line.charAt(i) != stop) {
			s1 += line.charAt(i);
			i++;
		}
		return s1;
	}

}
