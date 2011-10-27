package Checker;

import java.util.ArrayList;
import java.util.Scanner;

public class Checkerboard {
	public static void println(Object s){ System.out.println(s);}
	public static void print(Object s){ System.out.print(s);}
	public static String[][] checkerboard= new String[10][10];
	public static ArrayList<checker> checkers=new ArrayList<checker>();
	public static void main(String args[]){
		fillthegrid(checkerboard,checkers);
		String input=getinput();
		String userinput=splitinputuser(input);
		int userpart=getuser(userinput, checkers);
		getenemies(input, userpart, checkers);
		//printtheboard(checkerboard);
		findmoves(checkerboard, checkers);
	}
	public static void printtheboard(String[][] checkerboard){
		fillthegrid(checkerboard, checkers);
		for (int i = 0; i < checkerboard.length; i++) {
			for (int j = 0; j < checkerboard[i].length; j++) {
				System.out.print(checkerboard[i][j] + "|");
			}
			System.out.println("");
			System.out.println("---+---+---+---+---+---+---+---+---+---+");
		}
	}
	public static void fillthegrid(String[][] checkerboard, ArrayList<checker> checkers){
		for (int i = 0; i < checkerboard.length; i++) {
			for (int j = 0; j < checkerboard[i].length; j++) {
				checkerboard[i][j]="   ";
			}
		}
		for (int j=0; j<checkers.size();j++){
			int blah= checkers.get(j).getrow();
			int thing=checkers.get(j).getcolumn();
			boolean king=checkers.get(j).isking();
			boolean player=checkers.get(j).isplayer();
			if(player&&king)checkerboard[blah][thing]=" P ";
			else if(player)checkerboard[blah][thing]=" p ";
			else checkerboard[blah][thing]=" e ";
		}
	}
	public static void updatethegird(String[][] checkerboard){
		
	}
	public static String getinput(){
		Scanner input= new Scanner(System.in);
		System.out.println("Please input your stuff");
		String blah= input.next();
		return blah;
	}
	public static String splitinputuser(String input){
		int firstblock=Integer.valueOf(input.substring(0,1));
		int howmanytosplit=2;
		for(int i=0; i<firstblock;i++){
			howmanytosplit+=4;
		}
		String userinput=input.substring(0,howmanytosplit);
		return userinput;
	}
	public static int getuser(String userinput, ArrayList<checker> checkers){
		int firstblock=Integer.valueOf(userinput.substring(0,1));
		boolean player=true;
		String places=userinput.substring(2,userinput.length());
		int j=0;
		for(int i=0; i<firstblock; i++){
			checkers.add(new checker(Integer.valueOf(places.substring((0+j),(1+j))), Integer.valueOf(places.substring((2+j),(3+j))), player, false));
			j+=4;
		}
		int blah= userinput.length();
		return blah;
	}
	public static void getenemies(String input,int userpart, ArrayList<checker>checkers){
		String temp=input.substring(userpart, input.length());
		String piece=temp+",";
		int firstblock=Integer.valueOf(piece.substring(0,1));
		boolean player=false;
		String places=piece.substring(2,piece.length());
		int j=0;
		for(int i=0; i<firstblock; i++){
			checkers.add(new checker(Integer.valueOf(places.substring((0+j),(1+j))), Integer.valueOf(places.substring((2+j),(3+j))), player, false));
			j+=4;
		}
	}
	public static void findmoves(String[][] checkerboard, ArrayList<checker> checkers){
		int jumps=0;
		for(int i=0; i<checkers.size();i++){
			if(checkers.get(i).isplayer()){
				if(!checkers.get(i).isking()){
					int jr=0,jl=0;
					if(checkers.get(i).getrow()>0){
						fillthegrid(checkerboard, checkers);
						jl=checkformove("l","u",checkers.get(i).getcolumn(),checkers.get(i).getrow(),false, checkerboard, checkers);
					}
					if(checkers.get(i).getrow()<7){
						fillthegrid(checkerboard, checkers);
						jr=checkformove("r","u",checkers.get(i).getcolumn(),checkers.get(i).getrow(),false, checkerboard, checkers);
					}

					if(jr>jumps)jumps=jr;
					if(jl>jumps)jumps=jl;
				}
				else{
					if(checkers.get(i).isking()){
						int dr=0,dl=0;
						if(checkers.get(i).getrow()>0){
							fillthegrid(checkerboard, checkers);
							dl=checkformove("l","d",checkers.get(i).getcolumn(),checkers.get(i).getrow(),true, checkerboard, checkers);
						}
						if(checkers.get(i).getrow()<=8){
							fillthegrid(checkerboard, checkers);
							dr=checkformove("r","d",checkers.get(i).getcolumn(),checkers.get(i).getrow(),true, checkerboard, checkers);
						}


						if(dr>jumps)jumps=dr;
						if(dl>jumps)jumps=dl;
					}
				}

			}
		}

		System.out.print("The maximum amount of jumps is: "+jumps);
	}
	public static int checkformove(String dir, String vdir, int c, int r,boolean isking, String[][] checkerboard, ArrayList<checker> checkers){
		int dr=0;
		int dc=0;
		boolean switchy=isking;
		if(dir.equals("l"))dc=-1;
		if(dir.equals("r"))dc=1;
		if(vdir.equals("u"))dr=1;
		if(vdir.equals("d"))dr=-1;
		if(checkerboard[r+dr][c+dc].equals(" e ")&&!checkerboard[r+dr+dr][c+dc+dc].equals(" e ")){
			int jr=1;
			int jl=1;
			checkerboard[r+dr][c+dc]="   ";
			if(!checkerboard[r+dr+dr][c+dc+dc].equals(" e ")&& !(r+dr+dr==8)&&!switchy ){
				if((r+dr+dr)>0 && (c+dc+dc)>0)jl= (checkformove("l","u",c+dc+dc,r+dr+dr,false, checkerboard, checkers))+1;
				if((r+dr+dr)<7 && (c+dc+dc)>0)jr= (checkformove("r","u",c+dc+dc,r+dr+dr,false, checkerboard, checkers))+1;
			}
			if(!checkerboard[r+dr+dr][c+dc+dc].equals(" e ")&& ((r+dr+dr==8)||switchy)){
				if((r+dr+dr)<=8 && (c+dc+dc)>0)jr= (checkformove("r","d",c+dc+dc,r+dr+dr, true, checkerboard, checkers))+1;
				if((r+dr+dr)>0 && (c+dc+dc)>0)jl= (checkformove("l","d",c+dc+dc,r+dr+dr, true, checkerboard, checkers))+1;
			}
			if(jl>=jr)return jl;
			else return jr;


		}
		return 0;
	}
}
