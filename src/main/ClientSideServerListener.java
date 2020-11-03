package main;

import data.ClackData;


/**
 * @author MrCol
 * ClientSideServerListener is a runnable class that works alongside ClackClient to print and receive data from the server
 */
public class ClientSideServerListener implements Runnable{
	
	private ClackClient client;
	
	
	/**
	 * Constructor that takes in a ClackClient variable and sets it to the client variable
	 * @param client
	 */
	public ClientSideServerListener(ClackClient client){
		this.client = client;
	}
	
	
	/**
	 * prints data that the client gets receives from the server
	 */
	@Override
	public void run() {
		while(!client.closeConnection) {
			client.receiveData();
            client.printData();
		}
	}

}
