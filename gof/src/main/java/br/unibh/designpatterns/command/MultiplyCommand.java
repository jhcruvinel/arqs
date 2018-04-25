package br.unibh.designpatterns.command;

/**
 * Concrete implementation for Command, realizing a multiplication. 
 */
public class MultiplyCommand implements Command {
	
	private Multiplier multiplier;
	
	public MultiplyCommand(Multiplier multiplier){
		this.multiplier = multiplier;
	}

	
	public int execute(int number) {
		return multiplier.times(number);
	}
}
