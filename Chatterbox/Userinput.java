/**
 * 
 */
package chatterbox;


import java.util.*;

/**
 * @author Jannes Brunner
 * 
 *
 */
public class Userinput {
	
			  
		  public static String getInput() {
			  Scanner sc = new Scanner(System.in);
			  String eingabe = "";		
			  System.out.print(":> ");
			  eingabe = sc.next();
			  
			  return eingabe;
						  
		  }
		  
		  
		  
		  
		  
		}