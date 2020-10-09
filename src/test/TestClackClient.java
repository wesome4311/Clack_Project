package test; //making it apart of the test package

public class TestClackClient {
	public static void main(String[] args){
		ClackClient ClackClient1 = new ClackClient(); 
		ClackClient ClackClient2 = new ClackClient("Peter"); 
		ClackClient ClackClient3 = new ClackClient("phillip", "insidehost"); 
		ClackClient ClackClient1 = new ClackClient("bob","outsidehost",7002);
		
		
		System.out.println("Testing ClackClient: \n" 
				+ "getUserName: " + ClackClient1.getUserName() + "\n" 
				+ "hashCode: "+ ClackClient1.hashCode() + "\n"
				+ "getHostName: " + ClackClient1.getHostName() + "\n"
				+ "getPort: " + ClackClient1.getPort() + "\n"
				+ "equals: "+ ClackClient1.equals() + "\n"
				+ "toString: "+ ClackClient1.toString() + "\n\n");
	}
}
