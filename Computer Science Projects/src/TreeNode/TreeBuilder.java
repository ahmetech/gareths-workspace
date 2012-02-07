package TreeNode;

import java.util.ArrayList;
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
		ArrayList<Integer> number=new ArrayList();
		for(int i=0; i<numbers.length; i++){
			number.add(numbers[i]);
		}
		//Make the list here
		TreeNode head=new TreeNode(null, null, null, number.remove(0));
		while(!(number.size()==0)){
			
		}
		
		
		
		
		
	}
}
//preorder:parent, left right
//inorder:left parent right
//postorder:left right parent