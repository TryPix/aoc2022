package day11;

import java.io.*;
import java.util.*;

public class MonkeyInTheMiddle {
	
	public static void main(String[] args) throws FileNotFoundException  {
		
		File in = new File("day11/input.txt");
		
		System.out.println("Part 1: " + runRounds(in, false, parse(in), 20));
		System.out.println("Part 2: " + runRounds(in, true,  parse(in), 10000));
	}
	
	public static ArrayList<Monkey> parse(File input) throws FileNotFoundException {
		
		ArrayList<Monkey> monkeys = new ArrayList<>();
		Scanner scan = new Scanner(input);

		while(scan.hasNext()) {
			skipTokens(scan, 4); // ignore text
			
			LinkedList<Long> it = new LinkedList<>(); // starting items
			Scanner lineScan = new Scanner(scan.nextLine());
			
			while (lineScan.hasNext()) {
				it.add(Long.parseLong(lineScan.next()));
				if (lineScan.hasNext()) {
					lineScan.next(); // skip ','
				} else {
					break;
				}
			}
			lineScan.close();
			
			skipTokens(scan, 4);
			boolean add = false;
			long n = 0;
			if (scan.next().contains("+")) { // add operation
				add = true;
			} else { // multiply operation
				n = 1;
			}
			
			boolean old = false;
			String txt = scan.next();
			try {
				n = Long.parseLong(txt);
			} catch(NumberFormatException e) {
				old = true; // old * old
			}
			scan.nextLine();
			
			
			skipTokens(scan, 3);
			Long testn = scan.nextLong(); 
			scan.nextLine();
			
			
			skipTokens(scan, 5);
			int o1 = scan.nextInt(); // throw to monkey[o1] if test() == true
			scan.nextLine();
			
			
			skipTokens(scan, 5);
			int o2 = scan.nextInt(); // else
			
			if (old) {
				monkeys.add(new Monkey(it, testn, o1, o2, add, old));
			} else {
				monkeys.add(new Monkey(it, testn, o1, o2, add, n));
			}
		}
		scan.close();
		return monkeys;
	}

	
	public static long runRounds(File input, boolean part2, ArrayList<Monkey> monkeys, int rounds) {
		

		int mod = 1; // needed for part 2, can be used in part 1 as well
		
		for (int i = 0; i < monkeys.size(); i++) {
			mod *= monkeys.get(i).testn;
		}
		
		Monkey.mod = mod; 
		
		
		for (int i = 0; i < rounds; i++) {
			for (int j = 0; j < monkeys.size(); j++) {
				Monkey monk = monkeys.get(j);
				while (!monk.items.isEmpty()) {
					if (monk.old) {
						monk.operation(monk.items.get(0));
						monk.inspected++;
					} else {
						monk.operation(monk.n);
						monk.inspected++;
					}
					
					if (!part2) {
						monk.items.set(0, monk.items.get(0)/3); // dvide by 3 in part 1
					}
					monk.throwsTo(monkeys);
				}
			}
		}
		
		long[] lst = new long[monkeys.size()];
		for (int i = 0; i < monkeys.size(); i++) {
			lst[i] = monkeys.get(i).inspected;
		}
		
		Arrays.sort(lst);
	
		return lst[monkeys.size()-1] * lst[monkeys.size()-2];
	}
	
	
	public static void skipTokens(Scanner scan, int l) {
		for (int i = 0; i < l; i++) {
			scan.next();
		}
	}
}


class Monkey{
	LinkedList<Long> items;
	public static long mod;
	long testn;
	int other1;
	int other2;
	boolean add;
	boolean old;
	long n;
	int inspected;
	
	Monkey(LinkedList<Long> items, long testn, int other1, int other2, boolean add, boolean old){
		this.items = items;
		this.testn = testn;
		this.other1 = other1;
		this.other2 = other2;
		this.add = add;
		this.old = old;
	}
	
	Monkey(LinkedList<Long> items, long testn, int other1, int other2, boolean add, long n){
		this.items = items;
		this.testn = testn;
		this.other1 = other1;
		this.other2 = other2;
		this.add = add;
		this.n = n;
	}
	
	void operation(long n) {
		
		items.set(0, items.get(0) % mod);
		
		if (add) {
			items.set(0, items.get(0) + n);
		} else {
			items.set(0, items.get(0) * n);
		}
	}
	
	boolean test() {
		return items.get(0) % testn == 0;
	}
	
	void throwsTo(ArrayList<Monkey> monks) {
		Long i = items.get(0);
		if (test()) {
			items.remove(0);
			monks.get(other1).items.add(i);
		} else {
			items.remove(0);
			monks.get(other2).items.add(i);
		}
	}
	
}
