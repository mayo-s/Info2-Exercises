/**
 * 
 */
package chatterbox;

import java.util.*;

/**
 * @author Jannes Brunner & Mario Schuetz
 * 
 *
 */
public class Userinput {	
			  
		  public static String getInput() {
			  Scanner sc = new Scanner(System.in);
			  String input = "";		
			  System.out.print(":> ");
			  input = sc.next();
			  
			  return input;						  
		  }
}