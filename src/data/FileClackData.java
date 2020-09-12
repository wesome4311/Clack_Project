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
	public int hashCode() { //should use just username, filename, filecontents for computation, as that's the relevant info for using a file?
	int result = 17;
	result = 37*result + getUserName().hashCode();
	result = 37*result + fileName.hashCode();
	result = 37*result + fileContents.hashCode();
	return result;
	 }
	
	@Override
	public boolean equals(Object Other) { //@TODO
		return false;
		
	}
}

