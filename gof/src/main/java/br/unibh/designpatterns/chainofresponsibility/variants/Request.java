package br.unibh.designpatterns.chainofresponsibility.variants;

import java.util.List;

public abstract class Request {
	
	public abstract List<String> getParameters();
}
