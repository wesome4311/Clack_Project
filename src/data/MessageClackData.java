package data;

/**
 * The MessageClackData class, capable of holding messages and relevant data from ClackData
 * 
 * @author Cole Short
 */
public class MessageClackData extends ClackData {
	private String message;
	
	//constructors
	/**
	 * Constructor that takes userName, message, and type, which it uses to call ClackData's constructor
	 * @param userName
	 * @param message
	 * @param type
	 */
	public MessageClackData(String userName, String message, int type) {
		super(userName, type);
		this.message = message;
	}
	
	/**
	 * constructor that takes no arguments, and sets username to Anon, the message to null, and the type zero
	 */
	public MessageClackData() {
		this("Anon", null, CONSTANT_LISTUSERS);
	}
	
	//methods
	/**
	 * returns the user's message
	 * @return the message
	 */
	public String getData() {
		return message;
	}
	
	
	@Override
	/**
	 * calculates a hashcode based on the class' variables
	 * @return an integer value for a hashcode
	 */
	public int hashCode() { //should use just message, username and type for computation, as that's the relevant info for a message?
	int result = 17;
	result = 37*result + message.hashCode();
	result = 37*result + getUserName().hashCode();
	result = 37*result + getType();
	return result;
	 }
	
	@Override
	/**
	 * checks an object against the current MessageClackData object, and sees if they're the same
	 * @param other
	 * @return true if the objects are equal, and false if they're not
	 */
	public boolean equals(Object other) { //@TODO
		if (other == null) return false;
		
		if (!(other instanceof MessageClackData)) return false;
		
		MessageClackData otherMessageClackData = (MessageClackData)other;

		return getUserName() == otherMessageClackData.getUserName() &&
				getType() == otherMessageClackData.getType() &&
				message == otherMessageClackData.message;
	}
	
	/**
	 * returns a sentence containing all the applicable variables
	 * @return string sentence that contains all the applicable variables 
	 */
	@Override
	public String toString() {
		return "The current user is "+ getUserName() + ", the date is " + getDate() + 
				", the user's message is " + message + " and the type value is " + getType();
		//return a string that's a list of all the variables here; userName, date, type, message
	}
}

