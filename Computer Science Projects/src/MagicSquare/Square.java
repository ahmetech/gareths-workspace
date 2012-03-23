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
		for (int i = 0; i < square.length; i++) {
			System.out.println("");
			for (int j = 0; j < square.length; j++) {
				System.out.print(square[i][j]);
				System.out.print(" ");
			}
		}
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
		String lastSpot=findLastSpot(square, lastNumber);
		while (numbersList.size()!=0) {
			int coor1=Integer.valueOf(lastSpot.substring(0,1));
			int coor2=Integer.valueOf(lastSpot.substring(1,2));
			lastNumber=numbersList.remove(0);
			int tempCoor1=findUpMove(coor1, n);
			int tempCoor2=findRightMove(coor2, n);
			if(checkNormal(square, tempCoor1, tempCoor2)){
				square[tempCoor1][tempCoor2]=lastNumber;
				lastSpot=Integer.toString(tempCoor1)+Integer.toString(tempCoor2);
			}else lastSpot=placeDown(coor1, coor2, square, lastNumber, n);
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
	
	public static String placeDown(int coor1, int coor2, int[][] square, int lastNumber, int n){
		String spot="";
		if(coor1+1<n&&coor2<n){
			square[coor1+1][coor2]=lastNumber;
			spot=Integer.toString(coor1+1)+Integer.toString(coor2);
			return spot;
		}else {
			square[0][coor2]=lastNumber;
			spot=Integer.toString(0)+Integer.toString(coor2);
			return spot;
		}
	}
	
	public static String findLastSpot(int[][] square, int lastNumber){
		String spot="";
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				if(square[i][j]==lastNumber){
					spot=Integer.toString(i)+Integer.toString(j);
					return spot;
				}
			}
		}
		return spot;
	}
	
	public static int[][] even(int[][] square, ArrayList<Integer> numbersList, int magicConstant){
		
		
		return square;
	}


}
