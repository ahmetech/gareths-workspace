package IntroToGui;

import javax.swing.JFrame;


public class TinyWindow2 extends JFrame {
	public static void main(String Args[]){
		TinyWindow2 window=new TinyWindow2();
		window.setVisible(true);
	}
	public TinyWindow2(){//Class Constructor
		//... Set window characteristics
		setTitle("Java title for a JFrame subclass");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

