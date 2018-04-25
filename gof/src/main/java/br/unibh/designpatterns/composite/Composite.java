package br.unibh.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents components having children
 */
public class Composite extends Component {
	
	private List<Component> children;
	
	public Composite(int value, Component father){
		this.value = value;
		this.father = father;
		this.children = new ArrayList<Component>();
	}

	
	public int getSubtreeSum() {
		int sum = value;
		for (Component child : children) {
			sum += child.getSubtreeSum();
		}
		return sum;
	}

	
	public void addChild(Component child) throws UnsupportedOperationException {
		children.add(child);
	}

	
	public void removeChild(Component child)
			throws UnsupportedOperationException {
		children.remove(child);
	}

	
	public List<Component> getChildren() {
		return new ArrayList<Component>(children);
	}
}
