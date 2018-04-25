package br.unibh.designpatterns.proxy;

/**
 * Concrete implementation for AbstractSubject, providing the "heavy-weighted"
 * implementations for the operations
 */
public class ConcreteSubject extends AbstractSubject {
	
	private String fileName;
	
	public ConcreteSubject(String fileName) {
		this.fileName = fileName;
	}

	
	public String getContent() {
		System.out.println("Getting file contents");
		return "abdefghijklmnopqrstuvwxyz";
	}

	
	public void rename(String username, String newName) {
		System.out.println("User "+username+" is renaming file " + fileName 
				+ " to " + newName);
	}
	
	
	public String getLine(int lineNumber){
		System.out.println("Retrieving line number "+lineNumber);
		return "Hello I am line number "+lineNumber;
	}
}
