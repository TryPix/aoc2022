
import java.io.*;
import java.util.*;

public class AOC10 {
	public static void main(String[] args) throws FileNotFoundException  {
		
		File in = new File("day/input.txt");
		
		System.out.println(foo(in, false));
		System.out.println(foo(in, true));

	}
	
	public static int foo(File input, boolean part2) throws FileNotFoundException {
		
		
		Scanner scan = new Scanner(input);
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			Scanner lineScan = new Scanner(line);
			

			lineScan.close();
		}
		
		scan.close();
		
		if (part2) {
			return -1;
		}
		
		return -1;
		
	}

}
