package day12;

import java.io.*;
import java.util.*;

public class HillClimbing {
	public static void main(String[] args) throws FileNotFoundException  {
		
		File in = new File("day12/input.txt");
		
		System.out.println("Part 1: " + shortestPath(in, false));
		System.out.println("Part 2: " + shortestPath(in, true));

	}
	
	public static int shortestPath(File input, boolean part2) throws FileNotFoundException {
		
		Scanner scan = new Scanner(input);
		
		int endx = 0; int endy = 0;
		int startx = 0; int starty = 0;
		
		int row = 0;
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			int sx = line.indexOf('S');
			int ex = line.indexOf('E');
			if (sx != -1) {
				startx = sx;
				starty = row;
			} 
			if (ex != -1) {
				endx = ex;
				endy = row;
			}
			row++;
		}
		scan.close();
		
		
		int[][] map = buildMap(input);
		
		int nRows = map.length;
		int nCols = map[0].length;
	
		
		Vertex[][] vgrid = detEdges(map);
		
		Set<Vertex> V = new HashSet<>();
		
		for (int i = 0; i < nRows;i++) {
			for (int j = 0; j < nCols; j++) {
				V.add(vgrid[i][j]);	
			}
		}
		
		Vertex v = new Vertex(); // a vertex that has an edge to all starting points
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (map[i][j] == 'a') {
					v.adj.add(vgrid[i][j]);
				}
			}
		}
		
		Queue<Vertex> q = new LinkedList<>(); // start of BFS
		
		Vertex v0 = new Vertex();
		if (part2) {
			v0 = v;
		} else {
			v0.adj.add(vgrid[starty][startx]);
		}

		v0.d = -1; // 'dummy' node, starting point
		v0.visited = true;
		q.add(v0);
		while (!q.isEmpty()) {
			Vertex curr = q.remove();
			for (int i = 0; i< curr.adj.size(); i++) {
				Vertex neigh = curr.adj.get(i);
				if (!neigh.visited) {
					neigh.visited = true;
					q.add(neigh);
					neigh.d = curr.d + 1;
					neigh.prev = curr;
				}
			}
		}		
		
		return vgrid[endy][endx].d;
		
	}
	
	public static int[][] buildMap(File input) throws FileNotFoundException{
		Scanner scan = new Scanner(input);
		int nRows = 0;
		int nCols = 0;
		while (scan.hasNext()) {
			nRows++;
			nCols = scan.nextLine().length();
		}
		scan.close();
		
		int[][] map = new int[nRows][nCols];
		
		scan = new Scanner(input);
		
		int i = 0;
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			Scanner lineScan = new Scanner(line);
			for (int j = 0; j < nCols; j++) {
				char c = line.charAt(j);
				if (c == 'S') {
					map[i][j] = 'a';
					continue;
				} else if (c == 'E') {
					map[i][j] = 'z';
					continue;
				}
				map[i][j] = c;
			}
			i++;
			lineScan.close();
		}
		scan.close();
		
		return map;
	}
	
	
	public static int[] findChar(int[][] map, char c) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == c) {
					return new int[] {i, j};
				}
			}
		}
		return null;
	}
	
	
	public static Vertex[][] detEdges(int[][] map){
		
		int nRows = map.length;
		int nCols = map[0].length;
		
		Vertex[][] vgrid = new Vertex[nRows][nCols];
		for (int i = 0; i < nRows;i++) {
			for (int j = 0; j < nCols; j++) {
				vgrid[i][j] = new Vertex();	
			}
		}
		
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				try {
					if (map[i][j+1] - map[i][j] <= 1) {
						
						vgrid[i][j].adj.add(vgrid[i][j+1]);
					}
				} catch (ArrayIndexOutOfBoundsException e) {}
				
				try {
					if (map[i][j-1] - map[i][j] <= 1) {
						vgrid[i][j].adj.add(vgrid[i][j-1]);
					}
				} catch (ArrayIndexOutOfBoundsException e) {}
				try {
					if (map[i+1][j] - map[i][j] <= 1) {
						vgrid[i][j].adj.add(vgrid[i+1][j]);
					}
				} catch (ArrayIndexOutOfBoundsException e) {}
				try {
					
					if (map[i-1][j] - map[i][j] <= 1) {
						vgrid[i][j].adj.add(vgrid[i-1][j]);
					}
				} catch (ArrayIndexOutOfBoundsException e) {}
			}
		}
		
		return vgrid;
		
	}

}



class Vertex{
	ArrayList<Vertex> adj = new ArrayList<Vertex>();
	boolean visited;
	int prevd;
	int d;
	Vertex prev;
}
	

