package TreeNode;

import java.util.ArrayList;

public class TreeMain {
	public static void main(String[] args){
		TreeNode head=TreeBuilder.makeTree();
		ArrayList<Integer> preOrder=TreeBuilder.preOrder(head);
		
		
		
		
		//prints preOrder
		for (int i = 0; i < preOrder.size(); i++) {
			System.out.println();
		}
	}
}
