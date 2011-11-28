package DijkstraPathFinding;

import java.util.ArrayList;
import java.util.Scanner;
/*
public class Main {
	public static int numofnodes;
	public static String path;
	public static int[][] map;
	public static int[][] distances;
	public static char startPos;
	public static char currentPos;
	public static char finalPos;
	public static int totalDistance;
	public static ArrayList<String> possiblePath;
	public static ArrayList<Character> visited;
	public static ArrayList<Character> unVisited;
	
	public static void main(String Args[]){
		ArrayList<String> input=new ArrayList<String>();
		input=getInput();
		map=new int[numofnodes][numofnodes];
		fillgrid(map);
		organizeInput(input, map);
		MakeunVisited(unVisited, numofnodes);
	}
	
	
	//Takes the input from the user
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
	
	
	
	//Takes the input and organizes it into map
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
	
	
	//Initializes the unVisited ArrayList, with all points but the startPos
	public static void MakeunVisited(ArrayList<Character> unVisited, int numofnodes){
		unVisited=new ArrayList<Character>();
		for (int i = 0; i < numofnodes; i++) {
			unVisited.add((char) (i+65));
		}
		for (int i = 0; i < unVisited.size(); i++) {
			if(unVisited.get(i).equals(startPos)){
				unVisited.remove(i);
			}
		}
	}
	
	
	//Use this in order to print the Map Coordinates
	public static void printthegrid(int[][] map){
		for(int i=0; i<map.length; i++){
			System.out.println("");
			for(int j=0; j<map[i].length; j++){
				System.out.print(map[i][j]+ " ");
			}
		}
	}

	
	//Checks to see if currentPos touches finalPos
	public static Boolean doesItTouch(int[][] map){
		for (int i = 0; i < map.length; i++) {
			if (map[(currentPos-65)][i]==map[currentPos-65][finalPos-65]) {
				return true;
			}
		}return false;
	}







}
*/
