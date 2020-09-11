package data;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class MessageClackData extends ClackData {
	private String message;
	
	//constructors
	public MessageClackData(String userName, String message, int type) {
		super(userName, type);
		this.message = message;
	}
	
	public MessageClackData() {
		this("Anon", "", CONSTANT_LISTUSERS);
	}
	
	//methods
	public String getData() {
		return message;
	}
	
	@Override
	public int hashCode() { //should use username and message for computation
		return 0;
		
	}
	
	@Override
	public boolean equals(Object Other) {
		return false;
		
	}
	
	@Override
	public String toString() {
		return " ";
		//return a string that's a list of all the variables, including the clack data variables
	}
}

