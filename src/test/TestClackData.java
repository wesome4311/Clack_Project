package test; //making it apart of the test package

import data.FileClackData;
import data.MessageClackData;

public class TestClackData{
	public static void main(String[] args){
		FileClackData fileClackData1 = new FileClackData(); //Testing default constructor
		FileClackData fileClackData2 = new FileClackData("Hi"); //Testing single input constructor
		FileClackData fileClackData3 = new FileClackData("phillip", "Bye"); //Testing two input constructor
		MessageClackData MessageClackData1 = new MessageClackData();
		MessageClackData MessageClackData2 = new MessageClackData("Peter","Hello World", "Hi");
		
		System.out.println("Testing MessageClackData: \n" + "getData: " + MessageClackData1.getData() + "\n" 
							+ "hashCode: "+ MessageClackData1.hashCode() + "\n"
							+ "equals: "+ MessageClackData1.equals() + "\n"
							+ "toString: "+ MessageClackData1.toString() + "\n\n");
		
		System.out.println("Testing FileClackData: \n" 
				+ "getData: " + fileClackData1.getData() + "\n" 
				+ "hashCode: "+ fileClackData1.hashCode() + "\n"
				+ "setFileName: " + fileClackData1.setFileName() + "\n"
				+ "getFileName: " + fileClackData1.getFileName() + "\n"
				+ "equals: "+ fileClackData1.equals() + "\n"
				+ "toString: "+ fileClackData1.toString() + "\n\n");
	}
	
}