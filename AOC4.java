package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AOC4 {
	
	public static void main(String args[]) throws FileNotFoundException {
		
		System.out.println(overlap(new File("aoc4.txt")));
		
	}
	
	static int overlap(File input) throws FileNotFoundException {
		
		Scanner scan = new Scanner(input);
		int count = 0;
		while (scan.hasNext()) {
			String a = scan.nextLine();
			String s1 = "";
			int i = 0;
			while (a.charAt(i) != '-') {
				s1 += a.charAt(i);
				i++;
			}
			i++;
			String e1 = "";
			while (a.charAt(i) != ',') {
				e1 += a.charAt(i);
				i++;
			}
			i++;
			
			String s2 = "";
			while (a.charAt(i) != '-') {
				s2 += a.charAt(i);
				i++;
			}
			i++;
			
			String e2 = a.substring(i);
			
			int start1 = Integer.parseInt(s1);
			int end1 = Integer.parseInt(e1);
			int start2 = Integer.parseInt(s2);
			int end2 = Integer.parseInt(e2);
			
			
			if (start1 <= end2 && start2 <= end1) {
				count++;
			}
			
// PART I
//			if (start1 <= start2 && end1 >= end2) {
//				count++;
//			} else if (start2 <= start1 && end2 >= end1) {
//				count++;
//			}
			
		}
		
		scan.close();
		
		
		
		
		return count;
	}

}
