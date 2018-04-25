package br.unibh.designpatterns.flyweight;

/**
 * Concrete implementation for AbstractFlyweight
 */
public class ConcreteFlyweight extends AbstractFlyweight {
	
	private String sharedState;
	
	public ConcreteFlyweight(String sharedState){
		this.sharedState = sharedState;
	}

	
	public void greet(String externalState) {
		System.out.println("Hello I am a flyweight, my internal state is: "
				+this.getSharedState()+" and my external state is: "
				+externalState);
	}

	
	public String getSharedState() {
		return this.sharedState;
	}
}
