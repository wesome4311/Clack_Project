package main; //putting it in the main package

import java.io.*;
import java.net.*;
import java.util.*;

import data.ClackData;
/**
*ClackServer class
*In this class we initiate the connection, data sent and received and port 
*This class extends ClackData
*/
public class ClackServer{ //extends ClackData{ //why was this extending clackdata?
	
		private int port;
		private boolean closeConnection;
		private ClackData dataToReceiveFromClient;
		private ClackData dataToSendToClient;
		final static int portNumber = 7000;
		private ObjectInputStream inFromClient;
        private ObjectOutputStream outToClient;

		/**
		*Setting up the constructors for this class
		*as well as a default constructor
		*/
		public ClackServer(int port){
			this.port = port;
			this.dataToReceiveFromClient = null;
			this.dataToSendToClient = null;
		}
		
		public ClackServer(){
			this(portNumber);
		}
		
		/**
	    *Updated 10/13/2020
	    *Initialized start() method
	    */
	    public void start() {
	            try {
	                ServerSocket sskt = new ServerSocket(this.port);
	                Socket clientSkt = sskt.accept();
	                this.outToClient = new ObjectOutputStream(sskt.getOutputStream());//Error Found: The stream appears to be undefined for server sockets
	                this.inFromClient = new ObjectInputStream(sskt.getInputStream());//Error Found: The stream appears to be undefined for server sockets
	                
	                while(!closeConnection) {
	                    receiveData();
	                    sendData();
	                }
	                    
	                inFromClient.close();
	                outToClient.close();
	                clientSkt.close();
	                sskt.close();
	            
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
	        
	        
	    public void receiveData() {
	            try{
	                dataToReceiveFromClient = inFromClient.readLine(): //Error Found: type mismatch, datatorecieve is a clackdata object, while the readline is gives a string
	                System.out.println("Client Sent:"+ dataToReceiveFromClient);
	            }catch ( IOException ioe ) {
	                System.err.println( "IO Exception generated: " + ioe.getMessage() );
	            }
	            
	        }
	        
	    
	    public void sendData(){
	            try{
	                dataToSendToClient = "Echoed" + dataToReceiveFromClient; //Error Found: dataToReceiveFromClient isn't a string and neither is dataToSendToClient
	                System.out.println("Sending to client --- " + dataToSendToClient);
	                outToClient.println(dataToSendToClient); //Error Found: dataToReceiveFromClient isn't a string
	                outToClient.flush();
	            } catch( IOException ioe ) {
	                System.err.println( "IO Exception generated: " + ioe.getMessage() );
	            }
	        }
		
		//Methods
		public int getPort(){
			return port;
		}
		
		/**
		*Overriding function needed in this class
		*/
		@Override
		public int hashCode() {
		int result = 17;
		result = 37*result + getPort();
		//result = 37*result + getType(); //don't know what you were trying to get here, as clack server doesn't have a type
		return result;
		 }
		
		@Override
		public boolean equals(Object other) {
			if (other == null) return false;
			
			if (!(other instanceof ClackServer)) return false;
			
			ClackServer otherClackServer = (ClackServer)other;

			return getPort() == otherClackServer.getPort();
			
		}
		
		@Override
		public String toString(){
			return "The port # is: "+ getPort() + "\n\n";
		}
}

