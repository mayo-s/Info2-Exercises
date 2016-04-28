import java.io.*;
import java.util.ArrayList;

public class Histogram {

	Character aChar;
	static ArrayList<Character> histogram;

	public static void main(String[] args) throws IOException {
		reader();
		printHistogram();
		writer();
	}

	public Histogram() {
	}

	public static void reader() {
		histogram = new ArrayList<Character>();
		FileReader input;
		try {
			input = new FileReader(
					"C:\\Users\\mayo\\Dropbox\\Studium\\S2\\INFO2\\Exercises\\Histogram\\src\\aFile.txt");
			int nextChar;
			while ((nextChar = input.read()) != -1) {
				System.out.print((char) nextChar);
				// check if character is a letter
				if ((nextChar >= 65 && nextChar <= 90) || (nextChar >= 97 && nextChar <= 122)) {
					if (histogram.isEmpty()) {
						histogram.add(new Character((char) nextChar, 1));
					} else {
						histogram((char) nextChar);
					}
				}
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writer() {
		FileWriter output;
		try {
			output = new FileWriter(
					"C:\\Users\\mayo\\Dropbox\\Studium\\S2\\INFO2\\Exercises\\Histogram\\src\\anotherFile.txt");
			for (Character aChar : histogram) {
				String stars = repeat("*", aChar.getCnt());
				output.write(aChar.getChar() + ": " + aChar.getCnt() + "\r\n");
				output.flush();
				output.write(aChar.getChar() + ": " + stars + "\r\n");
				output.flush();
			}
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void histogram(char tmpChar) {

		boolean found = false;
		// check if character is already in arraylist
		for (Character someChar : histogram) {
			if (tmpChar == (someChar.getChar())) {
				int newCnt = someChar.getCnt() + 1;
				someChar.setCnt(newCnt);
				found = true;
				break;
			}
		}
		if (!found) {
			histogram.add(new Character((char) tmpChar, 1));
		}
	}

	public static void printHistogram() {
		System.out.println("\n");
		for (Character aChar : histogram) {
			String stars = repeat("*", aChar.getCnt());
			System.out.println(aChar.getChar() + ": " + stars);
		}
	}

	public static String repeat(String sign, int i) {
		String result = "";
		for (int c = 0; c < i; c++) {
			result += sign;
		}
		return result;
	}
}
