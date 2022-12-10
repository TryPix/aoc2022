package day10;

import java.io.*;
import java.util.*;

public class CathodeRayTube {
	
	public static void main(String[] args) throws FileNotFoundException  {
		
		File in = new File("day10/input.txt");
		
		System.out.println("Part 1: " +  cycleSum(in));
		System.out.println("Part 2: ");
		crt(parse(in));
		
	}
	
	
	public static Integer cycleSum(File input) throws FileNotFoundException {
		
		Map<Integer, Integer> registerX = parse(input);
		int sum = 0;
		for (int i = 20; i < 221; i+= 40) {
			sum += registerX.get(i) * i;
		}
		return sum;
	}
	
	
	public static void crt(Map<Integer, Integer> registerX) {
		int mod = 1;
		String curr;
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 40; j++) {
				if (j < 40 && j > 0 && (j == registerX.get(j + mod) ||j == registerX.get(j + mod) + 1 || j == registerX.get(j + mod)-1)) {
					curr = "█";
				} else if (j == 0 && (j == registerX.get(j + mod) ||j == registerX.get(j + mod) + 1)){
					curr = "█";	
				} else if (j == 39 && (j == registerX.get(j + mod) ||j == registerX.get(j + mod) - 1)) {
					curr = "█";	
				}
				else {
					curr = " ";
				}
				System.out.print(curr);
			}
			System.out.println();
			mod += 40;
		}
		
	}
	
	
	public static Map<Integer, Integer> parse(File input) throws FileNotFoundException{
		Scanner scan = new Scanner(input);
		int cycles = 1;
		int x = 1;
		Map<Integer, Integer> registerX = new HashMap<>();
		while(scan.hasNext()) {
			String inst  = scan.next();
	
			switch (inst) {
			case "noop":
				registerX.put(cycles, x);
				cycles++;
				registerX.put(cycles, x);

				break;
			case "addx":
				int n = scan.nextInt();
				registerX.put(cycles, x);
				cycles++;
				registerX.put(cycles, x);
				cycles++;
				x += n;
				registerX.put(cycles, x);
			}
		}
		scan.close();
		
		registerX.put(0, 1);
		return registerX;
	}

}
