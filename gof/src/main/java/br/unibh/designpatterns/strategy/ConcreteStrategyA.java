package br.unibh.designpatterns.strategy;

import java.util.Collections;
import java.util.List;

/**
 * Concrete Strategy implementation
 */
public class ConcreteStrategyA implements Strategy {

	/**
	 * This method relies on the SDK's minimum search for collections 
	 */
	
	public int findMinimum(List<Integer> numbers) {
		return Collections.min(numbers);
	}
}
