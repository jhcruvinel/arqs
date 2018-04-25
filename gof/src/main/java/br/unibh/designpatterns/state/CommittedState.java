package br.unibh.designpatterns.state;

public class CommittedState extends State {

	public CommittedState() {}
	
	
	public void stage(Context context) {
		// does nothing!		
	}

	
	public void unstage(Context context) {
		removeFromRepository(context.getName());
		//next stage is: UnversionedState
		context.setState("unversioned");	
	}

	
	public void commit(Context context) {
		// does nothing!
	}
	
	private void removeFromRepository(String name){
		System.out.println("Document "+ name + " removed from repository");
	}
}
