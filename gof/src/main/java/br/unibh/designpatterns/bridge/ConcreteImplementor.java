package br.unibh.designpatterns.bridge;

/**
 * Implements the operations stated in Implementor and that will be used by
 * the Abstraction subclasses
 */
public class ConcreteImplementor implements Implementor {
	
	private String name;

	public ConcreteImplementor(String name) {
		this.name = name;
	}

	
	public void openMouth() {
		// does nothing
	}

	
	public String tellName() {
		return this.name;
	}
}
