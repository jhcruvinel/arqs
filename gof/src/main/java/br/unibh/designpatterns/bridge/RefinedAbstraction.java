package br.unibh.designpatterns.bridge;

/**
 * This is a subclass of Abstraction. Please notice that the abstract methods 
 * stated by Abstract are implemented using the base operations provided by
 * the encapsulated Implementor object 
 */
public class RefinedAbstraction extends Abstraction {
	
	private Implementor implementor;
	
	public RefinedAbstraction() {
		this.implementor = new ConcreteImplementor("Sarah");
	}
	
	public RefinedAbstraction(Implementor implementor) {
		this.implementor = implementor;
	}
	
	public void setImplementor(Implementor implementor){
		this.implementor = implementor;
	}

	
	public void greet() {
		implementor.openMouth();
		String name = implementor.tellName();
		System.out.println("Hello my name is "+name);
	}
}
