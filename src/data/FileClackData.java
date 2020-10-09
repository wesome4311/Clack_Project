package data;
import java.io.*;

/**
  * The FileClackData class, capable of holding a file and its contents along with relevant data from ClackData
 * @author Cole Short
 * Updated 9/28/2020 by Lauren Nandal
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
	 * read the contents of a file
	 */
	public void readFileContents(String Key) {
		try {
			BufferedReader inFile = new BufferedReader(new FileReader(fileName));
			String nextLine = inFile.readLine();
			fileContents = nextLine;
			while(nextLine = inFile.readLine() != null)
			{
				fileContents = fileContents + nextLine;
			}
				
			inFile.close();
			fileContents = encrypt(fileContents, Key);
		}catch(FileNotFoundException fnfn) {
			System.err.println("File not found");
		}catch(IOException ioe) {
			System.err.println("Error in reading file");	
		}catch(ClassNotFoundException cnfe) {
			System.err.println("Class not found");	
		}
	}

	public void readFileContents() {
		try {
			BufferedReader inFile = new BufferedReader(new FileReader(fileName));
			String nextLine = inFile.readLine();
			fileContents = nextLine;
			while(nextLine = inFile.readLine() != null)
			{
				fileContents = fileContents + nextLine;
			}
				
			inFile.close();
		}catch(FileNotFoundException fnfn) {
			System.err.println("File not found");
		}catch(IOException ioe) {
			System.err.println("Error in reading file");	
		}catch(ClassNotFoundException cnfe) {
			System.err.println("Class not found");	
		}
	}
	/**
	 * write to a file
	 */
	public void writeFileContents() {
		try {
			BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
			outFile.write(fileContents);
				
			outFile.close();
			
		}catch(FileNotFoundException fnfn) {
			System.err.println("File not found");
		}catch(IOException ioe) {
			System.err.println("Error in reading file");	
		}catch(Exception ex) {
			System.err.println("Error in closing file");	
		}
	}

	public void writeFileContents(String Key) {
		try {
			BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
			fileContents = decrypt(fileContents, Key);
			outFile.write(fileContents);
				
			outFile.close();
			
		}catch(FileNotFoundException fnfn) {
			System.err.println("File not found");
		}catch(IOException ioe) {
			System.err.println("Error in reading file");	
		}catch(Exception ex) {
			System.err.println("Error in closing file");	
		}
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
				fileName == otherFileClackData.fileName &&
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
