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
		else square=odd(square, numbersList, magicConstant);
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
	
	public static int[][] odd(int[][] square, ArrayList<Integer> numbersList, int magicConstant){
		int lastNumber=numbersList.remove(0);
		square[0][square.length/2]=lastNumber;
		while (numbersList.size()!=0) {
			
			
		}
		return square;
	}
	
	public static boolean checkNormal(){
		
	}
	
	public static int[][] even(int[][] square, ArrayList<Integer> numbersList, int magicConstant){
		
		
		return square;
	}


}
