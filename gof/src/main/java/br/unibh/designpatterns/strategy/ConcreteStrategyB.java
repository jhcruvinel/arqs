package br.unibh.designpatterns.strategy;

import java.util.List;

/**
 * Concrete Strategy implementation
 */
public class ConcreteStrategyB implements Strategy {

	/**
	 * This method implements its own minimum search method
	 */
	
	public int findMinimum(List<Integer> numbers) {
		int minimum = numbers.get(0);
		for (Integer number : numbers) {
			if(number < minimum){
				minimum = number;
			}
		}
		return minimum;
	}
}
