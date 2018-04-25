package br.unibh.designpatterns.observer;

/**
 * This is the abstract interface for updating objects that are interested to
 * changes in the state of a Subject 
 */
public interface Observer {
	
	public void update(Subject subject);
}
