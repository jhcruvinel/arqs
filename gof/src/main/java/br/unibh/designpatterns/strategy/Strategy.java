package br.unibh.designpatterns.strategy;

import java.util.List;

/**
 * Abstract interface defining the algorithmic strategy
 */
public interface Strategy {
	
	public int findMinimum(List<Integer> numbers);
	
}
