package TreeNode;

import java.util.Scanner;

public class TreeBuilder {
	public TreeNode makeTree(){
		Scanner input=new Scanner(System.in);
		String blah=input.next();
		String[] inputs=blah.split(", ");
		int[] numbers=new int[inputs.length];
		for(int i=0; i<inputs.length; i++){
			numbers[i]=Integer.valueOf(inputs[i]);
		}
		
		//Make the list here
		
	}
}
