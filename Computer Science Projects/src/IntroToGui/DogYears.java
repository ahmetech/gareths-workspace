package IntroToGui;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DogYears extends JFrame{
	private JTextField _humanYearsTF= new JTextField(3);
	private JTextField _dogYearsTF=new JTextField(3);
	
	public DogYears(){
		JButton convertbtn=new JButton("Convert");
		convertbtn.addActionListener(new convertbtnListener());
		JPanel content= new JPanel();
		content.setLayout(new GridLayout());
		content.add(new JLabel("Dog Years"));
		content.add(_dogYearsTF);;
		content.add(convertbtn);
		content.add(new JLabel("Human Years"));
		content.add(_humanYearsTF);
		setContentPane(content);
		pack();
		setTitle("Dog Year Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	class convertbtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String input=_dogYearsTF.getText();
			int dogyears=Integer.valueOf(input);
			int humanyears=dogyears*7;
			_humanYearsTF.setText(""+ humanyears);
		}
	}
	public static void main(String args[]){
		DogYears blah=new DogYears();
		blah.setVisible(true);
	}
}
