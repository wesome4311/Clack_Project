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

	/**
	 * abstract method, decrypts and returns either a message or a file's contents
	 */
	public abstract String getData(String key);
	
	public String lengthen(String line, String key) { 
		int i = 0;
	    while (true) 
	    { 
	        if (line.length() == i) 
	            i = 0; 
	        if (key.length() == line.length()) 
	            break;
	        key+=(key.charAt(i)); 
	        i++;
	    }
	    //used https://www.geeksforgeeks.org/vigenere-cipher/ as a reference
	    return key; 
	}
	
	protected String encrypt( String inputStringToEncrypt, String key ){
		//need to lengthen the key to the length of the string
		key = lengthen(inputStringToEncrypt, key);
		
		String encrypted="";
		for (int i = 0; i < inputStringToEncrypt.length(); i++){
			//following if statements test if differentiate if its uppercase, lowercase or something else(in which case it just gets the original)
			if (Character.isUpperCase(inputStringToEncrypt.charAt(i))) {
				int y = (inputStringToEncrypt.charAt(i) + key.charAt(i)) %26;
				// convert into uppercase character
		        y += 'A';
		        encrypted += (char)(y);
			}
			else if (Character.isLowerCase(inputStringToEncrypt.charAt(i))) {
				int y = (inputStringToEncrypt.charAt(i) + Character.toLowerCase(key.charAt(i))) %26;
				// convert into lowercase character
		        y += 'a';
		        encrypted += (char)(y);
			}
			else {
				//simply adding non-letter characters to the encrypted string, as we don't have to include them
				encrypted += inputStringToEncrypt.charAt(i);
			}
	    }
		//used https://www.geeksforgeeks.org/vigenere-cipher/ as a reference
	    return encrypted;
	}

	protected String decrypt( String inputStringToDecrypt, String key ){
	    //need to lengthen the key to the length of the string
		key = lengthen(inputStringToDecrypt, key);
		
		String decrypted=""; 
	    for (int i = 0 ; i < inputStringToDecrypt.length(); i++) {
	    	//following if statements test if differentiate if its uppercase, lowercase or something else(in which case it just gets the original)
			if (Character.isUpperCase(inputStringToDecrypt.charAt(i))) {
				int x = (inputStringToDecrypt.charAt(i) - key.charAt(i) + 26) %26;
		        // convert into an uppercase character 
		        x += 'A'; 
		        decrypted += (char)(x); 
			}
			else if (Character.isLowerCase(inputStringToDecrypt.charAt(i))) {
				int x = (inputStringToDecrypt.charAt(i) - Character.toLowerCase(key.charAt(i)) + 26) %26;
				  
		        // convert into lowercase character 
		        x += 'a'; 
		        decrypted += (char)(x); 
			}
			else {
				//simply adding non-letter characters to the encrypted string, as we don't have to include them
				decrypted += inputStringToDecrypt.charAt(i);
			}
	    }
	  //used https://www.geeksforgeeks.org/vigenere-cipher/ as a reference
	  return decrypted;
	}
}
