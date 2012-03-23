package MagicSquare;
import java.util.ArrayList;
import java.util.Scanner;
public class Square {

	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please input n");
		int n=scanner.nextInt();
		int[][] square=new int[n][n];
		ArrayList<Integer> numbersList=getNumbers(n);
		int magicConstant=findMagicConstant(n);
		if(n%2==0)square=even(square, numbersList, magicConstant);
		else square=odd(square, numbersList, magicConstant, n);
		check(square, magicConstant, n);
	}
	
	public static ArrayList<Integer> getNumbers(int n){
		ArrayList<Integer> numbers=new ArrayList<Integer>();
		for (int i = 1; i <= n*n; i++) {	numbers.add(i);		}	
		return numbers;
	}
	
	public static int findMagicConstant(int n){
		int magic=((n*((n*n)+1))/2);
		return magic;
	}
	
	public static int[][] odd(int[][] square, ArrayList<Integer> numbersList, int magicConstant, int n){
		int lastNumber=numbersList.remove(0);
		square[0][square.length/2]=lastNumber;
		int[] spot=findLastSpot(square, lastNumber);

		while (numbersList.size()!=0) {
			int coor1=spot[0];
			int coor2=spot[1];
			lastNumber=numbersList.remove(0);
			int tempCoor1=findUpMove(coor1, n);
			int tempCoor2=findRightMove(coor2, n);
			if(checkNormal(square, tempCoor1, tempCoor2)){
				square[tempCoor1][tempCoor2]=lastNumber;
				spot[0]=tempCoor1;
				spot[1]=tempCoor2;
			}else spot=placeDown(coor1, coor2, square, lastNumber, n);
		}
		return square;
	}
	
	public static int findUpMove(int coor1, int n){
		if (coor1-1<0) {
			return n-1;
		}else return coor1-1;
	}
	public static int findRightMove(int coor2, int n){
		if(coor2+1==n){
			return 0;
		}else return coor2+1;
	}
	
	public static boolean checkNormal(int[][] square, int coor1, int coor2){
		if(square[coor1][coor2]==0){
			return true;
		}return false;
	}
	
	public static int[] placeDown(int coor1, int coor2, int[][] square, int lastNumber, int n){
		int[] spot=new int[2];
		if(coor1+1<n&&coor2<n){
			square[coor1+1][coor2]=lastNumber;
			spot[0]=coor1+1;
			spot[1]=coor2;
			return spot;
		}else {
			square[0][coor2]=lastNumber;
			spot[0]=0;
			spot[1]=coor2;
			return spot;
		}
	}
	
	public static int[] findLastSpot(int[][] square, int lastNumber){
		int[] spot=new int[2];
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				if(square[i][j]==lastNumber){
					spot[0]=i;
					spot[1]=j;
					return spot;
				}
			}
		}
		return spot;
	}
	
	public static int[][] even(int[][] square, ArrayList<Integer> numbersList, int n){
		int[][]tempSquare=fillBox(square, numbersList);
		
		return square;
	}
	
	public static int[][] fillBox(int[][]square, ArrayList<Integer> numbersList){
		int[][] box=square;
		ArrayList<Integer> temp=numbersList;
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box.length; j++) {
				box[i][j]=temp.remove(0);
			}
		}
		return box;
	}
	
	public static void check(int[][] square, int magicConstant, int n){
		int sum;
		//check rows
		for (int i = 0; i < square.length; i++) {
			sum=0;
			for (int j = 0; j < square.length; j++) {
				sum+=square[i][j];
			}
			if(sum==magicConstant){
				System.out.println("Checked Row");
			}else System.out.println("Failed Row");
		}
		//check columns
		for (int i = 0; i < square.length; i++) {
			sum=0;
			for (int j = 0; j < square.length; j++) {
				sum+=square[j][i];
			}
			if(sum==magicConstant){
				System.out.println("Checked Column");
			}else System.out.println("Failed Column");
		}
		//check diagnols
		//right
		sum=0;
		for (int i = 0; i < square.length; i++) {
			sum+=square[i][i];
		}
		if(sum==magicConstant){
			System.out.println("Checked RDiagnol");
		}else System.out.println("Failed RDiagnol");
		//left
		sum=0;
		for (int i = 0; i < square.length; i++) {
				sum+=square[i][n-1-i];
		}
		if(sum==magicConstant){
			System.out.println("Checked LDiagnol");
		}else System.out.println("Failed LDiagnol");
		
	
	}
	
	public static void printTheSquare(int[][] square){
		for (int i = 0; i < square.length; i++) {
			System.out.println("");
			for (int j = 0; j < square.length; j++) {
				System.out.print(square[i][j]);
				System.out.print("     ");
			}
		}
	}


}
