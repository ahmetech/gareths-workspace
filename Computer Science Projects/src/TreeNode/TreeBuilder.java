package TreeNode;

import java.util.ArrayList;
import java.util.Scanner;

public class TreeBuilder {
	public static TreeNode makeTree(){
		Scanner input=new Scanner(System.in);
		String blah=input.next();
		String[] inputs=blah.split(", ");
		int[] numbers=new int[inputs.length];
		
		//Changes the String[] into a int[]
		for(int i=0; i<inputs.length; i++){
			numbers[i]=Integer.valueOf(inputs[i]);
		}
		
		//Changes the int[] into a ArrayList<Integer>
		ArrayList<Integer> number=new ArrayList();
		for(int i=0; i<numbers.length; i++){
			number.add(numbers[i]);
		}
		
		
		//Makes the list here
		TreeNode head=new TreeNode(null, null, null, number.remove(0));
		while(!(number.size()==0)){
			int numb=number.remove(0);
			makeMove(head, null, numb);
		}
		return head;
		}
	
	//Returns false is node.getData() is less that than the numb, true if greater
	public static boolean leftOrRight(TreeNode node, int numb){
		if (node.getData()<=numb) {
			return false;
		}else return true;
	}
	
	//
	public static void makeMove(TreeNode node, TreeNode paramPrevNode, int numb){
		TreeNode currentNode=node;
		TreeNode prevNode=paramPrevNode;
		if (leftOrRight(node, numb)) {
			if (checkRight(currentNode)) {
				currentNode.right=new TreeNode(prevNode, null, null, numb);
			}else {
				prevNode=currentNode;
				currentNode=currentNode.getRight();
				makeMove(currentNode, prevNode, numb);
			}
		}else {
			if (checkLeft(currentNode)) {
				currentNode.left=new TreeNode(prevNode, null, null, numb);
			}else {
				prevNode=currentNode;
				currentNode=currentNode.getLeft();
				makeMove(currentNode, prevNode, numb);
			}
		}
	}
	
	//Checks to see if the Left Node is empty or not
	public static boolean checkLeft(TreeNode node){
		if(node.getLeft()==null){
			return true;
		}else return false;
	}
	
	//Checks to see is the Right Node is empty or not
	public static boolean checkRight(TreeNode node){
		if(node.getRight()==null){
			return true;
		}else return false;
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


