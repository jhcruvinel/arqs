package br.unibh.designpatterns.adapter;

import java.util.Arrays;
import java.util.List;
import br.unibh.designpatterns.adapter.Adaptee;

/**
 * This is the Adapter class: it subclasses the Adaptee and also implements
 * the TargetInterface that is expected by the clients. In this case, adaptation
 * is achieved through inheritance.
 */
public class ClassAdapter extends Adaptee implements TargetInterface {

	public ClassAdapter(double operand1, double operand2) {
		super(operand1, operand2);
	}

	
	public List<Double> getOperands(){
		return Arrays.asList(super.getFirstOperand(), super.getSecondOperand());
	}

	
	public double sum() {
		return super.computeSum();
	}

	
	public double multiply() {
		return super.getFirstOperand()*super.getSecondOperand();
	}
	
	//No need to implement the TargetInterface.max() as it is already implemented
	//by the inherited Adaptee.max() method
}
