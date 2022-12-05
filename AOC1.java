package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AOC1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	System.out.println(count(new File("aoc1.txt")));

	}

	static int count(File input) throws FileNotFoundException{
		Scanner scan = new Scanner(input);
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		int c = 0;
		while(scan.hasNextLine()) {
			String a = scan.nextLine();
			Scanner lineScan = new Scanner(a);
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
	return max1 + max2 + max3;
		
	}

}
