package br.unibh.designpatterns.visitor;

public class Box {
	
	private String label;
	private int number;
	
	public Box(String label, int number) {
		this.label = label;
		this.number = number;
	}
	
	public String getLabel() {
		return label;
	}

	public int getNumber() {
		return number;
	}

	
	public String toString(){
		return "[" + label + " - " + Integer.toString(number) + "]";
	}
}
