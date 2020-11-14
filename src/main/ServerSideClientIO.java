package main; //putting it in the main package

import java.io.*;
import java.net.Socket;
import java.net.Exception;

/**
*ServerSideClientIO class
*This class takes over receiving and sending data between the server and clients
*This class implements runnable
*/

public class ServerSideClientIO implements runnable{
	private boolean closeConnection;
	private ClackData dataToRecieveFromClient;
	private ClackData dataToSendToClient;
	private ObjectInputStream inFromClient;
	private ObjectOutputStream outToClient;
	private ClackServer server;
	private Socket clientSocket;
	
	public serverSideClientIO(ClackServer server, Socket clientSocket){
		this.server = server;
		this.clientSocket = clientSocket;
		this.closeConnection = 'false';
		this.dataToRecieveFromClient = null;
		this.dataToSendToClient = null;
		this.inFromClient = null;
		this.outToClient = null;
	}
	
	@Override
	public void run(){
		try {
			this.outToClient = new ObjectOutputStream(sskt.getOutputStream());
            this.inFromClient = new ObjectInputStream(sskt.getInputStream());
            
            while(!closeConnection) {
                receiveData();
                this.server.broadcast(dataToReceiveFromClient);
                
            }
            
		}catch(UnknownHostException uhe) {
            System.err.println( "Route to host not available" );
        }catch( ConnectException ce) {
            System.err.println( "Connect Exception" );
        }catch( NoRouteToHostException nrthe) {
            System.err.println( "No route to host" );
        }catch( IOException ioe ) {
            System.err.println( "IO Exception generated: ");
        }
	}
	
	public void receiveData(){
		
		try{
			dataToReceiveFromClient = (ClackData) this.inFromClient.readObject();
             if(dataToReceiveFromClient.getType() == 1 ) {
            	 this.closeCOnnection = true;
            	 this.server.remove();
             }
             System.out.println("Client Sent:"+ dataToReceiveFromClient);
         }catch ( IOException ioe ) {
             System.err.println( "IO Exception generated: " + ioe.getMessage() );
         }
	}
	
	public void sendData(){
		try{
        	if (dataToReceiveFromClient.getData() == "LISTUSERS") {
        		String string_of_users;
        		for (int i = 0; i < list_of_users.size(); i++) {
        			string_of_users = string_of_users + ", " + list_of_users.get(i);
        		}
        		dataToSendToClient.setData(string_of_users);
        	}
        	else {
        		dataToSendToClient.setData("Echoed " + dataToReceiveFromClient.getData()); 
        	}
            System.out.println("Sending to client --- " + dataToSendToClient);
            outToClient.println(dataToSendToClient);
            outToClient.flush();
        } catch( IOException ioe ) {
            System.err.println( "IO Exception generated: " + ioe.getMessage() );
        }
	}
	
	public void setDataToSendToClient(ClackData dataToSendToClient){
		this.dataToSendToClient = dataToSendToClient; 
	}
	
}
