import java.util.*;

public class PreLab20160426 {

	public static void main(String[] args) {
		
		// #1
		char aChar = 'A';
		
		for(int i = 0; i < 26; i++){
			System.out.println((char)(aChar + i));
		}
		
		// #2
		normalizer(aChar);
		

	}
	
	public static void normalizer(char x){
		
		if((int)x >= 65 && (int)x <= 90){
			System.out.println("To lowercase: " + (char)(x + 32));
		}
		else if((int)x >= 97 && (int)x <= 122){
			System.out.println("To uppercase: " + (char)(x - 32));
		}			
	}

}
