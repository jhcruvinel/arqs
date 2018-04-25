package br.unibh.designpatterns.visitor;

import java.util.Collection;

public interface Visitor {
	
	public void visit(Collection collection); 
	
	public void visit(ConcreteElementA concreteElementA);
	
	public void visit(ConcreteElementB concreteElementB);
	
	public void visit(ConcreteElementC concreteElementC);
}
