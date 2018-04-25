package br.unibh.designpatterns.mediator;

public class ConcreteColleagueC extends Colleague {
	
	public ConcreteColleagueC(String name, Mediator mediator){
		this.name = name;
		this.mediator = mediator;
	}
	
}
