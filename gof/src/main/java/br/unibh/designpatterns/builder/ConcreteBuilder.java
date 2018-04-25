package br.unibh.designpatterns.builder;

import br.unibh.designpatterns.builder.AbstractBuilder;

/**
 * 
 * Concrete implementation for AbstractBuilder. Please notice that this class
 * also offers a method for returning the whole, newly-created product
 *
 */
public class ConcreteBuilder implements AbstractBuilder {
	
	private Product product;
	
	public ConcreteBuilder(){
		this.product = new Product();
	}

	
	public void buildPartA() {
		System.out.println("Building of part A of complex object");
		this.product.addPartA("I am a complex object");
	}

	
	public void buildPartB() {
		System.out.println("Building of part B of complex object");
		this.product.addPartB(1234);
	}
	
	
	public Product getProduct(){
		System.out.println("Created: new Product instance");
		return this.product;
	}
}
