package br.unibh.designpatterns.interpreter;

public class NotExpression implements AbstractExpression {

	AbstractExpression operand;
	
	public NotExpression(AbstractExpression operand) {
		this.operand = operand;
	}
	
	
	public boolean interpret(Context context) {
		return !operand.interpret(context);
	}
}
