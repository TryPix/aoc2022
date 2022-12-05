

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AOC2 {

	public static void main(String[] args)throws FileNotFoundException  {
		// TODO Auto-generated method stub
		
		System.out.println(points(new File("aoc2.txt")));

	}
	
	static int points(File input) throws FileNotFoundException {
		Scanner scan = new Scanner(input);
		int pts = 0;
		while (scan.hasNextLine()) {
			String a = scan.nextLine();
			Scanner lineScan = new Scanner(a);
			String opp = lineScan.next();
			String yours = lineScan.next();
		
		if (opp.equals("A")) {
			if (yours.equals("X")) {
				pts += 3; 
				pts += 0;
			} else if (yours.equals("Y")) {
				pts += 1;
				pts += 3;
			} else {
				pts += 2;
				pts += 6;
			}
		} else if (opp.equals("B")) {
			if (yours.equals("X")) {
				pts += 1; 
				pts += 0;
			} else if (yours.equals("Y")) {
				pts += 2;
				pts += 3;
			} else {
				pts += 3;
				pts += 6;
			}
		} else {
			if (yours.equals("X")) {
				pts += 2; 
				pts += 0;
			} else if (yours.equals("Y")) {
				pts += 3;
				pts += 3;
			} else {
				pts += 1;
				pts += 6;
			}
		}
			
			
// PART I
//			if (yours.equals("X")) {
//				pts += 1;
//				if (opp.equals("A")) {
//					pts += 3;
//				} else if (opp.equals("B")) {
//					pts += 0;
//				} else {
//					pts += 6;
//				}
//			} else if (yours.equals("Y")) {
//				pts += 2;
//				if (opp.equals("B")) {
//					pts += 3;
//				} else if (opp.equals("C")) {
//					pts += 0;
//				} else {
//					pts += 6;
//				}
//			} else {
//				pts += 3;
//				if (opp.equals("C")) {
//					pts += 3;
//				} else if (opp.equals("A")) {
//					pts += 0;
//				} else {
//					pts += 6;
//				}
//			}
		
		lineScan.close();
		}
		
		scan.close();

		return pts;
	}

}
