package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalorieCounting {

	public static void main(String[] args) throws FileNotFoundException {
	
	File in = new File("day1/input.txt");
	System.out.println("Part 1: " + count(in, false));
	System.out.println("Part 2: " + count(in, true));
	}

	static int count(File input, boolean part2) throws FileNotFoundException{
		Scanner scan = new Scanner(input);
		int max1, max2, max3;
		max1 = max2 = max3 = Integer.MIN_VALUE;
		int c = 0;
		String line;
		
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			Scanner lineScan = new Scanner(line);
			if (lineScan.hasNextInt()) {
				c += lineScan.nextInt();
			} else {
				if (c > max1) {
					max3 = max2;
					max2 = max1;
					max1 = c;
				} else if (c > max2) {
					max3 = max2;
					max2 = c;
				} else if (c > max3) {
					max3 = c;
				}
				c = 0;
			}
			lineScan.close();
		}
	scan.close();
	if (part2) {
		return max1 + max2 + max3;
	}
	
	return max1;

	}

}
