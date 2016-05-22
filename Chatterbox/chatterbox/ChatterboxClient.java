/**
 * 
 */
package chatterbox;

import java.net.*; import java.io.*;

/**
 * @author Jannes Brunner & Mario Schuetz
 *
 */

public class ChatterboxClient {
	
	int portnumber;

	/**
	 * @param args
	 */
	
	public ChatterboxClient (String address, int portnumber){
		
		try {
			writer(address, portnumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writer(String adress, int portnumber) throws IOException{
		Socket connection = null;
		
		try {
			connection = new Socket(adress, portnumber);
		
			PrintWriter output = new PrintWriter(connection.getOutputStream(),true);		
		
			System.out.println("Type /q to escape");
			String message = "";		
		
			while (!message.equals("/q")){
				
				message = Userinput.getInput();
				output.println(message);
			} 
		}
		catch (ConnectException e) {
			
			// e.printStackTrace();
			System.out.println("Connection Problem. Server is unreachable.");
		}
		finally { 
				try{
					connection.close();
				}
				catch (NullPointerException e) {
				} 
		}
	}			
} 