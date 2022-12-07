

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AOC7 {
	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		
		
		System.out.println(sumDirectories(new File("aoc7.txt")));

	}

		
	
	public static int sumDirectories(File input) throws FileNotFoundException {
		
		
		Scanner scan = new Scanner(input);
		
		
		List<String> directories = new ArrayList<String>();
		Map<String, Integer> sums = new LinkedHashMap<String, Integer>();
		sums.put("/", 0);
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			Scanner lineScan = new Scanner(line);
			String first = lineScan.next();
			
			
			if (first.equals("$")) {
				String scnd = lineScan.next();
				if (scnd.equals("cd")) {
					String third = lineScan.next();
					if (third.equals("..")) {
						String d = directories.get(directories.size()-1);
						directories.remove(d);
					}
					else {
						String direc = "";
						for (int i = 0; i < directories.size(); i++) {
							direc += directories.get(i);
						}
						direc += third;
						
						directories.add(direc);
					}
				}
			} else if (first.equals("dir")) {
				String d = lineScan.next();
				String direc = "";
				for (int i = 0; i < directories.size(); i++) {
					direc += directories.get(i);
				}
				direc += d;
				
				if (!sums.containsKey(direc)) {
					sums.put(direc, 0);
				} 
			
					
			} else {
				int size = Integer.parseInt(first);
				for (int i = 0; i < directories.size(); i++) {
					String a = directories.get(i);
					sums.put(a, sums.get(a) + size);
				}
			}
			
			lineScan.close();
		}
		scan.close();
		
		
		Collection<Integer> a = sums.values();
		Integer[] b = a.toArray(new Integer[a.size()]);
	
		
		int sum = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] <= 100000) {
				sum += b[i];
			}
		}
		
		
		// PART II
		List<Integer> bb = new ArrayList<>(a);

		int tot = bb.get(0);
		Collections.sort(bb);
		for (int i = 0; i < bb.size(); i++) {
			if (tot - bb.get(i) <= 40000000) {
				return bb.get(i);
				
			}
		}
		
		// PART I
		return sum;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
