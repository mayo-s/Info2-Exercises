/**
 * 
 */
package chatterbox;

import java.net.*; import java.io.*;

/**
 * @author Jannes Brunner & Mario Schuetz
 *
 */ 

public class ChatterboxServer {		
	
	public ChatterboxServer (int portnumber){
		
		try {
			listener(portnumber);
		}
		catch (IOException e) {
			System.out.println("IO Error. Please check your connection");
		}
		System.out.println("Server closed.");
	}	

	public void listener(int portnumber) throws IOException{
		
		System.out.println("The portnumber is:" + portnumber);
		System.out.println("Setting up Server...");
		
		ServerSocket connectionSocket = new ServerSocket(portnumber);
		
		System.out.println("Server is ready!\nWaiting for input.");
		
		Socket inputSocket=connectionSocket.accept();
		InputStreamReader portReader = new InputStreamReader(inputSocket.getInputStream());
		BufferedReader data = new BufferedReader(portReader);
		String s = "";
		
		while (s != null) {
			s = data.readLine();
			System.out.println("Client: "+s);
		}
		connectionSocket.close();		
	}		
}