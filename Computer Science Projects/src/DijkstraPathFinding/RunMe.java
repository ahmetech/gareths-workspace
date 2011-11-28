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
	protected static ArrayList<String> input;
	protected static char startPos;
	protected static char finalPos;
	
	public static void main(){
		nodesList=new ArrayList<Vertex>();
		edgesList=new ArrayList<Edge>();
		input=getInput();
		for (int i = 0; i < numofnodes; i++) {
			
			Vertex temp=new Vertex(, name);
		}
		
		
		
		Graph graph = new Graph(nodesList, edgesList);
		Algorithm dijkstra = new Algorithm(graph);
		dijkstra.Calcucate(startPos);
		LinkedList<Vertex> path = dijkstra.getPath(finalPos);
		
	}
	
	//Gets the input
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
	
	//Takes the input and organizes it into the Graph
		public static void organizeInput(ArrayList<String> input, int[][] map){
			for(int i=1; i<input.size(); i++){
				String thing=input.get(i).substring(0, 1);
				char blah=thing.charAt(0);
				int point1=blah-65;
				String thing2=input.get(i).substring(2, 3);
				char blah2=thing2.charAt(0);
				int point2=blah2-65;
				map[point1][point2]=Integer.valueOf(input.get(i).substring(1, 2));
				map[point2][point1]=Integer.valueOf(input.get(i).substring(1, 2));
			}
		}
}
