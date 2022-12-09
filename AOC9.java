import java.io.*;
import java.util.*;

public class AOC9 {
	public static void main(String[] args) throws FileNotFoundException  {
		
		System.out.println("Part 1: " + visited(new File("aoc9.txt"), 2));
		System.out.println("Part 2: " + visited(new File("aoc9.txt"), 10));

	}
	
	public static int visited(File input, int ropeSize) throws FileNotFoundException {
		
		List<List<Integer>> coordinates = parseInput(input); // x and y coordinates of head
		List<Integer> allX = coordinates.get(0);  
		List<Integer> allY = coordinates.get(1);
		
		
		Set<List<Integer>> posT = new HashSet<>(Arrays.asList()); // positions visited at least once
		
		List<List<Integer>> positions = new ArrayList<>(); // positions of each link in the rope at each step
		
		for (int i = 0; i < 10; i++) {
			positions.add(new ArrayList<Integer>(Arrays.asList(0, 0))); // initial positions
		}
		
		for (int i = 1; i < allX.size(); i++) {
			List<Integer> pos = new ArrayList<>(Arrays.asList(allX.get(i), allY.get(i))); // curr position of head
			positions.set(0, pos);
			for (int j = 1; j < ropeSize; j++) {
				pos = newTailPosition(positions.get(j-1).get(0), positions.get(j-1).get(1), // headx, heady
						  			  positions.get(j).get(0), positions.get(j).get(1));	// linkx, linky
				if (j == ropeSize-1) { // only positions of tail count
					posT.add(pos);
				}
				positions.set(j, pos); // update current position of link j
			}
		}
		return posT.size();
		
	}
	
	
	public static List<List<Integer>> parseInput(File input) throws FileNotFoundException{
		
		Scanner scan = new Scanner(input);

		int x, y;
		x = y = 0;
		List<Integer> allX = new ArrayList<>(Arrays.asList(x)); // x and y coordinates of head
		List<Integer> allY = new ArrayList<>(Arrays.asList(y));
		
		while(scan.hasNext()) {
			String inst = scan.next();
			int nMoves = scan.nextInt();
			
			switch (inst) {
			
			case "R":
				for (int i = 1; i < nMoves + 1; i++) {
					allX.add(x + i);
					allY.add(y);
				}
				x += nMoves;
				break;
			
			case "L":
				for (int i = 1; i < nMoves + 1; i++) {
					allX.add(x - i);
					allY.add(y);
				}
				x -= nMoves;
				break;
				
			case "U":
				for (int i = 1; i < nMoves + 1; i++) {
					allX.add(x);
					allY.add(y - i);
				}
				y -= nMoves;
				break;
				
			case "D":
				for (int i = 1; i < nMoves + 1; i++) {
					allX.add(x);
					allY.add(y + i);
				}
				y += nMoves;
				break;
			}
		}
		
		scan.close();
		
		List<List<Integer>> coords = new ArrayList<>();
		coords.add(allX);
		coords.add(allY);
		
		return coords;
	}
	
	
	public static List<Integer> newTailPosition(int hx, int hy, int tx, int ty) {
	
			if (hx - tx == 2 && hy == ty) {
				tx++;
			}
			if (hx - tx == -2 && hy == ty) {
				tx--;
			} 
			if (hy - ty == 2 && hx == tx) {
				ty++;
			}
			if (hy - ty == -2 && hx == tx) {
				ty--;
			}
			
			if (hy - ty == -2 && hx - tx == 1) { // up right
				tx++;
				ty--;
			}
			if (hy - ty == -2 && hx - tx == -1) { // up left
				tx--;
				ty--;
			}
			
			if (hy - ty == 2 && hx - tx == 1) { // down right
				tx++;
				ty++;
			}
			
			if (hy - ty == 2 && hx - tx == -1) { // down left
				tx--;
				ty++;
			}
			
			if (hx - tx == 2 && hy - ty == -1) {
				tx++;
				ty--;
			}
			if (hx - tx == -2 && hy - ty == -1) {
				tx--;
				ty--;
			}
			
			if (hx - tx == 2 && hy - ty == 1) {
				tx++;
				ty++;
			}
			
			if (hx - tx == -2 && hy - ty == 1) {
				tx--;
				ty++;
			}

			// PART II tests: tails can move diagonally - these tests never pass in part I
			if (hx - tx == 2 && hy - ty == -2) {
				tx++;
				ty--;
			}
			
			if (hx - tx == -2 && hy - ty == -2) {
				tx--;
				ty--;
			}
			
			if (hx - tx == 2 && hy - ty == 2) {
				tx++;
				ty++;
			}
			
			if (hx - tx == -2 && hy - ty == 2) {
				tx--;
				ty++;
			}
			
			List<Integer> pos = new ArrayList<>();
			pos.add(tx);
			pos.add(ty);
		

		return pos;
	}

}
