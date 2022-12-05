

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AOC6 {
	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		
		System.out.println(foo(new File("aoc6.txt")));

	}
	
	public static int foo(File input) throws FileNotFoundException {
		
		
		Scanner scan = new Scanner(input);
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			Scanner lineScan = new Scanner(line);
			

			lineScan.close();
		}
		
		scan.close();
		
		return -1;
		
	}

}
