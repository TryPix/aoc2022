

import java.io.*;
import java.util.*;

public class AocTemplate {
	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		
		System.out.println(foo(new File("aoc.txt")));

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
