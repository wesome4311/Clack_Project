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
                this.inFromServer = new ObjectInputStream(new PrintWriter(skt.getOutputStream(), true );); //Error Found: gonna be honest, no idea what your doing here, but it's saying " The constructor ObjectInputStream(PrintWriter) is undefined"
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
            dataToSendToServer = inFromStd.readLine(); //Error Found: scanner doesn't have a readline function, plus datatosendtoserver is a clackdata object, not a string
        }
        
        
        public void printData() {
            System.out.println("Server Sent: " + dataRecievedFromServer) //Error Found: datarecievedfromserver isn't a string, its a clackdata object
        }
        
        
        /**
        *Updated 10/13/2020
        *Implementing sendData() and recieveData() for server use
        */
        public void sendData() {
            try {
                outToServer.println(dataToSendToServer);//Error Found: objectoutputstream(what outtoserver is) doesn't have a println function, and datatosendtoserver isn't a string, its a clackdata object
            }catch( IOException ioe ) {
                System.err.println( "IO Exception generated: " + ioe.getMessage() );
            }
        }
        
        
        public void receiveData() {
            try {
                dataToRecieveFromServer = inFromServer.readLine(); //Error Found: datatorecievefromserver isn't a string, its a clackdata object, and I got a warning that readline is depreciated
            }catch( IOException ioe ) {
                System.err.println( "IO Exception generated: " + ioe.getMessage() );
            }
        }


		
		
        /*Methods
         *Updated 9/28/2020
         */
         public String getUserName(){ //Error Found: getusername has to return a string in both cases of the if statement, including if the username is null
             try{
                 if(userName == "Null") {
                     throw new IllegalArgumentException("Username is null");
                 }else
                     return userName;
             }catch(IllegalArgumentException i) {
                 System.err.print("Illegal Arguement");
             }
             
         }
         
         
         public String getHostName(){ //Error Found: gethostname has to return a string in both cases of the if statement, including if the hostname is null
             try{
                 if(hostName == "Null") {
                     throw new IllegalArgumentException("Hostname is null");
                 }else
                     return hostName;
             }catch(IllegalArgumentException i) {
                 System.err.print("Illegal Arguement");
             }
             
         }
         
         
         public int getPort(){ //Error Found: getport has to return an int in both cases of the if statement, including if the port is less than 1024
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
