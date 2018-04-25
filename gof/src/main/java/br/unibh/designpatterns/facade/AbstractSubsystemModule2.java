package br.unibh.designpatterns.facade;

/**
 * This interface states the behaviour of one of the modules of the subsystem
 * Modify as needed!
 */
public interface AbstractSubsystemModule2 {
		
	public int computeAge(AbstractSubsystemModule1 module, int currentYear);
}
