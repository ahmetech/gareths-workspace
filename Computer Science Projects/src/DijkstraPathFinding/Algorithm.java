package DijkstraPathFinding;

import java.util.*;

public class Algorithm {
	protected final List<Vertex> nodesList;
	protected final List<Edge> edgesList;
	protected Set<Vertex> settledNodeSet;
	protected Set<Vertex> unSettledNodeSet;
	protected Map<Vertex, Vertex> predecessors;
	protected Map<Vertex, Integer> distance;
	
	//Constructor
	public Algorithm(Graph graph){
		nodesList=new ArrayList<Vertex>(graph.getVertexes());
		edgesList=new ArrayList<Edge>(graph.getEdges());
	}
	
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
	
	protected void findMinimalDistances(Vertex node){
		List<Vertex> adjacentNodesList=getNeighbors(node);
		for(Vertex target: adjacentNodesList){
			if(getShortestDistance(target)>getShortestDistance(node)+getDistance(node, target)){
				distance.put(target, getShortestDistance(node)+getDistance(node, target));
				predecessors.put(target, node);
				unSettledNodeSet.add(target);
			}
		}
	}
	private int getDistance(Vertex node, Vertex target) {
		for (Edge edge : edgesList) {
			if (edge.getsourceVertex().equals(node)
					&& edge.getdestinationVertex().equals(target)) {
				return edge.getweight();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<Vertex> getNeighbors(Vertex node) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		for (Edge edge : edgesList) {
			if (edge.getsourceVertex().equals(node)
					&& !isSettled(edge.getdestinationVertex())) {
				neighbors.add(edge.getdestinationVertex());
			}
		}
		return neighbors;
	}

	private Vertex getMinimum(Set<Vertex> vertexes) {
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

	private boolean isSettled(Vertex vertex) {
		return settledNodeSet.contains(vertex);
	}

	private int getShortestDistance(Vertex destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	public LinkedList<Vertex> getPath(Vertex target) {
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		// Check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		Collections.reverse(path);
		return path;
	}
}
