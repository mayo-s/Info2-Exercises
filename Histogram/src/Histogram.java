import java.io.*;

public class Histogram {

	
	public static void main(String[] args) throws IOException{
		
			reader();
	}
	
	public static void reader(){
				
		FileReader input;
		FileWriter output;
		
		try{
			input = new FileReader("C:\\Users\\mayo\\Dropbox\\Studium\\S2\\INFO2\\Exercises\\Histogram\\src\\aFile.txt");		
			int cnt;
			while((cnt = input.read()) != -1){
				System.out.print((char)cnt);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
