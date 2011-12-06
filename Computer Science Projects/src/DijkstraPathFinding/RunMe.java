package DijkstraPathFinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RunMe {
	static int numofnodes;
	static char startPos;
	static char finalPos;
	public static void main(String[] args){
		ArrayList<Vertex> nodesList;
		ArrayList<Edge> edgesList;
		ArrayList<String> input;
		Vertex source = null;
		Vertex destination = null;
		nodesList=new ArrayList<Vertex>();
		edgesList=new ArrayList<Edge>();
		input=getInput();
		for (int i = 0; i < numofnodes; i++) {
			String blah=""+i;
			Vertex temp=new Vertex(blah, blah);
			nodesList.add(temp);
		}
		organizeInput(input, edgesList, nodesList);


		//Finds and sets the source and destination vertexes
		for(int i=0; i<nodesList.size(); i++){
			int check=Integer.valueOf(nodesList.get(i).getnameString());
			int checkpoint=startPos-65;
			int checkend=finalPos-65;
			if(check==checkpoint){
				source=nodesList.get(i);
			}
			if(check==checkend){
				destination=nodesList.get(i);
			}
		}

		//Where I integrate the algorithm
		Graph graph = new Graph(nodesList, edgesList);
		Algorithm mainpart = new Algorithm(graph);
		mainpart.Calcucate(source);
		ArrayList<Vertex> pathList = mainpart.getPath(destination);



		//Prints the path of minimum value
		Vertex previous=new Vertex("temp", "temp");
		int previousbasenum=0;
		boolean first=true;
		int totalvalue=0;
		for (int i=0; i<pathList.size(); i++) {
			int basenum= Integer.valueOf(pathList.get(i).getnameString());
			boolean flip=true;
			String blah="A";
			char letter=blah.charAt(0);
			while (flip) {
				if (letter-65==basenum) {
					flip=false;
				}else letter++;
			}
			while(first){
				System.out.print(letter);
				first=false;
			}
			previous=pathList.get(i);
			int value=0;
			if (i==0) {
				previousbasenum=basenum;
			}
			if(i>0){
				for(Edge edge:edgesList){
					int sourcenum=Integer.valueOf(edge.getsourceVertex().getidString());
					int destinationnum=Integer.valueOf(edge.getdestinationVertex().getidString());
					if (sourcenum==previousbasenum&&destinationnum==basenum) {
						value=edge.getweight();
						totalvalue+=value;
						previousbasenum=basenum;
					}
				}
				System.out.print(value+""+letter);
				if(i==pathList.size()-1){
					System.out.print(" "+"Total Distance:"+totalvalue);
				}
			}
		}
	}  

	//Gets the input
	public static ArrayList<String> getInput(){
		Scanner iScanner=new Scanner(System.in);
		ArrayList<String> input2=new ArrayList<String>();
		String path;
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
	public static void organizeInput(ArrayList<String> input, List<Edge> edgesList, List<Vertex> nodesList){
		for(int i=1; i<input.size(); i++){
			String thing=input.get(i).substring(0, 1);
			char blah=thing.charAt(0);
			int point1=blah-65;
			String thing2=input.get(i).substring(2, 3);
			char blah2=thing2.charAt(0);
			int point2=blah2-65;
			int weight=Integer.valueOf(input.get(i).substring(1, 2));
			edgesList.add(new Edge("edge_"+i, nodesList.get(point1), nodesList.get(point2), weight));
		}
	}
}
