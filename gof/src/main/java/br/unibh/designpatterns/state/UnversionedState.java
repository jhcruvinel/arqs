package br.unibh.designpatterns.state;

public class UnversionedState extends State {
	
	public UnversionedState() {}

	
	public void stage(Context context) {
		addToIndex(context.getName());
		//next stage is: StagedState
		context.setState("staged");
	}

	
	public void unstage(Context context) {
		// does nothing!
	}

	
	public void commit(Context context) {
		// does nothing!
	}
	
	private void addToIndex(String name){
		System.out.println("Document "+ name + " added to index");
	}
}
