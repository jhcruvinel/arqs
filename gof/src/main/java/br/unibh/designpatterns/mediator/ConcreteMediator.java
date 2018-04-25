package br.unibh.designpatterns.mediator;

import java.util.List;

public class ConcreteMediator implements Mediator {
	
	private List<Colleague> team;
	private List<Colleague> all;
	public ConcreteMediator(List<Colleague> team, List<Colleague> all) {
		this.team = team;
		this.all = all;
	}
	
	
	public void teamGreet() {
		System.out.println("Mediator will ask team members to greet");
		for (Colleague colleague : team) {
			colleague.teamGreet();
		}
	}
	
	
	public void broadcastGreet() {
		System.out.println("Mediator will ask everyone to greet");
		for (Colleague colleague : all) {
			colleague.greet();
		}
	}
}
