package data; //making it apart of the data package

import java.util.*;

import clack.Clack;

public abstract class ClackData implements Clack{
	private String userName; //String representing name of client user
	private int type;
	private Date date; //Date object representing date when ClackData object was created
	
	//constructors
	public ClackData( String userName, int type ) {
		this.userName = userName;
		this.type = type;
		this.date = new Date();
	}
	
	public ClackData( int type ) {
		this("Anon", type );
	}
	
	public ClackData() {
		this(CONSTANT_LISTUSERS); //type currently defaults to list users
	}
	
	//methods
	public int getType() {
		return type;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public Date getDate() {
		return date;
	}
	
	public abstract String getData();
}


