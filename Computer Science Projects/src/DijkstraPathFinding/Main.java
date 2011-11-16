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
	public void 
}
