package data;


public class MessageClackData extends ClackData {
	private String message;
	
	//constructors
	public MessageClackData(String userName, String message, int type) {
		super(userName, type);
		this.message = message;
	}
	
	public MessageClackData() {
		this("Anon", null, CONSTANT_LISTUSERS);
	}
	
	//methods
	public String getData() {
		return message;
	}
	
	@Override
	public int hashCode() { //should use just message and username for computation, as that's the relevant info for a message?
	int result = 17;
	result = 37*result + message.hashCode();
	result = 37*result + getUserName().hashCode();
	return result;
	 }
	
	@Override
	public boolean equals(Object Other) { //@TODO
		return false;
		
	}
	
	@Override
	public String toString() {
		return "The current user is "+ getUserName() + ", the date is " + getDate() + 
				", the user's message is " + message + " and the type value is " + getType();
		//return a string that's a list of all the variables here; userName, date, type, message
	}
}

