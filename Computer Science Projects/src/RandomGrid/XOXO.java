package RandomGrid;

public class XOXO {
	public static void main(String args[]){
		boolean[][] twod= new boolean[10][10];
		for(int i=0; i<twod.length; i++){
			for (int j=0; j<twod.length; j++){
				int number=(int) (Math.random()*2);
				if(number<1){
					twod[i][j]=true;
				}
				else{
					twod[i][j]= false;
				}
				}
		}
		for (int i =0; i<twod.length;i++){
			for(int j=0;j<twod.length;j++){
				if(twod[i][j]){
					System.out.print("X ");
				}
				if(!twod[i][j]){
					System.out.print("O ");
				}
			}
			System.out.println("");
		}
	}
}
