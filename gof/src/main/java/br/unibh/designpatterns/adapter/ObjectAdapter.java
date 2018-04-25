package br.unibh.designpatterns.adapter;

import java.util.Arrays;
import java.util.List;

/**
 * This is the Adapter class: it implements the TargetInterface that is expected
 * by the clients and is composed of an Adaptee object instance. In this case, 
 * adaptation is achieved through composition.
 */
public class ObjectAdapter implements TargetInterface {
	
	private Adaptee adaptee;
	
	public ObjectAdapter(Adaptee adaptee){
		this.adaptee = adaptee;
	}

	
	public List<Double> getOperands() {
		return Arrays.asList(this.adaptee.getFirstOperand(), 
							this.adaptee.getSecondOperand());
	}

	
	public double sum() {
		return this.adaptee.computeSum();
	}

	
	public double multiply() {
		return this.adaptee.getFirstOperand()*this.adaptee.getSecondOperand();
	}

	
	public double max() {
		return this.adaptee.max();
	}
}
