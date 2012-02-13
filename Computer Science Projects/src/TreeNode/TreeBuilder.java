package TreeNode;

import java.util.ArrayList;
import java.util.Scanner;

public class TreeBuilder {
	public static TreeNode makeTree(){
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
		TreeNode currentNode=head;
		TreeNode tempNode;
		while(!(number.size()==0)){
			int numb=number.remove(0);
			if(currentNode.data<=numb){
				currentNode.left=new TreeNode(null, null, null, numb);
				head=currentNode;
				tempNode=currentNode.left;
				tempNode.parent=currentNode;
				currentNode=tempNode;
			}
			else{
				currentNode.right=new TreeNode(null, null, null, numb);
				head=currentNode;
				tempNode=currentNode.right;
				tempNode.parent=currentNode;
				currentNode=tempNode;
			}
		}
		return currentNode;
		}
}
//preorder:parent, left right
//inorder:left parent right
//postorder:left right parent