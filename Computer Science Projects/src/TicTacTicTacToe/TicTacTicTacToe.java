package TicTacTicTacToe;

import java.util.ArrayList;
import java.util.Scanner;


public class TicTacTicTacToe {
	public static void main(String args[]){
		TicTacToe bigtictactoe= new TicTacToe();
		bigtictactoe.putstuffingrid();
		boolean flipper= true;
		ArrayList<TicTacToe> row1= populaterow1();
		ArrayList<TicTacToe> row2= populaterow2();
		ArrayList<TicTacToe> row3= populaterow3();
		for (int i = 0; i < 3; i++) {
			row1.get(i).putstuffingrid();
		}
		for (int i = 0; i < 3; i++) {
			row2.get(i).putstuffingrid();
		}
		for (int i = 0; i < 3; i++) {
			row3.get(i).putstuffingrid();
		}
		while(flipper){
			for(int b=0; b<100000; b++){
				printstuff(row1, row2, row3);
				boolean xoro=true;
				if(b%2==0){
					xoro=true;
					System.out.println("Player X's turn:");
				}
				else{
					xoro=false;
					System.out.println("Player 0's turn:");
				}	
				String input=getinput();
				String input1=input.substring(0,2);
				String input2=input.substring(2,4);
				int a=Integer.valueOf(input1.substring(0,1));
				int c=Integer.valueOf(input1.substring(1,2));
				if(a==1){
					row1.get(c).putinputin(xoro, input2);
				}
				if(a==2){
					row2.get(c).putinputin(xoro, input2);
				}
				if(a==3){
					row3.get(c).putinputin(xoro, input2);
				}
				check(row1, row2, row3, bigtictactoe);
				flipper=bigtictactoe.check();
				if(!flipper){
					if(b%2==0){
						printstuff(row1, row2, row3);
						System.out.println("Player X Wins");
					}
					else{
						printstuff(row1, row2, row3);
						System.out.println("Player O Wins");
					}
					b=100000;
				}
			}
		}
	}
	public static ArrayList<TicTacToe> populaterow1() {
		ArrayList<TicTacToe> row1= new ArrayList<TicTacToe>();
		row1.add(new TicTacToe());
		row1.add(new TicTacToe());
		row1.add(new TicTacToe());
		return row1;
	}
	public static ArrayList<TicTacToe> populaterow2() {
		ArrayList<TicTacToe> row1= new ArrayList<TicTacToe>();
		row1.add(new TicTacToe());
		row1.add(new TicTacToe());
		row1.add(new TicTacToe());
		return row1;
	}
	public static ArrayList<TicTacToe> populaterow3() {
		ArrayList<TicTacToe> row1= new ArrayList<TicTacToe>();
		row1.add(new TicTacToe());
		row1.add(new TicTacToe());
		row1.add(new TicTacToe());
		return row1;
	}
	public static void printstuff(ArrayList<TicTacToe> row1, ArrayList<TicTacToe> row2, ArrayList<TicTacToe> row3){
		for (int i = 0; i < 3; i++) {
			row1.get(i).printthegrid1();
		}
		System.out.println("");
		for (int i = 0; i <3; i++) {
			System.out.print("--+--+--|");
		}
		System.out.println("");
		for (int i = 0; i < 3; i++) {
			row1.get(i).printthegrid2();
		}
		System.out.println("");
		for (int i = 0; i <3; i++) {
			System.out.print("--+--+--|");
		}
		System.out.println("");
		for (int i = 0; i < 3; i++) {
			row1.get(i).printthegrid3();
		}
		System.out.println("");
		System.out.println("--------------------------|");
		for (int i = 0; i < 3; i++) {
			row2.get(i).printthegrid1();
		}
		System.out.println("");
		for (int i = 0; i <3; i++) {
			System.out.print("--+--+--|");
		}
		System.out.println("");
		for (int i = 0; i < 3; i++) {
			row2.get(i).printthegrid2();
		}
		System.out.println("");
		for (int i = 0; i <3; i++) {
			System.out.print("--+--+--|");
		}
		System.out.println("");
		for (int i = 0; i < 3; i++) {
			row2.get(i).printthegrid3();
		}
		System.out.println("");
		System.out.println("--------------------------|");
		for (int i = 0; i < 3; i++) {
			row3.get(i).printthegrid1();
		}
		System.out.println("");
		for (int i = 0; i <3; i++) {
			System.out.print("--+--+--|");
		}
		System.out.println("");
		for (int i = 0; i < 3; i++) {
			row3.get(i).printthegrid2();
		}
		System.out.println("");
		for (int i = 0; i <3; i++) {
			System.out.print("--+--+--|");
		}
		System.out.println("");
		for (int i = 0; i < 3; i++) {
			row3.get(i).printthegrid3();
		}
		System.out.println("");
		System.out.println("---------------------------");
	}
	public static String getinput(){
		Scanner bob= new Scanner(System.in);
		String baseinput=bob.next();
		if(baseinput.length()!=4){
			System.out.println("Please input a valid location:");
			baseinput=bob.next();
		}
		String part1=baseinput.substring(0,2);
		String temp1=part1.substring(0,1);
		char temp=part1.charAt(1);
		int temp2=temp-65;
		part1=temp1+temp2;
		String part2=baseinput.substring(2,4);
		temp1=part2.substring(0,1);
		temp=part2.charAt(1);
		temp2=temp-65;
		part2=temp1+temp2;
		String changedinput=part1+part2;
		return changedinput;
	}
	public static void check(ArrayList<TicTacToe> row1, ArrayList<TicTacToe> row2, ArrayList<TicTacToe> row3, TicTacToe bigtictactoe){
		for (int i = 0; i < 3; i++) {
			int check1=row1.get(i).checkrow();
			if(check1==1){
				row1.get(i).putxingrid();
				String bleh= "0"+i;
				bigtictactoe.putstuffplacesx(bleh);
			}
			if(check1==2){
				row1.get(i).putoingrid();
				String bleh= "0"+i;
				bigtictactoe.putstuffplaceso(bleh);
			}
		}
		for (int i = 0; i < 3; i++) {
			int check2=row1.get(i).checkcolumn();
			if(check2==1){
				row1.get(i).putxingrid();
				String bleh= "0"+i;
				bigtictactoe.putstuffplacesx(bleh);
			}
			if(check2==2){
				row1.get(i).putoingrid();
				String bleh= "0"+i;
				bigtictactoe.putstuffplaceso(bleh);
			}
		}
		for (int i = 0; i < 3; i++) {
			int check3=row1.get(i).checkdiagnol();
			if(check3==1){
				row1.get(i).putxingrid();
				String bleh= "0"+i;
				bigtictactoe.putstuffplacesx(bleh);
			}
			if(check3==2){
				row1.get(i).putoingrid();
				String bleh= "0"+i;
				bigtictactoe.putstuffplaceso(bleh);
			}
		}

		for (int i = 0; i < 3; i++) {
			int check1=row2.get(i).checkrow();
			if(check1==1){
				row2.get(i).putxingrid();
				String bleh= "1"+i;
				bigtictactoe.putstuffplacesx(bleh);
			}
			if(check1==2){
				row2.get(i).putoingrid();
				String bleh= "1"+i;
				bigtictactoe.putstuffplaceso(bleh);
			}
		}
		for (int i = 0; i < 3; i++) {
			int check2=row2.get(i).checkcolumn();
			if(check2==1){
				row2.get(i).putxingrid();
				String bleh= "1"+i;
				bigtictactoe.putstuffplacesx(bleh);
			}
			if(check2==2){
				row2.get(i).putoingrid();
				String bleh= "1"+i;
				bigtictactoe.putstuffplaceso(bleh);
			}
		}
		for (int i = 0; i < 3; i++) {
			int check3=row2.get(i).checkdiagnol();
			if(check3==1){
				row2.get(i).putxingrid();
				String bleh= "1"+i;
				bigtictactoe.putstuffplacesx(bleh);
			}
			if(check3==2){
				row2.get(i).putoingrid();
				String bleh= "1"+i;
				bigtictactoe.putstuffplaceso(bleh);
			}
		}

		for (int i = 0; i < 3; i++) {
			int check1=row3.get(i).checkrow();
			if(check1==1){
				row3.get(i).putxingrid();
				String bleh= "2"+i;
				bigtictactoe.putstuffplacesx(bleh);
			}
			if(check1==2){
				row3.get(i).putoingrid();
				String bleh= "2"+i;
				bigtictactoe.putstuffplaceso(bleh);

			}
		}
		for (int i = 0; i < 3; i++) {
			int check2=row3.get(i).checkcolumn();
			if(check2==1){
				row3.get(i).putxingrid();
				String bleh= "2"+i;
				bigtictactoe.putstuffplacesx(bleh);
			}
			if(check2==2){
				row3.get(i).putoingrid();
				String bleh= "2"+i;
				bigtictactoe.putstuffplaceso(bleh);
			}
		}
		for (int i = 0; i < 3; i++) {
			int check3=row3.get(i).checkdiagnol();
			if(check3==1){
				row3.get(i).putxingrid();
				String bleh= "2"+i;
				bigtictactoe.putstuffplacesx(bleh);
			}
			if(check3==2){
				row3.get(i).putoingrid();
				String bleh= "2"+i;
				bigtictactoe.putstuffplaceso(bleh);
			}
		}
		for(int i = 0; i < 3; i++){
			int kasper= row1.get(i).howbigisthearray();
			if(kasper==9){
				row1.get(i).putstuffingrid();
			}
		}
		for(int i = 0; i < 3; i++){
			int kasper= row2.get(i).howbigisthearray();
			if(kasper==9){
				row1.get(i).putstuffingrid();
			}
		}
		for(int i = 0; i < 3; i++){
			int kasper= row3.get(i).howbigisthearray();
			if(kasper==9){
				row1.get(i).putstuffingrid();
			}
		}
	}
	public static boolean checkbig(TicTacToe bigtictactoe){
		boolean bob= false;
		boolean nil= true;
		int i= bigtictactoe.checkrow();
		int j= bigtictactoe.checkcolumn();
		int k= bigtictactoe.checkdiagnol();
		if(i>0||j>0||k>0){
			return bob;
		}
		else{
			return nil;
		}
	}
}