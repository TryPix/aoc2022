package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class AOC5 {

	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		
		System.out.println(stacking(new File("aoc5.txt")));

	}
	
	public static String stacking(File input) throws FileNotFoundException {
		
		List<Stack<String>> stacks = new ArrayList<Stack<String>>();
		for (int i = 0; i < 10; i++) {
			stacks.add(new Stack<String>());
		}
		
		String[] s1 = new String[] {"C", "Z", "N", "B", "M", "W", "Q", "V"};
		String[] s2 = new String[] {"H", "Z", "R", "W", "C", "B"};
		String[] s3 = new String[] {"F", "Q", "R", "J"};
		String[] s4 = new String[] {"Z", "S", "W", "H", "F", "N", "M", "T"};
		String[] s5 = new String[] {"G", "F", "W", "L", "N", "Q", "P"};
		String[] s6 = new String[] {"L", "P", "W"};
		String[] s7 = new String[] {"V", "B", "D", "R", "G", "C", "Q", "J"};
		String[] s8 = new String[] {"Z", "Q", "N", "B", "W"};
		String[] s9 = new String[] {"H", "L", "F", "C", "G", "T", "J"};
		
		String[][] s = new String[][] {null, s1, s2, s3, s4, s5, s6, s7, s8, s9};
		
		for (int i = 1; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				stacks.get(i).add(s[i][j]);
			}
		}
		
		
		Scanner scan = new Scanner(input);
		while (!scan.nextLine().equals("")) {
		}
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			Scanner lineScan = new Scanner(line);
			lineScan.next();
			int num = lineScan.nextInt();
			lineScan.next();
			int from = lineScan.nextInt();
			lineScan.next();
			int to = lineScan.nextInt();
			
			String[] arr = new String[num];
			for (int i = 0; i < num; i++) {
				String popped = stacks.get(from).pop();
				arr[i] = popped;
				//Part I
				//stacks.get(to).push(popped);
			}
			
			for (int i = num-1; i >= 0; i--) {
				stacks.get(to).push(arr[i]);
			}

			lineScan.close();
		}
		
		scan.close();
		
		
		String fin = "";
		
		
		for (int i = 1; i < s.length; i++) {
			fin += stacks.get(i).pop();
		}
		
		return  fin;
		
	}

}
