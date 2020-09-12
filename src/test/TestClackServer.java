package test; //making it apart of the test package

public class TestClackServer {
	public static void main(String[] args){
		ClackServer ClackServer1 = new ClackServer();
		ClackServer ClackServer2 = new ClackServer(7001);
		
		System.out.println("Testing ClackServer: \n" + "getPort: " + ClackServer1.getPort() + "\n" 
				+ "hashCode: "+ ClackServer1.hashCode() + "\n"
				+ "equals: "+ ClackServer1.equals() + "\n"
				+ "toString: "+ ClackServer1.toString() + "\n\n");

}
