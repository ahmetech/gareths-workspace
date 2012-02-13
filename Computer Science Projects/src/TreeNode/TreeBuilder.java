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
			if(currentNode.getData()<=numb){
				if(checkLeft(currentNode)){
					currentNode.left=new TreeNode(head, null, null, numb);
				}else{
					currentNode=currentNode.getLeft();
					if(){
						
					}
				}
			}
			
			
			
			
			
			/*
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
			}*/
		}
		return head;
		}
	
	//Checks to see if the Left Node is empty or not
	public static boolean checkLeft(TreeNode node){
		if(node.getLeft()==null){
			return false;
		}else return true;
	}
	
	//Checks to see is the Right Node is empty or not
	public static boolean checkRight(TreeNode node){
		if(node.getRight()==null){
			return false;
		}else return true;
	}
	
	//Checks to see if the next node is an end point
	public boolean isEnd(TreeNode node){
		if(node.getLeft()==null&&node.getRight()==null){
			return true;
		}else return false;
	}
	
	
	//preorder: parent, left right
	public static void preOrder(TreeNode head){
		
	}
	
	//inorder: left parent right
	public static void inOrder(TreeNode head){
		
	}
	
	//postorder: left right parent
	public static void postOrder(TreeNode head){
		
	}
}


