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
	public int hashCode() { //should use just message, username and type for computation, as that's the relevant info for a message?
	int result = 17;
	result = 37*result + message.hashCode();
	result = 37*result + getUserName().hashCode();
	result = 37*result + getType();
	return result;
	 }
	
	@Override
	public boolean equals(Object other) { //@TODO
		if (other == null) return false;
		
		if (!(other instanceof MessageClackData)) return false;
		
		MessageClackData otherMessageClackData = (MessageClackData)other;

		return getUserName() == otherMessageClackData.getUserName() &&
				getType() == otherMessageClackData.getType() &&
				message == otherMessageClackData.message;
	}
	
	@Override
	public String toString() {
		return "The current user is "+ getUserName() + ", the date is " + getDate() + 
				", the user's message is " + message + " and the type value is " + getType();
		//return a string that's a list of all the variables here; userName, date, type, message
	}
}

