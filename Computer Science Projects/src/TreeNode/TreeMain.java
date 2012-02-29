package TreeNode;

import java.util.ArrayList;

public class TreeMain {
	public static void main(String[] args){
		TreeNode head=TreeBuilder.makeTree();
		//Change the number in the paramater to whatever number you want to delete(It must be in input.txt)
		head=TreeBuilder.delete(head, 216);
		ArrayList<Integer> preOrder=TreeBuilder.preOrder(head);
		ArrayList<Integer> inOrder=TreeBuilder.inOrder(head);
		ArrayList<Integer> postOrder=TreeBuilder.postOrder(head);
		
		
		//prints preOrder
		String comma=", ";
		String preOrderString = "";
		for (int i = 0; i < preOrder.size()-1; i++) {
			preOrderString+=preOrder.get(i)+comma;
		}
		preOrderString+=preOrder.get(19);
		System.out.println("PreOrder: "+preOrderString);
		
		
		//prints inOrder
		String inOrderString = "";
		for (int i = 0; i < inOrder.size()-1; i++) {
			inOrderString+=inOrder.get(i)+comma;
		}
		inOrderString+=inOrder.get(19);
		System.out.println("InOrder: "+inOrderString);
		
		//prints postOrder
		String postOrderString = "";
		for (int i = 0; i < postOrder.size()-1; i++) {
			postOrderString+=postOrder.get(i)+comma;
		}
		postOrderString+=postOrder.get(19);
		System.out.println("PostOrder: "+postOrderString);
	}
}
