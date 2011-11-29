package DijkstraPathFinding;

public class Vertex {
	final protected String idString;
	final protected String nameString;
	
	//Constructor
	public Vertex(String id, String name){
		idString=id;
		nameString=name;
	}
	
	//Getters
	public String getidString(){
		return idString;
	}
	public String getnameString(){
		return nameString;
	}
	
	
	//Converters
	public String toString(){
		return nameString;
	}
	
}
