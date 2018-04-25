package br.unibh.designpatterns.factorymethod;

/**
 * 
 * Concrete implementation of products interface. Modify it in order to 
 * instantiate your own ones!
 * 
 */
public class ConcreteProduct implements AbstractProduct {
	
	public ConcreteProduct(){
		System.out.println("Created: concrete product instance");		
	}
	
	
	public void feature() {
		System.out.println("Called: concrete product feature");
	}
}
