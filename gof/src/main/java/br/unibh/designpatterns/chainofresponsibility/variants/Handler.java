package br.unibh.designpatterns.chainofresponsibility.variants;

import br.unibh.designpatterns.chainofresponsibility.variants.Handler;

public abstract class Handler {

	protected Handler successor;
	
	public void setSuccessor(Handler handler){
		this.successor = handler;
	}
	
	public abstract void handleRequest(Request request);
}
