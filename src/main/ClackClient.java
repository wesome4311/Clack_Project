package main; //putting it in the main package

import java.util.*;
import java.io.*;
import java.net.*;

/**
*ClackClient class
*In this class we initiate the userName, hostName and port 
*This class extends ClackData
*/
public class ClackClient extends ClackData{

		private String userName;
		private String hostName;
		private int port;
		private boolean closeConnection;
		private ClackData dataToSendToServer;
		private ClackData dataToReceiveFromServer;
		private Scanner inFromStd = new Scanner(new InputStreamReader( System.in ));;

	
		/**
		*Setting up the constructors for this class
		*as well as a default constructor
		*/
		public ClackClient(userName, hostName, port){
			this.port = port;
			this.userName = userName;
			this.hostName = hostName;
			this.closeConnection = true; //open
			this.dataToReceiveServer = null;
			this.dataToSendToServer = null;
		}
		public ClackClient(userName, hostName){
			const port = 7000;
			this("Anon",userName, hostName, port);
		}
		public ClackClient(userName){
			this.userName = userName;
			this.hostName = "localhost";
		}
		public ClackClient(){
			this.userName = "anonymous";
			this("Anon", userName);
		}
		

		/*
		 * Updated 9/28/2020 
		 * Initializing the interface
		 */
		public boolean start() {
			try{
				Socket skt = new Socket(userName, port);
				readClientData();
				printData();
			} catch( NoRouteToHostException nrhe ) {
				System.err.println( "Route to host not available" );
			} catch( ConnectException ce ) {
				System.err.println( "Connection Refused" );
			} catch( IOException ioe ) {
				System.err.println( "IO Exception generated: ");
			}
		}
		public void readClientData() {
			inFromStd.readLine();
		}
		public void printData() {
			PrintWriter outToServer = new PrintWriter(skt.getOutputStream(), true );
		}
		
		/**
		*Declaring function that will be initialized later in the project
		*/
		public void sendData() {
			
		}
		public void receiveData() {
			
		}
		
		/*Methods
		*Updated 9/28/2020
		*/
		public String getUserName(){
			try{
				if(userName == "Null") {
					throw new IllegalArguementException("Username is null");
				}else
					return userName;
			}catch(IllegalArguementException i) {
				System.err.print("Illegal Arguement");
			}
			
		}
		public String getHostName(){
			try{
				if(hostName == "Null") {
					throw new IllegalArguementException("Hostname is null");
				}else
					return hostName;
			}catch(IllegalArguementException i) {
				System.err.print("Illegal Arguement");
			}
			
		}
		public int getPort(){
			try{
				if(port < 1024) {
					throw new IllegalArguementException("Port is less than 1024");
				}else
					return port;
			}catch(IllegalArguementException i) {
				System.err.print("Illegal Arguement");
			}
			
		}
		
		/**
		*Overriding function needed in this class
		*/
		@Override
		public int hashCode(){
			int result = 17;
			result = 37*result + getUserName().hashCode();
			result = 37*result + getHostName.hashCode();
			result = 37*result + getPort.hashCode();
			result = 37*result + getType();
			return result;
		}
		
		@Override
		public boolean equals(Object other){
			if (other == null) 
				return false;
			if (!(other instanceof ClackClient)) 
				return false;
			
			FileClackData otherClackClient = (FileClackData)other;

			return getUserName() == otherClackClient.getUserName() &&
					hostName == otherClackClient.hostName &&
					getPort() == otherClackClient.getPort();
			
		}
		
		@Override
		public String toString(){
			return "The port #  is: "+ getport() + "\n" +
					"The userName is: "+ getUserName()) + "\n"+ 
					"The hostName is: "+ getHostName() + "\n\n";
		}
}
