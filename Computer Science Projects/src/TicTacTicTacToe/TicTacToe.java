package TicTacTicTacToe;

import java.util.Scanner;

public class TicTacToe {
	private String[][]twod= new String[3][3];
	/*public static void main(String args[]){
		twod=putstuffingrid(twod);
		int checknumber=howbigisthearray(twod);
		boolean flipper= true;
		while(flipper){
			for (int b=0;b<checknumber;b++){
				boolean xoro=true;
				printthegrid(twod);
				if(b%2==0){
					System.out.println("Player X's turn:");
				}
				
				else{
					System.out.println("Player O's turn:");
					xoro=false;
				}
				String therespot=getinput(twod);
				int i= (Integer.valueOf(therespot.substring(0,1)))-1;
				int j= Integer.valueOf(therespot.substring(1,2));
				if(xoro){
					twod[i][j]="X ";
				}
				else{
					twod[i][j]="O ";
				}

				flipper= check(twod);
				if(!flipper){
					if(b%2==0){
						printthegrid(twod);
						System.out.println("Player X Wins");
					}
					else{
						printthegrid(twod);
						System.out.println("Player O Wins");
					}
					b=checknumber;
				}
			}
		}
	}*/
	
	public void putstuffplacesx(String bleh){
		int i=Integer.valueOf(bleh.substring(0,1));
		int j=Integer.valueOf(bleh.substring(1,2));
		twod[i][j]= "X ";
	}
	public void putstuffplaceso(String bleh){
		int i=Integer.valueOf(bleh.substring(0,1));
		int j=Integer.valueOf(bleh.substring(1,2));
		twod[i][j]= "O";
	}
	
	public void putinputin(boolean xoro,String input2){
		
		int i= (Integer.valueOf(input2.substring(0,1)))-1;
		int j= Integer.valueOf(input2.substring(1,2));
		if(xoro){
			twod[i][j]="X ";
		}
		else{
			twod[i][j]="O ";
		}
	}

	public void putstuffingrid(){
		for(int i=0; i<twod.length; i++){
			for (int j=0; j<twod[i].length; j++){
				twod[i][j]="- ";
			}
		}
	}
	
	public void putxingrid(){
		for(int i=0; i<twod.length; i++){
			for (int j=0; j<twod[i].length; j++){
				twod[i][j]="X ";
			}
		}
	}

	public void putoingrid(){
		for(int i=0; i<twod.length; i++){
			for (int j=0; j<twod[i].length; j++){
				twod[i][j]="O ";
			}
		}
	}

	public int howbigisthearray(){
		String[][] tic= twod;
		int x=0;
		int o=0;
		for(int i=0; i<tic.length; i++){
			for(int j=0; j<tic[i].length;j++){
				if(tic[i][j].equals("X "))x++;
				if(tic[i][j].equals("O "))o++;
			}
		}
		int checknumber=x+o;
		if(x==9||o==9){
			checknumber=0;
		}
		return checknumber;
	}


	public void printthegrid(String[][] twod){
		System.out.println(twod[0][0]+"|"+twod[0][1]+"|"+twod[0][2]);
		System.out.println("--+--+--");
		System.out.println(twod[1][0]+"|"+twod[1][1]+"|"+twod[1][2]);
		System.out.println("--+--+--");
		System.out.print(twod[2][0]+"|"+twod[2][1]+"|"+twod[2][2]);
	}
	public void printthegrid1(){
		System.out.print(twod[0][0]+"|"+twod[0][1]+"|"+twod[0][2]+"|");
	}
	public void printthegrid2(){
		System.out.print(twod[1][0]+"|"+twod[1][1]+"|"+twod[1][2]+"|");
	}
	public void printthegrid3(){
		System.out.print(twod[2][0]+"|"+twod[2][1]+"|"+twod[2][2]+"|");
	}


	public String getinput(String[][] twod){
		Scanner input= new Scanner(System.in);
		String therespot=input.nextLine();
		boolean theswitch=true;
		while(theswitch){
			if(therespot.length()!=2 || (Integer.valueOf(therespot.substring(0,1)))-1>=twod.length || ((therespot.charAt(1))-65)>=twod.length){
				System.out.println("Please input a valid location");
				printthegrid(twod);
				therespot=input.nextLine();
			}
			else if(twod[(Integer.valueOf(therespot.substring(0,1)))-1][(therespot.charAt(1))-65].equals("X ")||twod[(Integer.valueOf(therespot.substring(0,1)))-1][(therespot.charAt(1))-65].equals("O ")){
				System.out.println("That location is already taken, please input an empty location:");
				printthegrid(twod);
				therespot=input.nextLine();
			}
			else{
				theswitch=false;
			}
		}
		String firstletter=therespot.substring(0,1);
		char temp=therespot.charAt(1);
		int secondletter=temp-65;
		String thereinput=firstletter+secondletter;
		return thereinput;
	}


	public boolean check(){
		boolean bob= false;
		boolean nil= true;
		int i= checkrow();
		int j= checkcolumn();
		int k= checkdiagnol();
		if(i>0||j>0||k>0){
			return bob;
		}
		else{
			return nil;
		}
	}


	public int checkrow(){
		String[][] tic= twod;
		int win;
		int x=0;
		int o=0;
		for(int i=0; i<tic.length; i++){
			x=0;
			o=0;
			for(int j=0; j<tic[i].length;j++){
				if(tic[i][j].equals("X "))x++;
				if(tic[i][j].equals("O "))o++;
			}
			if(x==tic.length){
				win=1;
				return win;
			}
			if(o==tic.length){
				win=2;
				return win;
			}
		}
		win=0;
		return win;
	}


	public int checkcolumn(){
		String[][] tic= twod;
		int win;
		int x=0;
		int o=0;
		for(int i=0; i<tic.length; i++){
			x=0;
			o=0;
			for(int j=0; j<tic[i].length;j++){
				if(tic[j][i].equals("X "))x++;
				if(tic[j][i].equals("O "))o++;
			}
			if(x==tic.length){
				win=1;
				return win;
			}
			if(o==tic.length){
				win=2;
				return win;
			}
		}
		win=0;
		return win;
	}


	public int checkdiagnol(){
		String[][] tic= twod;
		int win;
		if((tic[0][2].equals("X ")&&tic[1][1].equals("X ")&&tic[2][0].equals("X "))||((tic[0][0].equals("X ")&&tic[1][1].equals("X ")&&tic[2][2].equals("X ")))){
			win=1;
			return win;
		}
		if((tic[0][0].equals("O ")&&tic[1][1].equals("O ")&&tic[2][2].equals("O "))||((tic[0][2].equals("O ")&&tic[1][1].equals("O ")&&tic[2][0].equals("O ")))){
			win=2;
			return win;	
		}
		win=0;
		return win;
	}
}
