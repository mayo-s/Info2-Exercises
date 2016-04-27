import java.io.*;
import java.util.ArrayList;

public class Histogram {

	Character aChar;
	static ArrayList<Character> histogram;

	public static void main(String[] args) throws IOException {
		reader();

	}

	public Histogram() {
		histogram = new ArrayList<Character>();
	}

	public static void reader() {
		FileReader input;
		try {
			input = new FileReader(
					"C:\\Users\\mayo\\Dropbox\\Studium\\S2\\INFO2\\Exercises\\Histogram\\src\\aFile.txt");
			char nextChar;
			while ((nextChar = (char)input.read()) != -1) {
				// check if character is a letter
				if ((nextChar >= 65 && nextChar <= 90) || (nextChar >= 97 && nextChar <= 122)) {
					System.out.print((char) nextChar);
					histogram(nextChar);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void histogram(char tmpChar) {
		// int charCnt = 0;
		// int i = 0;
		// boolean counted = false;

		// check if character is already in arraylist
		for (Character someChar : histogram) {
			if (tmpChar == (someChar.getChar())) {
				int newCnt = someChar.getCnt() + 1;
				someChar.setCnt(newCnt);
			}

			// histogram.add(new Character((char) tmpChar, charCnt));

		}
	}

	public void printHistogram() {
		for (Character aChar : histogram) {
			String stars = repeat("*", aChar.getCnt());
			System.out.println(aChar.getChar() + ": " + stars);

		}
	}

	public String repeat(String sign, int i) {
		String result = "";
		for (int c = 0; c < i; c++) {
			result += sign;
		}
		return result;
	}
}
