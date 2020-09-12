package data;

public class FileClackData extends ClackData {
	String fileName;
	String fileContents;
	
	public FileClackData(String userName, String fileName, int type) {
		super(userName, type);
		this.fileName = fileName;
		this.fileContents = null;
	}
	
	public FileClackData() {
		super();
		this.fileName = null;
		this.fileContents = null;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	@Override
	public String getData() {
		return null; //will fill in later in the project
	}
	
	public void readFileContents() {
		//will fill in later in the project
	}
	
	public void writeFileContents() {
		//will fill in later in the project
	}
	
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
	public boolean equals(Object other) { //@TODO
		if (other == null) return false;
		
		if (!(other instanceof FileClackData)) return false;
		
		FileClackData otherFileClackData = (FileClackData)other;

		return getUserName() == otherFileClackData.getUserName() &&
				fileName == otherFileClackData.fileName &&
				getType() == otherFileClackData.getType() &&
				fileContents == otherFileClackData.fileContents;
		
	}
	
	@Override
	public String toString() {
		return "The current user is "+ getUserName() + ", the date is " + getDate() + 
				", the user is trying to access the file " + fileName + " which is holding " + fileContents + ", and the type value is " + getType();
		//return a string that's a list of all the variables here; userName, date, type, filename, filecontents
	}
}

