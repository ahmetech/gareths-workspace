package IntroToGui;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TinyWindow4 extends JFrame{
	public static void main(String args[]){
		TinyWindow4 window= new TinyWindow4();
		window.setVisible(true);
	}
	public TinyWindow4(){
		JPanel content= new JPanel();
		content.setLayout(new FlowLayout());
		
		content.add(new JLabel("We come in Peace"));
		
		setContentPane(content);
		pack();
		setTitle("Tiny Window using Jframe Subclass");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
}

