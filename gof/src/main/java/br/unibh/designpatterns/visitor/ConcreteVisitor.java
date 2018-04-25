package br.unibh.designpatterns.visitor;

import java.util.Collection;
import java.util.Iterator;

public class ConcreteVisitor implements Visitor {

	
	public void visit(ConcreteElementA concreteElementA) {
		System.out.println(concreteElementA.getString());
	}
	
	
	public void visit(ConcreteElementB concreteElementB) {
		System.out.println(Double.toString(concreteElementB.getDouble()));
	}

	
	public void visit(ConcreteElementC concreteElementC) {
		System.out.println("["+concreteElementC.getBoxLabel()+"-"+
				Integer.toString(concreteElementC.getBoxNumber())+"]");
	}

	
	public void visit(Collection collection) {
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			if(object instanceof Element){
				System.out.println("Found: Element, will be visited");
				((Element)object).accept(this);
			}
			else if (object instanceof Collection){
				System.out.println("Found: Collection, will be visited");
				visit((Collection<Element>)object);
			}
		}
	}
}
