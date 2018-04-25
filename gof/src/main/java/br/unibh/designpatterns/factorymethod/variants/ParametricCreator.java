package br.unibh.designpatterns.factorymethod.variants;

import br.unibh.designpatterns.factorymethod.AbstractProduct;
import br.unibh.designpatterns.factorymethod.ConcreteProduct;

/**
 * 
 * This concrete class is an alternative to the usage of the hierarchy: abstract 
 * creator class + concrete creator class. The parameter value triggers which 
 * AbstractProduct subclass is instantiated by the factory method.
 * Subclasses may owerwrite the factory method in order to add additional checks
 * on the parameter value or modify the existing ones.
 *
 */
public class ParametricCreator {
	
	/**
	 * The parametric factory method. Modify it as needed!
	 * @param parameter
	 * @return Abstract
	 */
	public AbstractProduct factoryMethod(String parameter){
		if(parameter == "ConcreteProduct"){
			System.out.println("Called: parametric creator; "
					+ "will return: ConcreteProduct instance");
			return new ConcreteProduct();
		}
		// Remove the 'else' clause and add your code here
		else{
			throw new RuntimeException("Invalid parameter value");
		}
	}

}
