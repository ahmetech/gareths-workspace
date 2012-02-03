package TreeNode;

public class TreeNode {
	TreeNode parent=null;
	TreeNode right=null;
	TreeNode left=null;
	int data;
	
	public TreeNode(TreeNode paramParent, TreeNode paramRight, TreeNode paramLeft, int paramData){
		parent=paramParent;
		right=paramRight;
		left=paramLeft;
		data=paramData;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}
