package Sudoku;

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
}
