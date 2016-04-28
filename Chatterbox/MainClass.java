/**
 * 
 */
package chatterbox;


/**
 * @author Jannes Brunner
 *
 */
public class MainClass {

	/**
	 * @param args
	 */

	
	public ChatterboxServer server;
	public ChatterboxClient client;
	public static Userinput usrin;
	public MainClass main;

	/* Main */
	public static void main(String[] args) {
		
		new MainClass(args);
		
		
	}

	public MainClass(String[] args) {
		// Checking args
		if (args.length != 0) {
			if (args[0].equals("-s") || args[0].equals("-S")) {
				int portnumber = Integer.parseInt(args[1]);
				this.server = new ChatterboxServer(portnumber);
				
				}
			if (args[0].equals("-c") || args[0].equals("-C")) {
				String adress = args[1];
				int portnumber = Integer.parseInt(args[2]);
				this.client = new ChatterboxClient(adress, portnumber);
				
			}
			else System.out.println("[Invalid start arguments]");
		} 

		
		
		bash();
         

	}

	public void bash() {
		System.out.println("Chatterbox v1.0 by mayo & Jay Bee \n (C) 2016 HTW Berlin");
		boolean want2escape = false;
		while (!want2escape) {
			System.out.println("1 = Start Server, 2 = Start Client, q = quit");

			String input = Userinput.getInput();
			switch (input) {
			case "1":
				System.out.println("Server selected \n");
				System.out.print("Port? ");
				String portsrv = Userinput.getInput();
				int portnumber = Integer.parseInt(portsrv);
				this.server = new ChatterboxServer(portnumber);
				 want2escape = true;
				break;
			case "2":
				System.out.println("Client selected");
				System.out.print("IP-Adress?");
				String ip_adress = Userinput.getInput();
				System.out.print("Port?");
				String portclnt = Userinput.getInput();
				int portnumberclnt = Integer.parseInt(portclnt);
								
				this.client = new ChatterboxClient(ip_adress, portnumberclnt);
				break;
			case "q":
				System.out.println("Quit selected");
				System.out.println("Good bye...");
				want2escape = true;
				break;
			default:
				System.out.println("Error");
				break;

			}
		}

	}

}
