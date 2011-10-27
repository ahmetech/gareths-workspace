package Star;

import javax.swing.JFrame;


public class Star extends JFrame{
	public Star(){
		add(new Board());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920,1080);
		setTitle("Star");
		setResizable(false);
		setLocationRelativeTo(null);
	}
	public static void main(String args[]){
		new Star();
	}
}
