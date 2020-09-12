package data; //making it apart of the data package

import java.util.*;
import clack.Clack;

/**
 * The abstract class ClackData, which holds and allows access of the variables userName, type, and date
 *
 * @author Cole Short
 */
public abstract class ClackData implements Clack{
	private String userName; //String representing name of client user
	private int type;
	private Date date; //Date object representing date when ClackData object was created
	
	//constructors
	/**
	 * constructor that takes userName and type, then generates a date
	 * @param userName
	 * @param type
	 */
	public ClackData( String userName, int type ) {
		this.userName = userName;
		this.type = type;
		this.date = new Date();
	}
	
	/**
	 * constructor that takes type, and passes adds on Anon as the default userName
	 * @param type
	 */
	public ClackData( int type ) {
		this("Anon", type );
	}
	
	/**
	 * constructor that takes no arguments, and assigns zero as the default value of type
	 */
	public ClackData() {
		this(CONSTANT_LISTUSERS); //type currently defaults to list users
	}
	
	//methods
	/**
	 * returns the type
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * returns the username of the current user
	 * @return the userName variable
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * returns the date
	 * @return the date variable
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * abstract method, returns either a message or a file's contents
	 */
	public abstract String getData();
}


