package TreeNode;

import java.util.ArrayList;
import java.util.Scanner;

public class TreeBuilder {
	public static TreeNode makeTree(){
		Scanner input=new Scanner(System.in);
		System.out.println("Please input the numbers now: ");
		String blah=input.nextLine();
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
			makeMove(head, numb);
		}
		return head;
		}
	
	//Returns false is node.getData() is less that than the numb, true if greater
	public static boolean leftOrRight(TreeNode node, int numb){
		if (node.getData()>=numb) {
			return false;
		}else return true;
	}
	
	//Used to set up the tree
	public static void makeMove(TreeNode node,  int numb){
		TreeNode currentNode=node;
		if (leftOrRight(node, numb)) {
			if (checkRight(currentNode)) {
				currentNode.right=new TreeNode(currentNode, null, null, numb);
			}else {
				currentNode=currentNode.getRight();
				makeMove(currentNode, numb);
			}
		}else {
			if (checkLeft(currentNode)) {
				currentNode.left=new TreeNode(currentNode, null, null, numb);
			}else {
				currentNode=currentNode.getLeft();
				makeMove(currentNode, numb);
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
	
	
	
	
	
	
	
	public static void pre(ArrayList<Integer> list, TreeNode node){
		list.add(node.getData());
		if(node.getLeft()!=null){
			pre(list, node.getLeft());
		}
		if(node.getRight()!=null){
			pre(list, node.getRight());
		}
	}
	
	public static void in(ArrayList<Integer> list, TreeNode node){
		if(node.getLeft()!=null){
			in(list, node.getLeft());
		}
		list.add(node.getData());
		if(node.getRight()!=null){
			in(list, node.getRight());
		}
	}
	
	public static void post(ArrayList<Integer> list, TreeNode node){
		if(node.getLeft()!=null){
			post(list, node.getLeft());
		}
		if(node.getRight()!=null){
			post(list, node.getRight());
		}
		list.add(node.getData());
	}
	
	
	
	
	//preorder: parent, left right
	public static ArrayList<Integer> preOrder(TreeNode head){
		ArrayList<Integer> preOrder=new ArrayList<Integer>();
		pre(preOrder, head);
		return preOrder;
	}
	
	//inorder: left parent right
	public static ArrayList<Integer> inOrder(TreeNode head){
		ArrayList<Integer> inOrder=new ArrayList<Integer>();
		in(inOrder, head);
		return inOrder;
	}
	
	//postorder: left right parent
	public static ArrayList<Integer> postOrder(TreeNode head){
		ArrayList<Integer> postOrder=new ArrayList<Integer>();
		post(postOrder, head);
		return postOrder;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Deletes the node and move the children up appropriately
	public static TreeNode delete(TreeNode head, int number){
		TreeNode current=head;
		String lastMove=null;
		while(!(current.getData()==number)){
			if(number<=current.getData()){
				current=current.getLeft();
				lastMove="l";
			}else {
				current=current.getRight();
				lastMove="r";	
			}
		}
		int test=howManyChildren(current);
		switch(test){
			case 0: noChild(current, lastMove); break;
			case 1: oneChild(current, lastMove); break;
			case 2: current=twoChild(current, lastMove); break;
		}
		
		while(current.getParent()!=null){
			current=current.getParent();
		}
		return current;
	}
	
	
	public static int howManyChildren(TreeNode node){
		if(node.getRight()==null&&node.getLeft()==null){
			return 0;
		}
		else if(node.getRight()!=null&&node.getLeft()!=null){
			return 2;
		}else return 1;
	}
	
	
	public static void noChild(TreeNode node, String lastMove){
		if(lastMove.equals("l")){
			node.getParent().setLeft(null);
		}else node.getParent().setRight(null);

	}
	
	public static void oneChild(TreeNode node, String lastMove){
		if(node.getRight()!=null){
			if(lastMove.equals("l")){
				node.getParent().setLeft(node.getRight());
			}else node.getParent().setRight(node.getRight());
		}
		if(node.getLeft()!=null){
			if(lastMove.equals("l")){
				node.getParent().setLeft(node.getLeft());
			}else node.getParent().setRight(node.getLeft());
		}
	}
	
	public static TreeNode twoChild(TreeNode node, String lastMove){
		TreeNode origNode=node;
		node=node.getLeft();
		while(node.getRight()!=null){
			node=node.getRight();
		}
		origNode.setData(node.getData());
		if(node.getLeft()!=null){
			node.getParent().setRight(node.getLeft());
		}else node.getParent().setRight(null);
		return origNode;
	}	
}


