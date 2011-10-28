package GUITicTacToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Grid extends JPanel implements ActionListener{
	protected Image grid;
	protected boolean which;
	protected ArrayList<Button> buttons;
	protected ArrayList<Check> checks;
	protected ArrayList<Circle> circles;
	protected Timer timer;
	protected boolean ingame;
	protected String[][] board;
	protected int intwidth;
	protected int intheight;


	public Grid(){
		setBackground(Color.BLACK);
		ImageIcon ii=new ImageIcon(getClass().getResource("TicTacToeGrid.png"));
		ImageIcon iii=new ImageIcon(getClass().getResource("check.png"));
		ImageIcon iiii=new ImageIcon(getClass().getResource("circle.png"));
		buttons=new ArrayList();
		checks=new ArrayList();
		circles=new ArrayList();
		which=true;
		ingame=true;
		grid=ii.getImage();
		buttons.add(new Button(10,10));
		buttons.add(new Button(223,10));
		buttons.add(new Button(426, 10));
		buttons.add(new Button(10, 227));
		buttons.add(new Button(223, 227));
		buttons.add(new Button(426, 227));
		buttons.add(new Button(10, 427));
		buttons.add(new Button(223, 427));
		buttons.add(new Button(426, 427));
		board=new String[3][3];
		intwidth=grid.getWidth(null);
		intheight=grid.getHeight(null);
		putstuffingrid();
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				if (event.getButton() == event.BUTTON1) {
					int x = event.getX();
					int y = event.getY();
					if(which){
						for (int i = 0; i < buttons.size(); i++) {
							if(((y<(buttons.get(i).getTotalheight()))&&(y>buttons.get(i).getY()))&&((x<(buttons.get(i).getTotalwidth()))&&(x>buttons.get(i).getX()))){
								checks.add(new Check(buttons.get(i).getX(),buttons.get(i).getY()));
								if(i==0){
									board[0][0]=" X ";
								}
								if(i==1){
									board[0][1]=" X ";
								}
								if(i==2){
									board[0][2]=" X ";
								}
								if(i==3){
									board[1][0]=" X ";
								}
								if(i==4){
									board[1][1]=" X ";
								}
								if(i==5){
									board[1][2]=" X ";
								}
								if(i==6){
									board[2][0]=" X ";
								}
								if(i==7){
									board[2][1]=" X ";
								}
								if(i==8){
									board[2][2]=" X ";
								}
								buttons.get(i).setVisible(false);
								which=false;
							}
						}
					}else{
						for (int i = 0; i < buttons.size(); i++) {
							if(((y<(buttons.get(i).getTotalheight()))&&(y>buttons.get(i).getY()))&&((x<(buttons.get(i).getTotalwidth()))&&(x>buttons.get(i).getX()))){
								circles.add(new Circle(buttons.get(i).getX()+10,buttons.get(i).getY()));
								if(i==0){
									board[0][0]=" O ";
								}
								if(i==1){
									board[0][1]=" O ";
								}
								if(i==2){
									board[0][2]=" O ";
								}
								if(i==3){
									board[1][0]=" O ";
								}
								if(i==4){
									board[1][1]=" O ";
								}
								if(i==5){
									board[1][2]=" O ";
								}
								if(i==6){
									board[2][0]=" O ";
								}
								if(i==7){
									board[2][1]=" O ";
								}
								if(i==8){
									board[2][2]=" O ";
								}
								buttons.get(i).setVisible(false);
								which=true;
							}
						}
					}
				}

			}
		});
		timer=new Timer(10, this);
		timer.start();
	}
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d= (Graphics2D) g;
		if(ingame){
			g2d.drawImage(grid, 0, 0, this);
			for (int i = 0; i < buttons.size(); i++) {
				if(buttons.get(i).isVisible()){
					g2d.drawImage(buttons.get(i).getImage(),buttons.get(i).getX(),buttons.get(i).getY(), this);
				}
			}
			for (int i = 0; i < checks.size(); i++) {
				g2d.drawImage(checks.get(i).getImage(),checks.get(i).getX(),checks.get(i).getY(), this);
			}
			for (int i = 0; i < circles.size(); i++) {
				g2d.drawImage(circles.get(i).getImage(),circles.get(i).getX(),circles.get(i).getY(), this);
			}
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
		}else{
			if(which){
				
				String msg="Player O Wins";
				Font small=new Font("Helvetica", Font.BOLD,14);
				FontMetrics metr=this.getFontMetrics(small);
				g.setColor(Color.white);
				g.setFont(small);
				g.drawString(msg, ((intwidth-metr.stringWidth(msg))/2),intheight/2 );
			}else{
				String msg="Player X Wins";
				Font small=new Font("Helvetica", Font.BOLD,14);
				FontMetrics metr=this.getFontMetrics(small);
				g.setColor(Color.white);
				g.setFont(small);
				g.drawString(msg, ((intwidth-metr.stringWidth(msg))/2),intheight/2 );
			}
		}
	}	
	public void actionPerformed(ActionEvent e) {
		printthegrid(board);
		checkifwinner(board);
		repaint();
	}




	//Stuff dealing with the array gird

	public void printthegrid(String[][] twod){
		System.out.println(twod[0][0]+"|"+twod[0][1]+"|"+twod[0][2]);
		System.out.println("--+--+--");
		System.out.println(twod[1][0]+"|"+twod[1][1]+"|"+twod[1][2]);
		System.out.println("--+--+--");
		System.out.println(twod[2][0]+"|"+twod[2][1]+"|"+twod[2][2]);
	}
	public void putstuffingrid(){
		for(int i=0; i<board.length; i++){
			for (int j=0; j<board[i].length; j++){
				board[i][j]=" - ";
			}
		}
	}
	public void checkifwinner(String[][] board){

		int row= checkrow(board);
		int column= checkcolumn(board);
		int diagnol= checkdiagnol(board);
		System.out.println(row+column+diagnol);
		if(row>0||column>0||diagnol>0){
			ingame=false;
		}
		else{
			ingame= true;

		}
	}
	public int checkrow(String[][] board){
		String[][] tic= board;
		int win;
		int x=0;
		int o=0;
		for(int i=0; i<tic.length; i++){
			x=0;
			o=0;
			for(int j=0; j<tic[i].length;j++){
				if(tic[i][j].equals(" X "))x++;
				if(tic[i][j].equals(" O "))o++;
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


	public int checkcolumn(String[][] board){
		String[][] tic= board;
		int win;
		int x=0;
		int o=0;
		for(int i=0; i<tic.length; i++){
			x=0;
			o=0;
			for(int j=0; j<tic[i].length;j++){
				if(tic[j][i].equals(" X "))x++;
				if(tic[j][i].equals(" O "))o++;
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


	public int checkdiagnol(String[][] board){
		String[][] tic= board;
		int win;
		if((tic[0][2].equals(" X ")&&tic[1][1].equals(" X ")&&tic[2][0].equals(" X "))||((tic[0][0].equals(" X ")&&tic[1][1].equals(" X ")&&tic[2][2].equals(" X ")))){
			win=1;
			return win;
		}
		if((tic[0][0].equals(" O ")&&tic[1][1].equals(" O ")&&tic[2][2].equals(" O "))||((tic[0][2].equals(" O ")&&tic[1][1].equals(" O ")&&tic[2][0].equals(" O ")))){
			win=2;
			return win;	
		}
		win=0;
		return win;
	}

}
