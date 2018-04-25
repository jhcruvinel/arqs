package br.unibh.designpatterns.memento.variants;

/**
 * This abstract interface defines the state restore operation to be used by
 * Caretakers
 */
public interface Memento {
	
	public void restoreState();
}
