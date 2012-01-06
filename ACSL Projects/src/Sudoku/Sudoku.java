package Sudoku;

import java.util.ArrayList;
import java.util.Scanner;

public class Sudoku {
	public static void main(String[] args){
		int[][] grid=new int[9][9];
		Scanner scanner=new Scanner(System.in);
		grid=getinput(scanner);
		for (int i = 0; i < 5; i++) {
			String number=scanner.nextLine();
			int row=Integer.valueOf(number)-1;
			int[] missingNumbers=findMissingNumbers(grid, row);
			int[] missingPlaces=findSpaces(grid, row);
			int[] originalRow=new int[9];
			for (int j = 0; j < originalRow.length; j++) {
				originalRow[j]=grid[row][j];
			}
			int[] temporaryrow=originalRow;
			while (!isRowFull(temporaryrow)) {
				for (int place: missingPlaces) {
					int box=findBox(grid, row, place);
					int[] stuffInBox=stuffInBox(grid, box);
					int[] column=getColumn(place, grid);
					int howManyCanFit= howManyCanFit(place, stuffInBox, column, missingNumbers);
					if (howManyCanFit==1) {
						int numberThatFit=numberThatFits(place, stuffInBox, column, missingNumbers);
						missingNumbers=removeFromArray(missingNumbers, numberThatFit);
						addToRow(temporaryrow, numberThatFit, place);
					}
				}
			}
			originalRow=temporaryrow;
			for (int j = 0; j < 9; j++) {
				grid[row][j]=originalRow[j];
			}
			
			
			if(isFull(grid, row)){
				for (int j = 0; j < grid.length; j++) {
					System.out.print(grid[row][j]);
				}
				System.out.println("");
			}
		}
		
	}
	
	public static int[][] getinput(Scanner scanner){
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
			rownumbers[i]=grid[row][i];
		}
		for (int i = 0; i < 9; i++) {
			for (int thing:fullset) {
				if(rownumbers[i]==thing){
					ArrayList<Integer> temp=new ArrayList<Integer>();
					for(int a=0; a<fullset.length;a++){
						if(!(fullset[a]==thing)){
						temp.add(fullset[a]);
						}
					}
					int[] temp2=new int[temp.size()];
					for (int j = 0; j < temp2.length; j++) {
						temp2[j]=temp.get(j);
					}
					fullset=temp2;
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
				for(int j=0; j<3;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==2){
			for(int i=0; i<3; i++){
				for(int j=3; j<6;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==3){
			for(int i=0; i<3; i++){
				for(int j=6; j<9;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==4){
			for(int i=3; i<6; i++){
				for(int j=0; j<3;j++){
					int blah=grid[i][j];
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==5){
			for(int i=3; i<6; i++){
				for(int j=3; j<6;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==6){
			for(int i=3; i<6; i++){
				for(int j=6; j<9;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==7){
			for(int i=6; i<9; i++){
				for(int j=0; j<3;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==8){
			for(int i=6; i<9; i++){
				for(int j=3; j<6;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		if(box==9){
			for(int i=6; i<9; i++){
				for(int j=6; j<9;j++){
					stuff[placeholder]=grid[i][j];
					placeholder++;
				}
			}
		}
		return stuff;
	}
	
	public static int[] getColumn(int place, int[][] grid){
		int[] column=new int[9];
		for (int i = 0; i < 9; i++) {
			column[i]=grid[i][place];
		}
		return column;
	}
	
	public static int howManyCanFit(int place, int[] box, int[] column, int[] missingNumbers){
		int totalThatFit=0;
		for(int number:missingNumbers){
			if (checkBox(number, box)&&checkColumn(number, column)) {
				totalThatFit++;
			}
		}
		return totalThatFit;
	}
	public static int numberThatFits(int place, int[] box, int[] column, int[] missingNumbers){
		int numberThatFits=0;
		for(int number:missingNumbers){
			if (checkBox(number, box)&&checkColumn(number, column)) {
				numberThatFits=number;
			}
		}
		return numberThatFits;
	}
	public static boolean checkBox(int number, int[] stuff){
		for (int i = 0; i < stuff.length; i++) {
			if(number==stuff[i]){
				return false;
			}
		}return true;
		
	}
	
	public static boolean checkColumn(int number,int[] column){
		for (int i = 0; i < 9; i++) {
			if (number==column[i]) {
				return false;
			}
		}return true;
	}
	
	public static void addToRow(int[] row, int number, int place){
		row[place]=number;
	}
	
	public static int[] removeFromArray(int[] missingNumbers, int number){
		int[] open=new int[missingNumbers.length-1];
		int placeholder=0;
		for(int thing: missingNumbers){
			if (!(thing==number)) {
				open[placeholder]=thing;
				placeholder++;
			}
		}
		return open;
	}
	public static boolean isRowFull(int[] row){
		int sum=0;
		for (int i = 0; i < row.length; i++) {
			sum+=row[i];
			}
		if (sum==45) {
			return true;
		}else return false;
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

