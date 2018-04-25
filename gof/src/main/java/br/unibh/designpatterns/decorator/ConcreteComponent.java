package br.unibh.designpatterns.decorator;

/**
 * Concrete implementation for AbstractComponent interface
 */
public class ConcreteComponent implements AbstractComponent {
	
	private String name;
	private int age;
	
	public ConcreteComponent(String name, int age){
		this.name = name;
		this.age = age;
	}

	
	public String getName() {
		return this.name;
	}

	
	public int getAge() {
		return this.age;
	}
}
