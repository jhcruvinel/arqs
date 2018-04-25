package br.unibh.designpatterns.bridge;

/**
 * This abstract interface is the root of the implementation hierarchy
 */
public interface Implementor {
	
	public void openMouth();
	
	public String tellName();
}
