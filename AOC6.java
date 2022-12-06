

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;

public class AOC6 {
	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		
		System.out.println(marker(new File("aoc6.txt")));

	}
	
	public static int marker(File input) throws FileNotFoundException {
		
		
		Scanner scan = new Scanner(input);

		String text = scan.next();
		int count = 0;
		
		HashSet<Character> set = new HashSet<Character>();
	
		
		while (count + 14 < text.length()) {
			String mark = text.substring(count, count+14);
			for (int i = 0; i < 14; i++) {
				set.add(mark.charAt(i));
			}
			if (set.size() == 14) {
				break;
			}
			set.clear();
			count++;
			

		}
		
// PART I
//		while (count + 4 < text.length()+1) {
//			String mark = text.substring(count, count+4);
//			if (mark.charAt(0) != mark.charAt(1) && mark.charAt(0) != mark.charAt(2) && mark.charAt(0) != mark.charAt(3)) {
//				if (mark.charAt(1) != mark.charAt(2) && mark.charAt(1) != mark.charAt(3)) {
//					if (mark.charAt(2) != mark.charAt(3)) {
//						break;
//					}
//				}
//			}
//			count += 1;
//		}
		scan.close();
		return count +14;
		//return count+4;
		
	}

}
