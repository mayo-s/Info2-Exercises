package imi.calculator;

import java.util.ArrayList;

public class Set {

	static ArrayList<Integer> theSet;
	private static Set set;

	public Set() {
	}

	public static void main(String[] args) {

		// testcases
/*		set = new Set();
		theSet = new ArrayList<Integer>();
		set.clear();
		System.out.println("Set should be empty. Size = " + set.size());
		System.out.println("isEmpty() returns " + set.isEmpty() + "\n");
		System.out.println("Adding 14, 42, 1337, 4711, 666");
		set.add(14);
		set.add(42);
		set.add(1337);
		set.add(4711);
		set.add(666);
		System.out.println("Set contains: " + set.size() + " elements.");
		System.out.println(set.output());
		System.out.println("isEmpty() returns " + set.isEmpty() + "\n");
		System.out.println("add 42 again.");
		set.add(42);
		System.out.println("Set-Size should be unchanged. Set-Size = " + set.size());
		System.out.println(set.output());
		System.out.println("isEmpty() returns " + set.isEmpty() + "\n");
		System.out.println("checking if Set contains 4711: " + set.contains(4711));
		System.out.println("remove 4711. Set size should be 1 less.");
		set.remove(4711);
		System.out.println("Set contains: " + set.size() + " elements.");
		System.out.println(set.output());
		System.out.println("isEmpty() returns " + set.isEmpty() + "\n");
		System.out.println("Dumping the set.");
		set.clear();
		System.out.println("Set should be empty again. Size = " + set.size());
		System.out.println("isEmpty() returns " + set.isEmpty() + "\n");*/
	}

	public int size() {
		int i = 0;
		for (@SuppressWarnings("unused")int something : theSet) {
			i++;
		}
		return i;
	}

	public void clear() {
		theSet.clear();
	}

	public boolean isEmpty() {
		if (set.size() < 1) {
			return true;
		}

		return false;
	}

	public boolean contains(int input) {
		for (int something : theSet) {
			if (something == input) {
				return true;
			}
		}
		return false;
	}

	public void add(int input) {
		if (!contains(input)) {
			theSet.add(input);
		}
	}

	public void remove(int input) {
		if (set.contains(input)) {
			theSet.remove(Integer.valueOf(input));
		}
	}

	public String output() {

		String output = "{ ";
		int i = 0;
		for (int something : theSet) {
			output += something;
			if (i != set.size() - 1) {
				output += ", ";
				i++;
			} else {
				output += " }";
			}
		}
		return output;
	}
}
