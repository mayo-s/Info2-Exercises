import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HistogramByRich {
	
	private int [] letterCount = new int [26];
	
	private FileReader inputStream = null;
	private FileWriter outputStream = null;
	
	public static void main(String[] args) throws IOException {
		HistogramByRich histogram = new HistogramByRich();
		histogram.readAndReturn();
	}
	
	public int[] readAndReturn() throws IOException {
		
		// Reading starts here
		try {
			inputStream = new FileReader("C:\\Users\\mayo\\Dropbox\\Studium\\S2\\INFO2\\Exercises\\Histogram\\src\\anotherFile.txt");
			int c; 

			// Conditions for lower case and upper case letters
			//@else ignore other symbols
			while((c = inputStream.read()) != -1) {
				if(c >= 65 && c <= 90) {
					c -= 65;
					letterCount[c]++;
				}
				else if (c >= 97 && c <= 122) {
					c -= 97;
					letterCount[c]++;
				}
				else {
					System.out.println("not a letter");
				}
			}
			
			/*
			 * Now the writing
			 */
			
			//create new file
			outputStream = new FileWriter("C:\\Users\\mayo\\Dropbox\\Studium\\S2\\INFO2\\Exercises\\Histogram\\src\\anotherFile2.txt");
			
			/*
			 * The algorithm for the loop
			 */
			
			//for every letter ...
			for(int numberOfLetter  = 0; numberOfLetter < letterCount.length; numberOfLetter++) {
				
				//... check if at least one was read by the reader ...
				if(letterCount[numberOfLetter] != 0) {
					
					String stringOfStars = ""; // *stars* needed to extend the histogram
					
					// ... if yes write first the letter to the file ...
					outputStream.write(numberOfLetter + 65);
					
					// ... and then add as much stars to the histogram as the number of times they were read.
					for(int numberOfStars = 0; numberOfStars < letterCount[numberOfLetter]; numberOfStars++) {
						
						stringOfStars += "*";
						
						// add a space every five stars for better clarity
						if(stringOfStars.length() == 5) {
							stringOfStars += " "; 
						}
						
					}
					
					outputStream.write(" : " + stringOfStars + "\n");
				}
				else {
					System.out.println("No letters counted for this number of letter: " + (char)(numberOfLetter + 65));
				}
			}
			
			
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
		
		return letterCount;
		
	}
}