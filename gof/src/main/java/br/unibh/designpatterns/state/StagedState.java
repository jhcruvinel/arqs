package br.unibh.designpatterns.state;

public class StagedState extends State {
	
	public StagedState() {}

	
	public void stage(Context context) {
		// does nothing!
	}

	
	public void unstage(Context context) {
		removeFromIndex(context.getName());
		//next stage is: UnversionedState
		context.setState("unversioned");
	}

	
	public void commit(Context context) {
		send(context.getName());
		//next stage is: CommittedState
		context.setState("committed");		
	}
	
	private void removeFromIndex(String name){
		System.out.println("Document "+ name + " removed from index");
	}
	
	private void send(String name){
		System.out.println("Computing checksum for document " + name + "...");
		System.out.println(Integer.toString(name.hashCode()));
		System.out.println("Document " + name + " committed");
	}
}
