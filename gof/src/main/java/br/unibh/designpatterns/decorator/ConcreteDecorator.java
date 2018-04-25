package br.unibh.designpatterns.decorator;

/**
 * This concrete decorator adds further state and responsibilities to the
 * decorated component
 */
public class ConcreteDecorator extends AbstractDecorator {
	
	private String job;

	public ConcreteDecorator(AbstractComponent decorated, String job) {
		super(decorated);
		this.job = job;
	}
	
	/**
	 * Implement abstract behaviour stated in AbstractDecorator
	 */
	
	public String getJob(){
		return this.job;
	}
	
	//The remaining behaviour is inherited as-is from the component's abstract 
	//interface

}
