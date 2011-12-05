package DijkstraPathFinding;

import java.util.*;

public class Algorithm {
	protected final ArrayList<Vertex> nodesList;
	protected final ArrayList<Edge> edgesList;
	protected HashSet<Vertex> settledNodeSet;
	protected HashSet<Vertex> unSettledNodeSet;
	protected HashMap<Vertex, Vertex> predecessors;
	protected HashMap<Vertex, Integer> distance;

	//Constructor
	public Algorithm(Graph graph){
		nodesList=new ArrayList<Vertex>(graph.getVertexes());
		edgesList=new ArrayList<Edge>(graph.getEdges());
	}
	
	
	//Main part of the algorithm
	public void Calcucate(Vertex source){
		settledNodeSet=new HashSet<Vertex>();
		unSettledNodeSet=new HashSet<Vertex>();
		distance=new HashMap<Vertex, Integer>();
		predecessors=new HashMap<Vertex, Vertex>();
		distance.put(source, 0);
		unSettledNodeSet.add(source);
		while(unSettledNodeSet.size()>0){
			Vertex node=getMinimum(unSettledNodeSet);
			settledNodeSet.add(node);
			unSettledNodeSet.remove(node);
			findMinimalDistances(node);
		}
	}
	
	
	//Goes through all the vertexes and returns the smallest distanced
	protected Vertex getMinimum(HashSet<Vertex> vertexes) {
		Vertex minimum = null;
		for (Vertex vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}
	
	//Returns the distance between the current node and the target node
		protected int getDistance(Vertex node, Vertex target) {
			for (Edge edge : edgesList) {
				if (edge.getsourceVertex().equals(node)
						&& edge.getdestinationVertex().equals(target)) {
					return edge.getweight();
				}
			}
			//Return here will only happen if no path
			System.out.println("No Path");
			return 0;
		}
		
		
	//Takes the list of neighbors and  find the minimum point
	protected void findMinimalDistances(Vertex node){
		ArrayList<Vertex> adjacentNodesList=getNeighbors(node);
		for(Vertex target: adjacentNodesList){
			if(getShortestDistance(target)>getShortestDistance(node)+getDistance(node, target)){
				distance.put(target, getShortestDistance(node)+getDistance(node, target));
				predecessors.put(target, node);
				unSettledNodeSet.add(target);
			}
		}
	}
	
	
	
	
	//Find the distance, if the vertex doesn't touch return infinite
		protected int getShortestDistance(Vertex destination) {
			Integer d = distance.get(destination);
			
			if (d == null) {
				return Integer.MAX_VALUE;
			} else {
				return d;
			}
		}
	
	//Goes through all the Edges, and checks that a point around it isn't already settled
	protected ArrayList<Vertex> getNeighbors(Vertex node) {
		ArrayList<Vertex> neighbors = new ArrayList<Vertex>();
		for (Edge edge : edgesList) {
			if (edge.getsourceVertex().equals(node)
					&& !isSettled(edge.getdestinationVertex())) {
				neighbors.add(edge.getdestinationVertex());
			}
		}
		return neighbors;
	}
	
	
	//Returns if the point has already been processed
	protected boolean isSettled(Vertex vertex) {
		return settledNodeSet.contains(vertex);
	}
	
	
	
	
	
	//Gets the path from the list of predecessors
	public ArrayList<Vertex> getPath(Vertex target) {
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		Vertex step = target;
		// Check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		//If the path exists goes through the predecessors to get path
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		//Flips it so its in the right order
		Collections.reverse(path);
		return path;
	}
}
