package DijkstraPathFinding;

import java.util.List;

public class Graph {
	protected final List<Vertex> vertexes;
	protected final List<Edge> edges;
	
	//Constructor
	public Graph(List<Vertex> vertexs, List<Edge> edges){
		vertexes=vertexs;
		this.edges=edges;
	}
	
	//Getters
	public List<Vertex> getVertexes(){
		return vertexes;
	}
	
	public List<Edge> getEdges(){
		return edges;
	}
}
