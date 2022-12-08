

import java.io.*;
import java.util.*;

public class AOC8 {
	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		
		System.out.println(foo(new File("aoc8.txt")));

	}
	
	public static int foo(File input) throws FileNotFoundException {
		
		
		Scanner scan = new Scanner(input);
		String a = scan.nextLine();
		int[][] map = new int[a.length()][a.length()];
		for (int i = 0; i < map[0].length; i++) {
			map[0][i] = Integer.parseInt(String.valueOf(a.charAt(i)));
		}
		int j = 1;
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			for (int i = 0; i < map[0].length; i++) {
				map[j][i] = Integer.parseInt(String.valueOf(line.charAt(i)));
			}
			j++;
		}
		
		
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int k = 0; k < map.length; k++) {
				if (i == 0 || i == map.length-1 || k == 0 || k == map.length-1) {
					count++;
					continue;
				}
				
				boolean b = false;
				for (int t = 0; t < k; t++) {
					
					if (map[i][t] < map[i][k]) {
						b = true;
					} else {
						b = false;
						break;
					}
				}
				boolean b1 = false;
				for (int t = k+1; t < map.length; t++) {
					if (b) {
						break;
					}
					if (map[i][t] < map[i][k]) {
						b1 = true;
					} else {
						b1 = false;
						break;
					}
				}
				
				boolean b2 = false;
				for (int t = 0; t < i; t++) {
					if (b || b1) {
						break;
					}
					if (map[t][k] < map[i][k]) {
						b2 = true;
					} else {
						b2 = false;
						break;
					}
				}
				boolean b3 = false;
				for (int t = i+1; t < map.length; t++) {
					if (b || b1 || b2) {
						break;
					}
					if (map[t][k] < map[i][k]) {
						b3 = true;
					} else {
						b3 = false;
						break;
					}
				}
				
				
				if (b || b1 || b2 || b3) {
					count++;
				}
			}
		}

// PART II
		int dist = 0;
		for (int i = 0; i < map.length; i++) {
			for (int k = 0; k < map.length; k++) {
				int dl = 0;
				int dr = 0;
				int du = 0;
				int dd = 0;
				for (int t = k-1; t >= 0; t--) {
					if (map[i][t] < map[i][k]) {
						dl++;
					} else {
						dl++;
						break;
					}
				}
				
				for (int t = k+1; t < map.length; t++) {
					if (map[i][t] < map[i][k]) {
						dr++;
					} else {
						dr++;
						break;
					}
				}
				for (int t = i-1; t >= 0; t--) {
					if (map[t][k] < map[i][k]) {
						du++;
					} else {
						du++;
						break;
					}
				}
				
				for (int t = i+1; t < map.length; t++) {
					if (map[t][k] < map[i][k]) {
						dd++;
					} else {
						dd++;
						break;
					}
				}
				
				dist = Math.max(dist, dr * dl * du * dd);
			}
		}
		
		scan.close();
		
		return dist; // count for PART I;
		
	}

}
