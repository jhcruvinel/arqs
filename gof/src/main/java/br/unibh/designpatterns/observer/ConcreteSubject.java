package br.unibh.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation for Subject tracking down the related Observer objects
 * into a list.
 */
public class ConcreteSubject implements Subject {
	
	List<Observer> observers;
	
	private String job;
	private double salary;

	public ConcreteSubject(String job, double salary) {
		this.job = job;
		this.salary = salary;
		this.observers = new ArrayList<Observer>();
	}

	
	public void attach(Observer observer) {
		observers.add(observer);
	}

	
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

	
	public String getJob() {
		return this.job;
	}
	
	
	public void setJob(String newJob){
		System.out.println("Yuppydoo! I've got a new job: " + newJob);
		this.job = newJob;
		notifyObservers();
	}

	
	public double getSalary() {
		return this.salary;
	}
	
	
	public void setSalary(double newSalary){
		System.out.println("Yuppydoo! I've got a new salary: " + newSalary);
		this.salary = newSalary;
		notifyObservers();
	}
}
