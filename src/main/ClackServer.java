package main; //putting it in the main package

import java.util.*;
/**
*ClackServer class
*In this class we initiate the connection, data sent and received and port 
*This class extends ClackData
*/
public class ClackServer extends ClackData{
	
		private int port;
		private boolean closeConnection;
		private ClackData dataToReceiveFromClient;
		private ClackData dataToSendToClient;
		/**
		*Setting up the constructors for this class
		*as well as a default constructor
		*/
		public ClackServer(Port){
			this.port = port;
			this.dataToReceiveFromClient = null;
			this.dataToSendToClient = null;
		}
		public ClackServer(){
			const port = 7000;
			this("Anon", port );
		}
		
		/**
		*Declaring function that will be initialized later in the project
		*/
		public void start() {
			
		}
		public void receiveData() {
			
		}
		public void sendData(){
			
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
		result = 37*result + getPort()).hashCode();
		result = 37*result + getType();
		return result;
		 }
		
		@Override
		public boolean equals(Object other) {
			if (other == null) return false;
			
			if (!(other instanceof ClackServer)) return false;
			
			FileClackData otherClackServer = (FileClackData)other;

			return getPort() == otherClackServer.getPort();
			
		}
		
		@Override
		public String toString(){
			return "The port # is: "+ getPort() + "\n\n";
		}
}

