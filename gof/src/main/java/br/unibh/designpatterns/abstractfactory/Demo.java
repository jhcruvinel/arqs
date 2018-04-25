package br.unibh.designpatterns.abstractfactory;

import br.unibh.designpatterns.abstractfactory.AbstractProductX;
import br.unibh.designpatterns.abstractfactory.AbstractProductY;
import br.unibh.designpatterns.abstractfactory.AbstractFactory;
import br.unibh.designpatterns.abstractfactory.ConcreteFactory;

public class Demo {

	public static void main(String[] args) {
		System.out.println("***Demo: abstract factory pattern");
		AbstractFactory factory1 = new ConcreteFactory();
		AbstractProductX productX1 = factory1.createProductX();
		productX1.feature();
		AbstractProductY productY1 = factory1.createProductY();
		productY1.feature();
		
		System.out.println("");
		
		System.out.println("***Demo: adding a new AbstractFactory implementation");
		
		//New implementation for AbstractFactory class, returning new implementations
		//for AbstractProductX and AbstractProductY
		AbstractFactory factory2 = new AbstractFactory() {
			
			public AbstractProductX createProductX() {
				System.out.println("Called: my implementation of abstract factory; "
						+ "will return: myConcreteProductX instance");
				return new AbstractProductX() {
					
					public void feature() {
						System.out.println("Called: feature of myConcreteProductX");
					}
				};
			}
			
			
			public AbstractProductY createProductY() {
				System.out.println("Called: my implementation of abstract factory; "
						+ "will return: myConcreteProductY instance");
				return new AbstractProductY() {
					
					public void feature() {
						System.out.println("Called: feature of myConcreteProductY");
					}
				};
			}
		};
		
		AbstractProductX productX2 = factory2.createProductX();
		AbstractProductY productY2 = factory2.createProductY();
		productX2.feature();
		productY2.feature();
	}
}
