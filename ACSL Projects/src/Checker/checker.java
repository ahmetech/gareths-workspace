package Checker;

public class checker {
	private int row=0;
	private int column=0;
	private boolean isking;
	private boolean player;
	
	
	public checker(int blank, int stuff,boolean word, boolean king){
		row=blank;
		column=stuff;
		player=word;
		isking=king;
	}
	public int getrow(){
		return row;
	}
	public int getcolumn(){
		return column;
	}
	public boolean isplayer(){
		return player;
	}
	public boolean isking(){
		if(row==8){
			isking=true;
		}
		return isking;
	}
}
