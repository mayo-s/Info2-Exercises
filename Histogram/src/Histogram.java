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
		FileWriter output;
		try {
			input = new FileReader(
					"C:\\Users\\mayo\\Dropbox\\Studium\\S2\\INFO2\\Exercises\\Histogram\\src\\aFile.txt");
			int nextChar;
			while ((nextChar = input.read()) != -1) {
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

	public static void histogram(int tmpChar) {
		int charCnt = 0;
		int i = 0;
		boolean counted = false;

		// check if character is already in arraylist
		for(Character aChar : histogram){
				if (tmpChar == histogram.get(i).getChar()) {
					int newCnt = histogram.get(i).getCnt() + 1;
					histogram.get(i).setCnt(newCnt);
				}
			
				histogram.add(new Character((char) tmpChar, charCnt));
			
		}
	}

	public void printHistogram() {
		for (Character aChar : histogram) {
			System.out.println(aChar + ": ");
		}
	}
}
