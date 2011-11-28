package DijkstraPathFinding;

public class Edge {
	final protected String idString;
	final protected Vertex sourceVertex;
	final protected Vertex destinationVertex;
	final protected int weight;
	
	//Constructor
	public Edge(String id, Vertex source, Vertex destination, int weight){
		idString=id;
		sourceVertex=source;
		destinationVertex=destination;
		this.weight=weight;
	}
	
	
	//Getters
	public String getidString(){
		return idString;
	}
	
	public Vertex getsourceVertex(){
		return sourceVertex;
	}
	
	public Vertex getdestinationVertex(){
		return destinationVertex;
	}
	public int getweight(){
		return weight;
	}
	
	
	
	public String toString(){
		return sourceVertex+ " "+ destinationVertex;
	}
	
}
