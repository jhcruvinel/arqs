package br.unibh.designpatterns.interpreter;

public class ConstantExpression implements AbstractExpression {

	private boolean value;
	
	public ConstantExpression(boolean value) {
		this.value = value;
	}
	
	
	public boolean interpret(Context context) {
		return value;
	}	
}
