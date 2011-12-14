package Sudoku;

import java.util.ArrayList;
import java.util.Scanner;

public class Sudoku {
	public static void main(String[] args){
		int[][] grid=new int[9][9];
		grid=getinput();
		for (int i = 0; i < 5; i++) {
			Scanner scanner=new Scanner(System.in);
			String number=scanner.nextLine();
			int row=Integer.valueOf(number);
			int[] missingNumbers=findMissingNumbers(grid, row);
		}
		
	}
	
	public static int[][] getinput(){
		Scanner scanner=new Scanner(System.in);
		int[][] blah=new int[9][9];
		for(int i=0; i<9;i++){
			String temp=scanner.nextLine();
			String[] input=temp.split(",");
			for(int j=0;j<9;j++){
				blah[i][j]=Integer.valueOf(input[j]);
			}
		}
		scanner=null;
		return blah;
	}
	
	public static int[] findMissingNumbers(int[][] grid, int row){
		int[] fullset=new int[9];
		for (int i = 0; i < fullset.length; i++) {
			fullset[i]=1+i;
		}
		int[] rownumbers=new int[9];
		for (int i = 0; i < rownumbers.length; i++) {
			rownumbers[i]=grid[row-1][i];
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(rownumbers[i]==fullset[j]){
					int[] temp=new int[fullset.length-1];
					for(int a=0; a<j;a++){
						temp[a]=fullset[a];
					}
					for(int a=j+1; a<fullset.length-1; a++){
						temp[a]=fullset[a];
					}
					fullset=temp;
				}
			}
		}
		return fullset;
	}
	
	public static int[] findSpaces(int[][] grid, int row){
		ArrayList<Integer> spaces=new ArrayList<Integer>();
		for (int i = 0; i < grid.length; i++) {
			if (grid[row][i]==0) {
				spaces.add(i);
			}
		}
		int[] space=new int[spaces.size()];
		for (int i = 0; i < spaces.size(); i++) {
			space[i]=spaces.get(i);
		}
		return space;
	}
	
	public static int whatBox(int[][] grid, )
	
	public static boolean checkBox(int[][] grid, int number, int gridrow, int gridcolumn){
		
	}
	
	public static boolean checkColumn(int[][] grid, int number, int gridcolumn){
		for (int i = 0; i < grid.length; i++) {
			if (number==grid[i][gridcolumn]) {
				return true;
			}
		}return false;
	}
	
	public static boolean isFull(int[][] grid, int row){
		int sum=0;
		for (int i = 0; i < grid.length; i++) {
			sum+=grid[row][i];
			}
		if (sum==45) {
			return true;
		}else return false;
	}
}

