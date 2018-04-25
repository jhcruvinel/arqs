package br.unibh.designpatterns.facade;

/**
 * Concrete implementation of AbstractSubsystemModule1
 */
public class SubsystemClass1 implements AbstractSubsystemModule1 {
	
	private String name;
	private int yearOfBirth;
	
	public SubsystemClass1(String name, int yearOfBirth) {
		super();
		this.name = name;
		this.yearOfBirth = yearOfBirth;
	}

	
	public String getName() {
		return this.name;
	}

	
	public int getYearOfBirth() {
		return this.yearOfBirth;
	}
}
