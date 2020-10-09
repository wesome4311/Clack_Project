package data;

/**
  * The FileClackData class, capable of holding a file and its contents along with relevant data from ClackData
 * @author Cole Short
 */
public class FileClackData extends ClackData {
	String fileName;
	String fileContents;

	//constructors
	/**
	 * constructor that takes a userName, fileName, and type, uses a constructor from ClackData, and sets fileContents to null
	 * @param userName
	 * @param fileName
	 * @param type
	 */
	public FileClackData(String userName, String fileName, int type) {
		super(userName, type);
		this.fileName = fileName;
		this.fileContents = null;
	}

	/**
	 * constructor that uses a constructor from Clackdata, then sets fileName and fileContents to null
	 */
	public FileClackData() {
		super();
		this.fileName = null;
		this.fileContents = null;
	}

	
	
	//methods
	/**
	 * sets the fileName as the given value
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * returns the name of the file accessed
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * returns the filecontents, which are currently just null
	 * @return the fileContents
	 */
	@Override
	public String getData() {
		return fileContents; //will fill in later in the project
	}

	/**
	 * returns the filecontents, but first decrypts it
	 * @return the decrypted fileContents
	 */
	@Override
	public String getData(String key) {
		return decrypt(fileContents, key);
	}

	/**
	 * will theoretically read the contents of a file, but is not currently done
	 */
	public void readFileContents() {
		//will fill in later in the project
	}

	/**
	 * will theoretically write to a file, but is not currently done
	 */
	public void writeFileContents() {
		//will fill in later in the project
	}

	/**
	 * calculates a hashcode based on the class' variables
	 * @return an integer value for a hashcode
	 */
	@Override
	public int hashCode() { //should use just username, filename, filecontents and type for computation, as that's the relevant info for using a file?
	int result = 17;
	result = 37*result + getUserName().hashCode();
	result = 37*result + fileName.hashCode();
	result = 37*result + fileContents.hashCode();
	result = 37*result + getType();
	return result;
	 }

	@Override
	/**
	 * checks an object against the current FileClackData object, and sees if they're the same
	 * @param other
	 * @return true if the objects are equal, and false if they're not
	 */
	public boolean equals(Object other) { //@TODO
		if (other == null) return false;

		if (!(other instanceof FileClackData)) return false;

		FileClackData otherFileClackData = (FileClackData)other;

		return getUserName() == otherFileClackData.getUserName() &&
				fileName == otherFileClackData.getFileName() &&
				getType() == otherFileClackData.getType() &&
				fileContents == otherFileClackData.fileContents;

	}

	/**
	 * returns a sentence containing all the applicable variables
	 * @return string sentence that contains all the applicable variables
	 */
	@Override
	public String toString() {
		return "The current user is "+ getUserName() + ", the date is " + getDate() +
				", the user is trying to access the file " + fileName + " which is holding " + fileContents + ", and the type value is " + getType();
		//return a string that's a list of all the variables here; userName, date, type, filename, filecontents
	}
}
