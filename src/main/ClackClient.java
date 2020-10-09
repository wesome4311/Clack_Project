package main; //putting it in the main package

import java.util.*;

import data.ClackData;

/**
*ClackClient class
*In this class we initiate the userName, hostName and port 
*This class extends ClackData
*/
public class ClackClient{ // extends ClackData{ //why was this extending clackdata?

		private String userName;
		private String hostName;
		private int port;
		private boolean closeConnection;
		private ClackData dataToSendToServer;
		private ClackData dataToReceiveFromServer;
		final static int portNumber = 7000;
	
		/**
		*Setting up the constructors for this class
		*as well as a default constructor
		*/
		
		public ClackClient(String userName, String hostName, int port){
			this.userName = userName;
			this.hostName = hostName;
			this.port = port;
			this.closeConnection = true; //open
			this.dataToReceiveFromServer = null;
			this.dataToSendToServer = null;
		}
		
		public ClackClient(String userName, String hostName){
			this(userName, hostName, portNumber);
		}
		
		public ClackClient(String userName){
			this(userName, "localhost");
		}
		
		public ClackClient(){
			this("Anon");
		}
		
		
		
		
		/**
		*Declaring function that will be initialized later in the project
		*/
		public boolean start() {
			return true;
		}
		
		
		public void readClientData() {
			
		}
		
		
		public void sendData() {
			
		}
		
		
		public void receiveData() {
			
		}
		
		
		public void printData() {
			
		}

		
		
		//Methods
		public String getUserName(){
			return userName;
		}
		public String getHostName(){
			return hostName;
		}
		public int getPort(){
			return port;
		}
		
		/**
		*Overriding function needed in this class
		*/
		@Override
		public int hashCode(){
			int result = 17;
			result = 37*result + getUserName().hashCode();
			result = 37*result + getHostName().hashCode();
			result = 37*result + getPort();
			//result = 37*result + getType(); //don't know what you were trying to get here, as clack client doesn't have a type
			return result;
		}
		
		@Override
		public boolean equals(Object other){
			if (other == null) 
				return false;
			if (!(other instanceof ClackClient)) 
				return false;
			
			ClackClient otherClackClient = (ClackClient)other;

			return getUserName() == otherClackClient.getUserName() &&
					hostName == otherClackClient.getHostName() &&
					getPort() == otherClackClient.getPort();
			
		}
		
		@Override
		public String toString(){
			return "The port #  is: "+ getPort() + "\n" +
					"The userName is: "+ getUserName() + "\n"+ 
					"The hostName is: "+ getHostName() + "\n\n";
		}

}
