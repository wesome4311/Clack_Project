package main;

import data.ClackData;

public class ClientSideServerListener implements Runnable{ //reminder to myself to create javadoc for this once I'm done
	
	private ClackClient client;
	
	public ClientSideServerListener(ClackClient client){
		this.client = client;
	}

	@Override
	public void run() {
		while(!client.closeConnection) {
			client.receiveData();
            client.printData();
		}
	}

}
