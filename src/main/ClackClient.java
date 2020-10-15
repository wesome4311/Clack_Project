package main; //putting it in the main package

import data.ClackData;
import java.util.*;

import clack.Clack;

import java.io.*;
import java.net.*;


/**
*ClackClient class
*In this class we initiate the userName, hostName and port 
*This class extends ClackData
*/

public class ClackClient implements Clack{ //you had this extend clackdata before, and I don't know why, currently Clack just provides the int portNumber = 7000

		private String userName;
		private String hostName;
		private int port;
		private boolean closeConnection;
		private ClackData dataToSendToServer;
		private ClackData dataToReceiveFromServer;
		private Scanner inFromStd;
        private ObjectInputStream inFromServer;
        private ObjectOutputStream outToServer;

	
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
		
		
		
		
		/*
         * Updated 9/28/2020 
         * Initializing the interface
         * Updated 10/13/2020
         * Implementing outToServer and inToServer
         */
        public boolean start() {
            this.inFromStd = new Scanner(System.in);
            try{
                Socket skt = new Socket(this.hostName, this.port);
                this.outToServer = new ObjectOutputStream(skt.getOutputStream());
                this.inFromServer = new ObjectInputStream(new PrintWriter(skt.getOutputStream(), true ););
                while(!closeConnection) {
                    readClientData();
                    sendData();
                    receiveData();
                    printData();
                }
                
                this.outToServer.close();
                this.inFromServer.close();
                skt.close();
            } catch( UnknownHostException uhe) {
                System.err.println( "Route to host is not available" );
            } catch( ConnectException ce) {
                System.err.println( "Connect Exception" );
            }catch( NoRouteToHostException nrthe) {
                System.err.println( "No route to host" );
            }catch( IOException ioe ) {
                System.err.println( "IO Exception generated: ");
            }
        }
        
        
        public void readClientData() {
            dataToSendToServer = inFromStd.readLine();
        }
        
        
        public void printData() {
            System.out.println("Server Sent: " + dataRecievedFromServer)
        }
        
        
        /**
        *Updated 10/13/2020
        *Implementing sendData() and recieveData() for server use
        */
        public void sendData() {
            try {
                outToServer.println(dataToSendToServer)
            }catch( IOException ioe ) {
                System.err.println( "IO Exception generated: " + ioe.getMessage() );
            }
        }
        
        
        public void receiveData() {
            try {
                dataToRecieveFromServer = inFromServer.readLine();
            }catch( IOException ioe ) {
                System.err.println( "IO Exception generated: " + ioe.getMessage() );
            }
        }


		
		
        /*Methods
         *Updated 9/28/2020
         */
         public String getUserName(){
             try{
                 if(userName == "Null") {
                     throw new IllegalArgumentException("Username is null");
                 }else
                     return userName;
             }catch(IllegalArgumentException i) {
                 System.err.print("Illegal Arguement");
             }
             
         }
         
         
         public String getHostName(){
             try{
                 if(hostName == "Null") {
                     throw new IllegalArgumentException("Hostname is null");
                 }else
                     return hostName;
             }catch(IllegalArgumentException i) {
                 System.err.print("Illegal Arguement");
             }
             
         }
         
         
         public int getPort(){
             try{
                 if(port < 1024) {
                     throw new IllegalArgumentException("Port is less than 1024");
                 }else
                     return port;
             }catch(IllegalArgumentException i) {
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
