package br.unibh.designpatterns.factorymethod;

import br.unibh.designpatterns.factorymethod.AbstractCreator;
import br.unibh.designpatterns.factorymethod.ConcreteCreator;

public class Demo {

	public static void main(String[] args) {
		System.out.println("***Demo: factory method pattern");
		AbstractCreator factory = new ConcreteCreator();
		AbstractProduct product = factory.factoryMethod();
		product.feature();
	}

}
