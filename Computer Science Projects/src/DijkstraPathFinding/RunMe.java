package DijkstraPathFinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RunMe {
	protected static List<Vertex> nodesList;
	protected static List<Edge> edgesList;
	protected static int numofnodes;
	protected static String path;
	protected static char startPos;
	protected static char finalPos;
	
	public static void main(){
		nodesList=new ArrayList<Vertex>();
		edgesList=new ArrayList<Edge>();
		for (int i = 0; i < numofnodes; i++) {
			Vertex temp=new Vertex(id, name)
		}
		
		
		
		Graph graph = new Graph(nodes, edgesList);
		Algorithm dijkstra = new Algorithm(graph);
		dijkstra.Calcucate(startPos);
		LinkedList<Vertex> path = dijkstra.getPath(finalPos);
		
	}
	
	
	public static ArrayList<String> getInput(){
		Scanner iScanner=new Scanner(System.in);
		ArrayList<String> input2=new ArrayList<String>();
		numofnodes=iScanner.nextInt();
		boolean thing=true;
		while(thing){
			String temp=iScanner.nextLine();
			if(!(temp.length()==2)){
				input2.add(temp);
			}else {
				path=temp;
				startPos=path.substring(0, 1).charAt(0);
				finalPos=path.substring(1, 2).charAt(0);
				thing=false;
			}
		}
		return input2;
	}
}
