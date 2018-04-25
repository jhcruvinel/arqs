package br.unibh.designpatterns.visitor;

public class ConcreteElementA implements Element {
	
	private String string;

	public ConcreteElementA(String string) {
		this.string = string;
	}

	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public String getString(){
		return string;
	}
}
