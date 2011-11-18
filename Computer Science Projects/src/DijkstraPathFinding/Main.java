package DijkstraPathFinding;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int numofnodes;
	public static String path;
	public static int[][] grid;
	public static void main(String Args[]){
		ArrayList<String> input=new ArrayList<String>();
		input=getInput();
		grid=new int[numofnodes][numofnodes];
		fillgrid(grid);
		organizeInput(input, grid);
		printthegrid(grid);
	}
	public static ArrayList getInput(){
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
				thing=false;
			}
		}
		return input2;
	}
	public static void fillgrid(int[][] grid){
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				grid[i][j]=-1;
			}
		}
	}
	public static void organizeInput(ArrayList<String> input, int[][] grid){
		for(int i=1; i<input.size(); i++){
			System.out.println(input.get(i));
			String thing=input.get(i).substring(0, 1);
			char blah=thing.charAt(0);
			int point1=blah-65;
			String thing2=input.get(i).substring(2, 3);
			char blah2=thing2.charAt(0);
			int point2=blah2-65;
			System.out.println(Integer.valueOf(input.get(i).substring(1, 2)));
			grid[point1][point2]=Integer.valueOf(input.get(i).substring(1, 2));
		}
	}
	public static void printthegrid(int[][] grid){
		for(int i=0; i<grid.length; i++){
			System.out.println("");
			for(int j=0; j<grid[i].length; j++){
				System.out.println(grid[i][j]);
			}
		}
	}
}
