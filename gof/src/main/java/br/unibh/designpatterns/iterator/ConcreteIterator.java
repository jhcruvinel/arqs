package br.unibh.designpatterns.iterator;

public class ConcreteIterator implements Iterator {
	
	private ConcreteAggregate iterable;
	private int currentIndex;

	public ConcreteIterator(ConcreteAggregate iterable) {
		this.iterable = iterable;
		currentIndex = 0;
	}

	
	public Object first() {
		return iterable.getPlaceAtPosition(0);
	}

	
	public Object next() {
		Place result = iterable.getPlaceAtPosition(currentIndex);
		currentIndex++;
		return result;
	}

	
	public boolean hasMore() {
		Object item = iterable.getPlaceAtPosition(currentIndex);
		if(item == null){
			return false;
		}
		return true;
	}
}
