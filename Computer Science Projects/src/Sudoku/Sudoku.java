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
			int[] missingPlaces=findSpaces(grid, row);
			
			
			
			
			
			if(isFull(grid, row)){
				for (int j = 0; j < grid.length; j++) {
					System.out.println(grid[row][j]);
				}
			}
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
	
	public static int findBox(int[][] grid, int row, int place){
		if(row<3&&place<3){
			return 1;
		}
		if(row<3&&(place>2&&place<6)){
			return 2;
		}
		if(row<3&&(place>5&&place<9)){
			return 3;
		}
		if((row>2&&row<6)&&place<3){
			return 4;
		}
		if((row>2&&row<6)&&(place>2&&place<6)){
			return 5;
		}
		if((row>2&&row<6)&&(place>5&&place<9)){
			return 6;
		}
		if((row>5&&row<9)&&place<3){
			return 7;
		}
		if((row>5&&row<9)&&(place>2&&place<6)){
			return 8;
		}
		if((row>5&&row<9)&&(place>5&&place<9)){
			return 9;
		}return 0;
	}
	
	public static int[] stuffInBox(int[][] grid, int box){
		int[] stuff=new int[9];
		int placeholder=0;
		if(box==1){
			for(int i=0; i<3; i++){
				for(int j=0; i<3;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==2){
			for(int i=0; i<3; i++){
				for(int j=3; i<6;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==3){
			for(int i=0; i<3; i++){
				for(int j=6; i<9;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==4){
			for(int i=3; i<6; i++){
				for(int j=0; i<3;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==5){
			for(int i=3; i<6; i++){
				for(int j=3; i<6;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==6){
			for(int i=3; i<6; i++){
				for(int j=6; i<9;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==7){
			for(int i=6; i<9; i++){
				for(int j=0; i<3;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==8){
			for(int i=6; i<9; i++){
				for(int j=3; i<6;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==9){
			for(int i=6; i<9; i++){
				for(int j=6; i<9;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		return stuff;
	}
	
	public static boolean checkBox(int number, int[] stuff){
		for (int i = 0; i < stuff.length; i++) {
			if(number==stuff[i]){
				return true;
			}
		}return false;
		
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

